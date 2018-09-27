<%--
  Created by IntelliJ IDEA.
  User: nine
  Date: 2018/7/7 0007
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户信息</title>
    <link href="css/inside.css" type="text/css" rel="stylesheet">
    <script src="js/js.js" type="text/javascript" charset="utf-8">
    </script>
</head>
<body onload="link_msg_show()">
<div class="_body">


    <div class="header">
        <span class="logop"><a href="index.jsp">YUANZHE</a></span>


        <span class="daohang" onmouseover="mOver(this)" onmouseout="mOut(this)">
             <a href="index.jsp">首页</a>


                <c:if test="${thisUser != null}">
                    <a href="recruitslist" class=" link_thisPage">求职</a>
                    <a href="userinfo.jsp" class="link_userinfo" >我</a>
                    <a href="logout" class="link_logout">登出</a>
                </c:if>

                <c:if test="${thisCmp != null}">
                    <a href="wanttinglist" class="link_thisPage">招聘</a>
                    <a href="userinfo.jsp" class="link_userinfo ">企业</a>
                    <a href="logout" class="link_logout">登出</a>
                </c:if>

                <c:if test="${thisUser == null && thisCmp == null}">
                    <a href="login.jsp" class="link_login">登陆</a>
                </c:if>
            </span>

    </div>



    <div class="content">


        <div class="user_info_div" id="msg_show_div">

            <c:if test="${otherUser != null}">
                <div class="user_info_show">
                    <p class="user_info_show_title">个人信息</p>
                    <p class="user_info_show_p user_name">${otherUser.name}
                        <c:if test="${otherUser.sex == '男'}">
                            <img src="img/male.png">
                        </c:if>
                        <c:if test="${otherUser.sex == '女'}">
                            <img src="img/famale.png">
                        </c:if>
                    </p>
                    <hr>
                    <p class="user_info_show_p"> ${otherUser.sex} <span> | </span> ${otherUser.birth} </p>
                    <p class="user_info_show_title">教育经历</p>
                    <p class="user_info_show_p user_name">${otherUser.educated}</p>
                    <hr>
                    <p class="user_info_show_p"> ${otherUser.school} <span> | </span> ${otherUser.major} </p>
                    <p class="user_info_show_title">联系方式</p>
                    <p class="user_info_show_p user_name">${otherUser.phonenum}</p>
                    <hr>
                    <p class="user_info_show_p"> ${otherUser.email} </p>
                    <p  class="link_user_info_edit_p"><span onclick="link_msg_edit()">发送入职邀请</span></p>
                </div>
            </c:if>


            <c:if test="${otherCmp != null}" >
                <div class="user_info_show">
                    <p class="user_info_show_title">企业信息</p>
                    <p class="user_info_show_p user_name">${otherCmp.fullname}
                    </p>
                    <hr>
                    <p class="user_info_show_p"> ${otherCmp.address} <span> | </span> ${otherCmp.industry} </p>
                    <p class="user_info_show_title">负责人信息</p>
                    <p class="user_info_show_p user_name">${otherCmp.mgrname}</p>
                    <hr>
                    <p class="user_info_show_p"> ${otherCmp.mgrpn}</p>

                    <p class="link_user_info_edit_p"><span onclick="link_msg_edit()">发送入职申请</span></p>
                </div>
            </c:if>
        </div>

        <div class="user_info_div" id="msg_edit_div">

            <form action="msgadd" class="user_info_show" method="post">
                <c:if test="${otherUser != null}">
                    <input value="1" name="type" hidden>
                    <p class="user_reg_title">向${otherUser.name}发送邀请</p>
                    <p class="user_info_show_title">填写邀请信息</p>
                    <hr>
                    <p class="user_edit_p"><input type="text" name="job" placeholder="请输入您要邀请他入职的工作"></p>
                    <p class="user_edit_p"><textarea name="more_info" cols="30" rows="10" placeholder="请输入您的邀请理由"></textarea></p>
                    <p class="user_edit_p_buttun"><input type="submit" value="提交"> <input type="reset" value="重置">
                        <input type="button" value="取消" onclick="link_msg_show()"></p>
                </c:if>

                <c:if test="${otherCmp != null}">
                    <input value="0" name="type" hidden>
                    <p class="user_reg_title">向${otherCmp.fullname}发送申请</p>
                    <p class="user_info_show_title">填写申请信息</p>
                    <hr>
                    <p class="user_edit_p"><input type="text" name="job" placeholder="请输入您要申请的工作"></p>
                    <p class="user_edit_p"><textarea name="more_info" cols="30" rows="10" placeholder="请输入您的申请理由"></textarea></p>
                    <p class="user_edit_p_buttun"><input type="submit" value="提交"> <input type="reset" value="重置">
                        <input type="button" value="取消" onclick="link_msg_show()"></p>
                </c:if>
            </form>

        </div>




        <span class="msg" >${msg}</span>

        <% session.setAttribute("msg",null);%>
    </div>
</div>
</body>
</html>
