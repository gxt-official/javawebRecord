<%--
  Created by IntelliJ IDEA.
  User: mr
  Date: 2019/10/15
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script type="text/javascript">
        function pass() {
            if (checkName() && checkPwd()) {
                return true;
            } else {
                return false;
            }
        }

        function clean() {
            var nameInputObj = document.getElementById("userName").value;
            var s = "请输入用户名";
            if (nameInputObj == s) {
                var input = document.getElementById("userName");
                input.value = "";
            }
        }

        function checkName() {
            var userName = document.getElementById("userName").value;
            var usernameSpan = document.getElementById("usernameSpan");
            if (userName) {
                usernameSpan.innerHTML = "";
                return true;
            } else {
                usernameSpan.innerHTML = "请输入用户名";
                return false;
            }

        }
        function checkPwd() {
            var userPwd = document.getElementById("userPwd").value;
            var pwdSpan = document.getElementById("pwdSpan");
            if (userPwd) {
                pwdSpan.innerHTML = "";
                return true;
            } else {
                pwdSpan.innerHTML = "请输入密码";
                return false;
            }

        }
    </script>

</head>
<body>
<form id="dataForm" name="dataForm" method="post" action="/login" onsubmit="return pass()">
    <table align="center">
        <tr>用户登录：</tr>
        <tr>
            <td>用户名：</td>
            <td>
                <input id="userName" name="userName" value="请输入用户名" onclick="clean()" onblur="checkName()">
                <span id="usernameSpan" style="color: red"></span>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input id="userPwd" name="userPwd" type="password" onblur="checkPwd()">
                <span id="pwdSpan" style="color: red"></span>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>

</form>
</body>
</html>
