//다른 js와 겹치지 않게 따로 index라는 scope선언
var recipeSearch={
    init: function(){
        var _this = this;
        $('#btn-search').on('click', function(){
            // $('#btn-search').sub
            _this.search();
        });
        $('#btn-filter').on('click', function(){
            _this.filtering();
        });
        _this.search();

        // _this.testAdd();
        // _this.make_component();

    },
    urlParam : function(name){
        var url = decodeURIComponent(window.location.href);
        // var url = unescape(window.location.href);
        var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(url);
        if (results==null){
            return null;
        }
        else{
            return results[1] || 0;
        }
    },
    filtering: function(){

        var _this = this;
    //    검색결과 필터링
    //    .hide()를 쓰면 자리 배치가 이상해지니까 (row가 유지됨) 그냥 새로 ajax 검색함

        //만약 체크한거 하나도 없으면 그냥 넘김
        var labels = $('input:checkbox[name="recipe-type"]:checked');
        if(!labels) return;

        //레시피 분류 체크박스 정보 얻어오기
        var filtered = [];
        for(var label of labels){
            $.merge(filtered, label.value.split('/'));
        }

        //result모두 지우기
        var $resultContainer = $("#result-container");
        $resultContainer.empty();
        _this.search(filtered);
    },
    search: function(filtered=[]){
        if(!filtered.length){
            filtered = ['국','탕','찌개','면','밀가루','밥','죽','떡','반찬','양식'];
        }

        //ajax로 레시피 검색
        //clone 카드
        //url param으로 값 얻어와서 ajax통신
        var searchString = this.urlParam('searchString');
        console.log(searchString);

        //searchString을 배열로 변환 + 빈칸지우기
        var items = $.map(searchString.split(','), (x)=>{return x.replace('+','')})
        console.log(items);
        var req = {
            searchString: searchString,
            items: items
        };

        //ajax통신
        $.ajax({
            type: 'POST',
            url: '/api/v1/recipe/search',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(req)
        }).done(function (data) {
            //data: json object list
            console.log('filter:' + filtered);

            console.log('filter전'+ data.length);
            //TODO:data에서 filter에 해당하는것만 고르기
            data = $.grep(data, function(value,index){
                console.log('idx,val:'+index + ','+ value);
                return ($.inArray(value["category"], filtered)>-1);
            });

            //data 열 개수 구하기 . 소수점임
            // var rows = Math.floor((data.length + 2) / 3);
            var rows = data.length/3;
            console.log(rows);
            console.log(data.length);

            for(let  i = 0; i<rows; i+=1){
                let  $row = $("<div>").addClass('row');
                    // '<div class = "row" ></div>';
                for(let  j = 0; j<3; j+=1){
                    let idx = i * 3 + j;
                    console.log('row, idx:'+i+' '+idx);
                    if(idx >= data.length) break;
                    console.log(data[idx]["food"]);
                    let $card = $('#card-template').clone(true).addClass('col-4').addClass('results');
                    $card.find('.card-title').text(data[idx]["food"]);
                        // .find('.category').text(data[idx]["category"]);
                    $card.find('.category').text(data[idx]["category"]);
                    $card.show();
                    $row.append($card);
                    // $card.select('.card-title').text = data[idx]["food"];
                    // let  $col = '<div class = "col-4">'+data[idx]["food"]+'</div>';
                    // let  $col = '<div class = "col-4">'+$card+'</div>';
                    // $row += $col;
                }
                // $row += '</div>';
                $("#result-container").append($row);
            }
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });




    },
    testAdd : function(){
        //url param으로 값 얻어와서 ajax통신
        var searchString = this.urlParam('searchString');
        console.log(searchString);

        //searchString을 배열로 변환 + 빈칸지우기
        var items = $.map(searchString.split(','), (x)=>{return x.replace('+','')})
        console.log(items);
        var req = {
            searchString: searchString,
            items: items
        };

        //ajax통신
        $.ajax({
            type: 'POST',
            url: '/api/v1/recipe/search',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(req)
        }).done(function (data) {
            //data: json object list

            //data 열 개수 구하기 . 소수점임
            // var rows = Math.floor((data.length + 2) / 3);
            var rows = data.length/3;
            console.log(rows);
            console.log(data.length);

            for(let  i = 0; i<rows; i+=1){
                let  $row = '<div class = "row" >';
                for(let  j = 0; j<3; j+=1){
                    let idx = i * 3 + j;
                    console.log('row, idx:'+i+' '+idx);
                    if(idx >= data.length) break;
                    console.log(data[idx]["food"]);
                    let  $col = '<div class = "col-4">'+data[idx]["food"]+'</div>';
                    $row += $col;
                }
                $row += '</div>';
                $("#test").append($row);
            }
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    make_component: function(){
        //TODO: param으로 검색 string 가져오기
    },
    save: function(){
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/recipeBoard';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update: function(){
        var data={
            title:$('#title').val(),
            content:$('#content').val()
        };
        var id = $('#id').val();

        $.ajax({
            type:'PUT',
            url:'/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 수정되었습니다.');
            window.location.href='/recipeBoard';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
    delete: function(){
        var id = $('#id').val();
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'applicatoin/json; charset=utf-8'
        }).done(function(){
            alert('글이 삭제되었습니다.');
            window.location.href = '/recipeBoard';
        }).fail(function(error){
            alert(JSON.stringify(error))
        });
    }

};

recipeSearch.init();