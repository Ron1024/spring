$(document).ready(function(){
    //设置当前登陆人员信息

    //设置左侧导航栏信息
    $("#side-menu").load("getLeftSide");
    //设置内容显示区域信息
    $("#dashboardEcommerce").load("dashboardEcommerce");

});

/**
 * 改变中心显示区域内容
 */
function changeWrapper(id) {
    //先清除中心区域内容
    $("#wrapperContainer").html("");
    //根据请求URL加载中心区域内容


}