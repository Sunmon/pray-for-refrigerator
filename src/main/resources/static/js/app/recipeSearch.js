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
        _this.initInput();
        // $('#searchInput').on('keydown', function(e){_this.validateForm(e);});
        // $('#searchInput').text(_this.urlParam('searchString'));
        // $('#searchInput').val(_this.urlParam('searchString'));
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
        $resultContainer.find("#result-cards").empty();
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
            data = $.grep(data, function(value,index){
                console.log('idx,val:'+index + ','+ value);
                return ($.inArray(value["category"], filtered)>-1);
            });

            //TODO: 검색 결과 개수 span 채우기
            var $result_text = $('#result-text');
            $result_text.find('h3').text(data.length).addClass('d-inline-block text-info font-weight-bold');

            //data 열 개수 구하기 . 소수점임
            // var rows = Math.floor((data.length + 2) / 3);
            var rows = data.length/3;
            console.log(rows);
            console.log(data.length);

            //임시객체
            var imgs = ['http://placehold.it/320x100','http://placehold.it/250x250', 'http://placehold.it/100x120'];
            for(let  i = 0; i<rows; i+=1){
                let  $row = $("<div>").addClass('row col-12 justify-content-around my-5 mr-auto ml-auto');
                    // '<div class = "row" ></div>';
                for(let  j = 0; j<3; j+=1){
                    let idx = i * 3 + j;
                    console.log('row, idx:'+i+' '+idx);
                    if(idx >= data.length) break;
                    console.log(data[idx]["food"]);
                    let $card = $('#card-template').clone(true).addClass('col-3 mr-auto ml-auto').addClass('results');
                    $card.find('.card-title').text(data[idx]["food"]);
                        // .find('.category').text(data[idx]["category"]);
                    $card.find('.category').text(data[idx]["category"]);
                    $card.find('.card-img-top').attr('src',imgs[1]);    //TODO: data의 이미지 링크로 attr로 바꾸기
                    //TODO: width height 같게
                    var ing_list = data[idx]["ingredient"];
                    for(var ing of ing_list){
                        console.log("ing:"+ing);
                        var $span = $("<span>").addClass('font-italic mr-1 ml-1').text('#'+ ing);
                        // var $span = $("<button>").addClass('font-italic mr-1 ml-1').text(ing);
                        // var $span = $("<span>").addClass('font-italic mr-1 ml-1').text(ing);
                        //button으로!
                        if($.inArray(ing, items) > -1) $span.addClass('btn btn-info btn-sm text-light my-1').css('pointer-events', 'none');
                        // else $span.addClass('btn btn-secondary btn-sm text-light');
                        //그냥
                        // if($.inArray(ing, items) > -1) $span.addClass('rounded-circle bg-info text-light');
                        else $span.addClass('btn btn-secondary btn-sm text-light').css('pointer-events', 'none');
                        // var $span = $("<span>").text(ing);
                        $card.find('.ingredients').append($span);

                    }

                    // $card.find('.ingredient')
                        // .css('max-height', '50%');
                    // $card.find('.card-img-top').attr('src',data[idx]["img"]);
                    $card.show();
                    $row.append($card);
                    // $card.select('.card-title').text = data[idx]["food"];
                    // let  $col = '<div class = "col-4">'+data[idx]["food"]+'</div>';
                    // let  $col = '<div class = "col-4">'+$card+'</div>';
                    // $row += $col;
                }
                // $row += '</div>';
                $("#result-cards").append($row);
            }
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    replaceAll: function(str, searchStr, replaceStr){
        return str.split(searchStr).join(replaceStr);
    },
    initInput: function(){
        var _this = this;
        var param = _this.urlParam('searchString');
        param = _this.replaceAll(param, '+', ' ');
        var $searchInput = $('#searchInput');
        $searchInput.val(param);

        //검색하는 값 없을 때 검색 막기
        var $button = $('#form_search button');
        $button.on('click', function(){
            // console.log('clicked!');
            if($searchInput.val()) $('#form_search').submit();
        });
        $searchInput.on('keydown', function(e){if(e.key === "Enter") $button.click();});
    },
    validateForm: function(e) {
        if(!$('#searchInput').val()) return;
        if (e.key === "Enter")
        {
            $('#form_search').submit();
        }
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