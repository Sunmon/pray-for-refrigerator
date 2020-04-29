//다른 js와 겹치지 않게 따로 index라는 scope선언
var index = {
    init: function () {
        var _this = this;
        $(window).on('scroll', function(){_this.scrollEffect();});
        $('#searchInput').on('keydown', function(e){_this.validateForm(e);});
        $('#btn-search').on('click', function(){
            $('#searchInput').focus();
        });
    },
    scrollEffect: function() {
        // $(window).on('scroll', function () {
        if ($(window).scrollTop() > 10) {
            $('nav').removeClass('navbar-dark');
            $('nav').addClass('navbar-light shadow bg-light');

        } else {
            $('nav').removeClass('navbar-light shadow bg-light');
            $('nav').addClass('navbar-dark');

        }
    },
    validateForm: function(e) {
        // console.log(e.key);
        if(!$('#searchInput').val()) return;
        if (e.key === "Enter")
        {
            $('#form_search').submit();
        }
    }
};

    // $('.navTrigger').click(function () {
    // $(this).toggleClass('active');
    // console.log("Clicked menu");
    // $("#mainListDiv").toggleClass("show_list");
    // $("#mainListDiv").fadeIn();
    // bg-light shadow

index.init();