<%@ page import="java.util.List" %>
<%@ page import="cn.kgc.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mr
  Date: 2019/10/15
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>注册成功</title>
    <%
        request.setCharacterEncoding ("utf-8");
        String name = request.getParameter ("userName");
        String pwd = request.getParameter ("pwd");

//        List<User> users = (List<User>) request.getAttribute ("info");
        out.print ("<span style='color:red;'>用户名："+name+"</span><br />");
        out.print ("<span style='color:red;'>密码："+pwd+"</span><br />");
    %>
    <script type="text/javascript">
        function update() {
            var id = document.getElementById("id");
            var userId = id.innerText;
            alert(userId);
            window.open("http://localhost:8080/update?id=" + userId, "_self");
        }
        function deleteInfo() {

        }
    </script>
    <style type="text/css">
        td {
            border: 1px red solid;
            margin: 10px;
            padding: 10px;
            text-align: center;
        }
        table {
            text-align: center;
            border: 1px red solid;
            margin: 0px;
            padding: 0px;
        }
    </style>
</head>
<body>
<table id="show" align="center">
    <tr align="center">
        <td>序号</td>
        <td>用户名</td>
        <td>密码</td>
        <td>性别</td>
        <td>爱好</td>
        <td>按钮</td>
    </tr>
    <c:forEach var="user" items="${info}" varStatus="status">
    <tr align="center">
        <td id="id">${user.id}</td>
        <td>${status.count}</td>
        <td>${user.username}</td>
        <td>${user.pwd}</td>
        <td>${user.sex}</td>
        <td>${user.hobby}</td>
        <td>
            <button onclick="update();" value="修改">修改</button>
            <button onclick="deleteInfo();" value="删除">删除</button>
        </td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
