$(".sidebar-menu").on("click", function (t) {
    var n = $("#sidebar").hasClass("menu-compact");
    var i = $(t.target).closest("a"), u, r, f;
    if (i && i.length != 0) {
        if (!i.hasClass("menu-dropdown"))
            return n && i.get(0).parentNode.parentNode == this && (u = i.find(".menu-text").get(0),
            t.target != u && !$.contains(u, t.target)) ? !1 : void 0;
        if (r = i.next().get(0),
            !$(r).is(":visible")) {
            if (f = $(r.parentNode).closest("ul"),
            n && f.hasClass("sidebar-menu"))
                return;
            f.find("> .open > .submenu").each(function () {
                this == r || $(this.parentNode).hasClass("active") || $(this).slideUp(200).parent().removeClass("open")
            })
        }
        return n && $(r.parentNode.parentNode).hasClass("sidebar-menu") ? !1 : ($(r).slideToggle(200).parent().toggleClass("open"),
            !1)
    }
});
