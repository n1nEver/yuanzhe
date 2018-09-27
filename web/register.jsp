<%--
  Created by IntelliJ IDEA.
  User: nine
  Date: 2018/7/3 0003
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户注册</title>
    <link href="css/inside.css" type="text/css" rel="stylesheet">
    <script src="js/js.js" type="text/javascript" charset="utf-8">
    </script>
</head>
<body onload="link_reg_user()">
<div class="_body">


    <div class="header">
        <span class="logop"><a href="index.jsp">YUANZHE</a></span>


        <span class="daohang" onmouseover="mOver(this)" onmouseout="mOut(this)">
           <a href="index.jsp">首页</a>


                <c:if test="${thisUser != null}">
                    <a href="recruits.jsp">求职</a>
                    <a href="userinfo.jsp" class="link_userinfo">我</a>
                    <a href="logout" class="link_logout">登出</a>
                </c:if>

                <c:if test="${thisCmp != null}">
                    <a href="wantting.jsp">招聘</a>
                    <a href="userinfo.jsp" class="link_userinfo">企业</a>
                    <a href="logout" class="link_logout">登出</a>
                </c:if>

                <c:if test="${thisUser == null && thisCmp == null}">
                    <a href="login.jsp" class="link_login">登陆</a>
                </c:if>

            </span>



    </div>

    <div class="content">
        <div class="user_info_div" id="user_reg_div">
            <form action="register" class="user_info_show" method="post">
                <input value="1" name="type" hidden>
                <p class="msg">${msg}</p>
                <p class="link_user_info_edit_p"><span  onclick="">个人注册</span> <span> | </span> <span onclick="link_reg_cmp()">企业注册</span></p>
                <p class="user_info_reg_title user_reg_title">个人注册</p>


                <p class="user_info_show_title">登陆信息</p>
                <hr>
                <p class="user_edit_p ">手机号:<input type="text" name="phonenum" placeholder="请填写可用手机号" minlength="11" maxlength="11">*</p>
                <p class="user_edit_p ">密码:<input type="password" name="newpasswd" placeholder="请输入密码" >*</p>
                <p class="user_edit_p ">确认密码:<input type="password" name="newpasswd2" placeholder="请再次输入密码" >*</p>


                <p class="user_info_show_title">个人信息</p>
                <hr>
                <p class="user_edit_p ">姓名:<input type="text" name="name" placeholder="请填写真实姓名" ></p>

                <p class="user_edit_p_radio">
                        性别:
                        <input type="radio" name="sex" value="男" checked="checked">男
                        <input type="radio" name="sex" value="女">女
                </p>
                <p class="user_edit_p">生日:<input type="date" name="birth" placeholder="请选择出生日期" value="2000-01-01"></p>

                <p class="user_info_show_title">教育经历</p>
                <hr>
                <p class="user_edit_p">学历:
                    <select name="educated" >
                        <option value="初中">初中</option>
                        <option value="高中">高中</option>
                        <option value="本科">本科</option>
                        <option value="硕士">硕士</option>
                        <option value="博士">博士</option>
                    </select>
                </p>
                <p class="user_edit_p">学校:<input type="text" name="school" placeholder="请填写毕业学校"></p>
                <p class="user_edit_p">专业:<input type="text" name="major" placeholder="请填写专业"></p>

                <p class="user_info_show_title">联系方式</p>
                <hr>
                <p class="user_edit_p">邮箱:<input type="email" name="email" placeholder="请填写常用邮箱"></p>
                <p class="user_edit_p_buttun"><input type="submit" value="提交"> <input type="reset" value="重置">
                    <input type="button" value="取消" onclick="link_user_info_show()"></p>
            </form>
        </div>

        <div class="user_info_div" id="cmp_reg_div">
            <form action="register" class="user_info_show" method="post">
                <input value="0" name="type" hidden>
                <p class="link_user_info_edit_p"><span  onclick="link_reg_user()">个人注册</span> <span> | </span> <span onclick="">企业注册</span></p>
                <p class="user_info_reg_title user_reg_title">企业注册</p>


                <p class="user_info_show_title">登陆信息</p>
                <hr>
                <p class="user_edit_p ">登陆账号:<input type="text" name="loginname" placeholder="请填写登陆账号(字母或数字组成)" >*</p>
                <p class="user_edit_p ">密码:<input type="password" name="newpasswd" placeholder="请输入密码" >*</p>
                <p class="user_edit_p ">确认密码:<input type="password" name="newpasswd2" placeholder="请再次输入密码" >*</p>


                <p class="user_info_show_title">企业信息</p>
                <hr>
                <p class="user_edit_p ">企业:<input type="text" name="fullname" placeholder="请填写企业全称"></p>
                <p class="user_edit_p">行业:<input type="text" name="industry" placeholder="请填写企业行业"></p>
                <p class="user_edit_p">地址:<input type="text" name="address" placeholder="请填写公司所在地"></p>

                <p class="user_info_show_title">负责人信息</p>
                <hr>
                <p class="user_edit_p ">姓名:<input type="text" name="mgrname" placeholder="请填写负责人真实姓名"></p>
                <p class="user_edit_p">手机号:<input type="text" name="mgrpn" placeholder="请填写负责人手机号"></p>
                <p class="user_edit_p_buttun"><input type="submit" value="提交"> <input type="reset" value="重置">
                    <input type="button" value="取消" onclick="link_user_info_show()"></p>
            </form>
        </div>
    </div>
</div>
<%session.setAttribute("msg",null);%>
</body>
</html>
