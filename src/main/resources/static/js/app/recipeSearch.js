//다른 js와 겹치지 않게 따로 index라는 scope선언
var recipeSearch = {
    search_data : [],   //rest search result object
    init:         function () {
        var _this = this;
        $('#btn-search').on('click', function () {
            _this.search();
        });
        $('#btn-filter').on('click', function () {
            _this.filtering();
        });
        _this.search();
        _this.fillInputVal();
    },
    urlParam:     function (name) {
        var url = decodeURIComponent(window.location.href);
        // var url = unescape(window.location.href);
        var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(url);
        if (results == null) {
            return null;
        } else {
            return results[1] || 0;
        }
    },
    filtering:    function () {
        //    검색결과 필터링

        var _this = this;
        //    .hide()를 쓰면 자리 배치가 이상해지니까 (row가 유지됨) 그냥 새로 ajax 검색함

        //만약 체크한거 하나도 없으면 그냥 넘김
        var labels = $('input:checkbox[name="recipe-type"]:checked');
        if (!labels) return;

        //레시피 분류 체크박스 정보 얻어오기
        var filtered = [];
        for (var label of labels) {
            $.merge(filtered, label.value.split('/'));
        }

        //result모두 지우기
        var $resultContainer = $("#result-container");
        $resultContainer.find("#result-cards").empty();
        _this.search(filtered);
    },
    search:       function (filtered = []) {
        if (!filtered.length) {
            filtered = ['국', '탕', '찌개', '면', '밀가루', '밥', '죽', '떡', '반찬', '양식'];
        }

        //ajax로 레시피 검색
        //clone 카드
        //url param으로 값 얻어와서 ajax통신
        var searchString = this.urlParam('searchString');
        console.log(searchString);

        //searchString을 배열로 변환 + 빈칸지우기
        var items = $.map(searchString.split(','), (x) => {
            return x.replace('+', '');
        })
        console.log(items);
        var req = {
            searchString: searchString,
            items:        items
        };

        //ajax통신
        $.ajax({
            type:        'POST',
            url:         '/api/v1/recipe/search',
            dataType:    'json',
            contentType: 'application/json; charset=utf-8',
            data:        JSON.stringify(req)
        }).done(function (data) {
            //data: json object list
            // console.log('filter:' + filtered);

            // console.log('filter전'+ data.length);
            // var _data = this.search_data;

            //TODO: search_data 전역변수로 설정
            // this.search_data = data;
            data = $.grep(data, function (value, index) {
                console.log('idx,val:' + index + ',' + value);
                return ($.inArray(value["category"], filtered) > -1);
            });

            //검색어-재료 겹치는 개수 저장
            for(let _data of data){
                let ing_list = _data.ingredient;
                let p_num=0;
                for(let ing of ing_list){
                    if($.inArray(ing, items)>-1) p_num+=1;
                }
                _data.p_num=num;
            }

            //재료 많이 겹치는 순으로 sort (내림차순)
            data.sort(function(a,b) {
                return b.p_num - a.p_num;
            });

            var $result_text = $('#result-text');
            $result_text.find('h3').text(data.length).addClass('d-inline-block text-info font-weight-bold');

            //img 임시객체
            var imgs = ['http://placehold.it/320x100', 'http://placehold.it/250x250', 'http://placehold.it/100x120'];
            let data_len = data.length;
            let $row = $("<div>").addClass('row col-12 justify-content-around my-5 mr-auto ml-auto');
            for (let idx in data) {
                //3개 채웠으면 div나누기
                if (idx > 0 && idx % 3 == 0) $row.append($('<div>').addClass('w-100'));
                //아직 아니면 그냥 붙이기
                let $card = $('#card-template').clone(true).addClass('col-8 col-md-3 mr-auto ml-auto mb-3 mb-md-5').addClass('results');
                $card.find('.card-title').text(data[idx]["food"]);
                $card.find('.category').text(data[idx]["category"]);

                //사진
                let imgUrl = data[idx]["img"];
                if(!imgUrl) imgUrl = imgs[1];
                $card.find('.card-img-top').attr('src', imgUrl);    //TODO: data의 이미지 링크로 attr로 바꾸기
                //TODO: width height 같게
                var ing_list = data[idx]["ingredient"];
                for (var ing of ing_list) {
                    console.log("ing:" + ing);
                    var $span = $("<span>").addClass('font-italic my-1 mr-1 ml-1').text('#' + ing);
                    if ($.inArray(ing, items) > -1) $span.addClass('btn btn-info btn-sm text-light').css('pointer-events', 'none');
                    else $span.addClass('btn btn-secondary btn-sm text-light').css('pointer-events', 'none');
                    $card.find('.ingredients').append($span);
                    $card.show();
                    $row.append($card);
                }
            }
            $("#result-cards").append($row);

        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    replaceAll:   function (str, searchStr, replaceStr) {
        return str.split(searchStr).join(replaceStr);
    },
    fillInputVal: function () {
        var _this = this;
        var param = _this.urlParam('searchString');
        param = _this.replaceAll(param, '+', ' ');
        var $searchInput = $('#searchInput');
        $searchInput.val(param);

        //검색하는 값 없을 때 검색 막기
        var $button = $('#form_search button');
        $button.on('click', function () {
            // console.log('clicked!');
            if ($searchInput.val()) $('#form_search').submit();
        });
        $searchInput.on('keydown', function (e) {
            if (e.key === "Enter") $button.click();
        });
    }
};

recipeSearch.init();