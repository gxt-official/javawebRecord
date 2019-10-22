<%--
  Created by IntelliJ IDEA.
  User: mr
  Date: 2019/10/14
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function pass() {
            if (checkName() && checkPwd() && checkRepwd() && checkSex() && checkHobby()) {
                alert("注册成功！");
                return true;
            } else {
                return false;
            }
        }

        function clean() {
            var nameInput = document.getElementById("name").value;
            var s = "请输入用户名";
            if (nameInput == s) {
                var input = document.getElementById("name");
                input.value = "";
            }
        }

        function checkName() {
            var nameObj = document.getElementById("name").value;
            //正则表达式非空格
            var patt = /^[^ ]{1,}$/;
            var result = patt.test(nameObj);
            var nameSpan = document.getElementById("nameSpan");
            if (result) {
                nameSpan.innerText = "";
                return true;
            } else {
                nameSpan.innerText = "用户名不能为空且不能有空格";
                return false;
            }
        }

        function checkPwd() {
            var pwdObj = document.getElementById("pwd").value;
            var patt = /^\d+$/;
            var result = patt.test(pwdObj);
            var pwdSpan = document.getElementById("pwdSpan");
            if (result) {
                pwdSpan.innerHTML = "";
                return true;
            } else {
                pwdSpan.innerHTML = "密码不能为空且只能为数字";
                return false;
            }
        }
        ""
        function checkRepwd() {
            var repwdObj = document.getElementById("repwd").value;
            var patt = /^\d+$/;
            var result = patt.test(repwdObj);
            var repwdSpan = document.getElementById("repwdSpan");
            if (result) {
                var pwdObj = document.getElementById("pwd").value;
                if (repwdObj === pwdObj) {
                    repwdSpan.innerHTML = "";
                    return true;
                } else {
                    repwdSpan.innerHTML = "两次密码不一致";
                    return false;
                }
            } else {
                repwdSpan.innerHTML = "确认密码不能为空且只能为数字";
                return false;
            }
        }

        function checkSex() {
            var flag = false;
            var sexObj = document.getElementsByName("sex");
            for (var i = 0; i < sexObj.length; i++) {
                if (sexObj[i].checked) {
                    flag = true;
                    break;
                }
            }
            var sexSpan = document.getElementById("sexSpan");
            if (flag) {
                sexSpan.innerHTML = "";
                return true;
            } else {
                sexSpan.innerHTML = "性别为必选项";
                return false;
            }
        }

        function checkHobby() {
            var flag = false;
            var hobbyObj = document.getElementsByName("hobby");
            for (var i = 0; i < hobbyObj.length; i++) {
                if (hobbyObj[i].checked) {
                    flag = true;
                    break;
                }
            }
            var hobbySpan = document.getElementById("hobbySpan")
            if (flag) {
                hobbySpan.innerHTML = "";
                return true;
            } else {
                hobbySpan.innerHTML = "兴趣至少挑一个";
                return false;
            }
        }

    </script>

</head>
<body>
<form name="dataForm" id="dataForm" method="post" action="/register" onsubmit="return pass()">
    <table align="center">
        <tr align="center">
            <td>======用户注册======</td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td>
                <input id="name" name="userName" value="请输入用户名" onclick="clean()" onblur="checkName()">
                <span id="nameSpan" style="color: red;"></span>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input id="pwd" name="pwd" type="password" onblur="checkPwd()">
                <span id="pwdSpan" style="color: red;"></span>
            </td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td>
                <input id="repwd" name="repwd" type="password" onblur="checkRepwd()">
                <span id="repwdSpan" style="color: red;"></span>
            </td>
        </tr>
        <tr>
            <td>性别：</td>
            <td><input type="radio" name="sex" value="man" onblur="checkSex()">男
                <input type="radio" name="sex" value="woman" onblur="checkSex()">女<span id="sexSpan"></span></td>
        </tr>
        <tr>
            <td>爱好：</td>
            <td>
                <input type="checkbox" name="hobby" value="sport" onclick="checkHobby()">运动
                <input type="checkbox" name="hobby" value="game" onclick="checkHobby()">游戏
                <input type="checkbox" name="hobby" value="sleep" onclick="checkHobby()">睡觉
                <span id="hobbySpan"></span>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"> </td>
            <td><input type="reset" value="重置"> </td>
        </tr>
    </table>
</form>
</body>
</html>
