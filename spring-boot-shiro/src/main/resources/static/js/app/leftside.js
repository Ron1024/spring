$(document).ready(function () {
    //获取当前登陆用户信息

    //加载左侧边栏
    $.ajax({
        type: "POST",
        url: "../permission/getPermissionsByUserName",
        data: {userName: '1'},
        dataType: "json",
        success: function (data) {
            if (data.hasChildren) {
               for (var node in data.children){
                   console.log(node)
               }
            }else {
                console.log("权限树加载失败，请重新加载")
            }
        }
    });
});