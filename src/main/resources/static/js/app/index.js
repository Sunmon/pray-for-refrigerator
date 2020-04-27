//다른 js와 겹치지 않게 따로 index라는 scope선언
var index = {
    init:          function () {
        var _this = this;
        $(window).on('scroll', function(){_this.scrollEffect()});
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
    validateForm: function() {
        //TODO: form 내용 확인해서 비면 안넘어가게
    var x = $('searchInput').value();   
    if (x == "") {
        alert("Name must be filled out");
        return false;
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