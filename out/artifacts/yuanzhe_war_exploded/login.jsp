<%--
  Created by IntelliJ IDEA.
  User: nine
  Date: 2018/6/30 0030
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- <link href="css/1.css" type="text/css" rel="stylesheet"> -->
<html>
<head>

    <title>登陆愿者</title>
    <link href="css/main.css" type="text/css" rel="stylesheet">
    <script src="js/js.js" type="text/javascript" charset="utf-8">
    </script>
</head>






<body class="page-sign">


<div class="sign-box">


    <div class="sign-form sign-usr" id="usr">

        <p class="title">登录愿者</p>

        <div class="sign-box1">

            <div class="links">
            <span class="link-usr link-on">个人登录</span>
            <span class="link-cmp" id="cmp-link" onclick="link_login_cmp()">企业登录</span>
            </div>

            <form action="logincheck" name="userlogin" method="post">
                <input name="loginType" value="1" hidden>
                <div class="inputs">
                    <input type="text"  onKeyUp="value=value.replace(/[^\d]/g,'')" name="username" class="sign-input-box" placeholder="手机号" maxlength="11" minlength="11">
                </div>

                <div class="inputs">
                    <input type="password" name="passwd" class="sign-input-box" placeholder="密码">
                </div>

                <div class="inputs">
                    <input type="text" name="checkcode" class="sign-input-box sign-checkcode-box" placeholder="验证码" maxlength="4">
                    <img id="imageCode1" onclick="changeImage()" src="checkcode">
                </div>

                <div class="inputs">
                    <input type="submit" class="sign-input-box submit" value="登陆">
                </div>

            </form>
            <p class="info">没有账号？<a href="register.jsp">立即注册！</a></p>
        </div>
    </div>

    <div class="sign-form sign-cmp" id="cmp">

        <p class="title">登录愿者</p>

        <div class="sign-box1">

            <div class="links">
            <span class="link-usr " id="usr-link" onclick="link_login_user()">个人登录</span>
            <span class="link-cmp link-on" >企业登录</span>
            </div>


            <form action="logincheck" name="userlogin" method="post">
                <input name="loginType" value="0" hidden>
                <div class="inputs">
                    <input type="tel" name="username" class="sign-input-box" placeholder="用户名">
                </div>

                <div class="inputs">
                    <input type="password" name="passwd" class="sign-input-box" placeholder="密码">
                </div>

                <div class="inputs inputs-check">
                    <input type="text" name="checkcode" class="sign-input-box sign-checkcode-box" placeholder="验证码" maxlength="4">
                    <img id="imageCode2" onclick="changeImage()" src="checkcode">
                </div>

                <div class="inputs">
                    <input type="submit" class="sign-input-box submit" value="登陆">
                </div>

            </form>
            <p class="info">没有账号？<a href="register.jsp">立即注册！</a></p>


        </div>



    </div>

    <p class="msg">${msg}</p>
</div>

</body>
</html>
