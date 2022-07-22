<%--
  Created by IntelliJ IDEA.
  User: qing'yang
  Date: 2022/7/21
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.js"></script>
    <script>
        $(function () {
            // 查询国家  展示到countryselect选择框 <option value = '1'>中国</option>
            $.getJSON("CountryServlet",function (data) {
                // str 所有的选项
                var str = "";
                for (var i = 0; i < data.length; i++) {
                    str += "<option value = '"+data[i].id+"'>"+ data[i].name +"</option>"
                }
                // 获取到国家的下拉选择框  拼接str
                $("#countryselect").html($("#countryselect").html()+str);
            });
            // 选择某个国家  触发函数  查询所有城市  值改变 异步加载城市
            $("#countryselect").change(function () {
                var countryId = $("#countryselect").val();
                $.getJSON("CityServlet",{"countryId":countryId},function (data) {
                    if(data.length>0){
                        var str = "";
                        for (var i = 0; i < data.length; i++) {
                            str += "<option value = '"+data[i].id+"'>"+ data[i].name +"</option>";
                        }
                        $("#cityselect").html(str);
                    }else {
                        $("#cityselect").html("<option value='0'>-请选择-</option>")
                    }
                })
            })
        })
    </script>
</head>
<body>
    国家:
    <select name="countryselect" id="countryselect">
        <option value="0">-请选择-</option>
    </select>
    城市:
    <select name="cityselect" id="cityselect">
        <option value="0">-请选择-</option>
    </select>
</body>
</html>
