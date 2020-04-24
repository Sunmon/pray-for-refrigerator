//다른 js와 겹치지 않게 따로 index라는 scope선언
var index = {
    init:          function () {
        var _this = this;
        _this.nav_toggle();
        // _this.scroll_effect();
    },
    nav_toggle:    function () {
        $(".menu-icon").on("click", function () {
            $("nav ul").toggleClass("showing");
        });
    },
    scroll_effect: function () {
        // $(window).on("scroll", function () {
            // index.scroll_effect();
            if ($(window).scrollTop()) {
                $('nav').addClass('black');
            } else {
                $('nav').removeClass('black');
            }
        // });
    }
};

// $(document).ready(function () {
//     $(".menu-icon").on("click", function () {
//         $("nav ul").toggleClass("showing");
//     });
// });

// Scrolling Effect

$(window).on("scroll", function () {
    index.scroll_effect();
//     // if ($(window).scrollTop()) {
//     //     $('nav').addClass('black');
//     // } else {
//     //     $('nav').removeClass('black');
//     // }
});

index.init();