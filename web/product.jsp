<%--
  Created by IntelliJ IDEA.
  User: qing'yang
  Date: 2022/7/21
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.js"></script>
    <script>
        $(function () {
            // keyup 键盘抬起
            $("#productname").keyup(function () {
                // 获取数据
                var productname = $("#productname").val();
                var reg = /^[\u4e00-\u9f5a]+$/;
                if (reg.test(productname)) {
                    // ajax发请求 响应数据
                    $.getJSON("ProductServlet", {"productname": productname}, function (data) {
                        var str = "";
                        for (var i = 0; i < data.length; i++) {
                            // 所有内容展示到div中
                            str += "<div>" + data[i].productname + "</div>";
                        }
                        // 获取div标签 str放置到div中
                        $("#div").html(str);
                    })
                }
            })
            // 鼠标点击事件
            $("#div").click(function (e) {
                // 获取到事件源对象
                var t = e.target;
                // 点击div中的内容显示在input输入框中
                $("#productname").val($(t).html());
                // 清除div中内容
                $("#div").html("");
            })
            // 鼠标移入鼠标移出 js对象 进行转化 jquery对象  背景颜色
            $("#div").mouseover(function (e) {
                var t = e.target;
                $(t).css('backgroundColor', 'yellow');
            })
            $("#div").mouseout(function (e) {
                var t = e.target;
                $(t).css('backgroundColor', 'white');
            })
        })
    </script>
</head>
<body>
<input type="text" style="width: 250px" name="productname" id="productname" placeholder="请输入产品名称">
<div id="div" style="width: 250px"></div>
</body>
</html>
