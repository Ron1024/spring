function login() {
    var username = $("#inputText").val();
    var password = $("#inputPassword").val();
    var rememberMe = $("#rememberMe").is(':checked');
    $.ajax({
        type: "post",
        url: "/ajaxLogin",
        data: {
            "userName": username,
            "password": password,
            "rememberMe": rememberMe
        },
        dataType: "json",
        success: function (r) {
            if (r.code === 0) {
                location.href="/common/gotoMainPage";
            } else {
                alert(r.msg);
            }
        }
    });
}
