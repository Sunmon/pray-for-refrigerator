//다른 js와 겹치지 않게 따로 index라는 scope선언
var recipeSearch={
    init: function(){
        var _this = this;
        $('#btn-search').on('click', function(){
            // $('#btn-search').sub
            _this.search();
        });
        _this.testAdd();
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
    //TODO: 만약 안되면 RequestDTO내용에 split도 미리 해서 json으로 보내기
    search: function(){



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