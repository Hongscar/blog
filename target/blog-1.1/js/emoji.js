var a_idx = 0;

;!function () {
    $(document).on('click', ' body', function (e) {
        var a = ["（*@ο@*）", "（⊙o⊙）", "★~★", "(*^‧^*)", "（ˇ＾ˇ〉", "~>_<~+", "(≥◇≤)",
            "（*>.<*）", ">_<|||", "→_→", "└(^o^)┘", " (*^__^*)"];
        var $i = $("<span></tagObj>").text(a[a_idx]);
        a_idx = (a_idx + 1) % a.length;
        var x = e.pageX,
            y = e.pageY;
        $i.css({
            "z-index": 999999999999999999999999999999999999999999999999999999999999999999999,
            "top": y - 20,
            "left": x,
            "position": "absolute",
            "font-weight": "bold",
            "color": "#ff6651"
        });
        $("body").append($i);
        $i.animate({
                "top": y - 180,
                "opacity": 0
            },
            1500,
            function () {
                $i.remove();
            });
    });
}();