<%--
  Created by IntelliJ IDEA.
  User: nine
  Date: 2018/7/5 0005
  Time: 3:06
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
<body onload="link_user_info_show()">
<div class="_body">


    <div class="header">
        <span class="logop"><a href="index.jsp">YUANZHE</a></span>


        <span class="daohang" onmouseover="mOver(this)" onmouseout="mOut(this)">
             <a href="index.jsp">首页</a>


                <c:if test="${thisUser != null}">
                    <a href="recruitslist">求职</a>
                    <a href="userinfo.jsp" class="link_userinfo link_thisPage" >我</a>
                    <a href="logout" class="link_logout">登出</a>
                </c:if>

                <c:if test="${thisCmp != null}">
                    <a href="wanttinglist">招聘</a>
                    <a href="userinfo.jsp" class="link_userinfo link_thisPage">企业</a>
                    <a href="logout" class="link_logout">登出</a>
                </c:if>

                <c:if test="${thisUser == null && thisCmp == null}">
                    <a href="login.jsp" class="link_login">登陆</a>
                </c:if>
            </span>

    </div>



    <div class="content">


        <div class="user_info_div" id="user_info_div_id">

            <c:if test="${thisUser != null}">
                <div class="user_info_show">
                    <p class="user_info_show_title">个人信息</p>
                    <p class="user_info_show_p user_name">${thisUser.name}
                        <c:if test="${thisUser.sex == '男'}">
                            <img src="img/male.png">
                        </c:if>
                        <c:if test="${thisUser.sex == '女'}">
                            <img src="img/famale.png">
                        </c:if>
                    </p>
                    <hr>
                    <p class="user_info_show_p"> ${thisUser.sex} <span> | </span> ${thisUser.birth} </p>
                    <p class="user_info_show_title">教育经历</p>
                    <p class="user_info_show_p user_name">${thisUser.educated}</p>
                    <hr>
                    <p class="user_info_show_p"> ${thisUser.school} <span> | </span> ${thisUser.major} </p>
                    <p class="user_info_show_title">联系方式</p>
                    <p class="user_info_show_p user_name">${thisUser.phonenum}</p>
                    <hr>
                    <p class="user_info_show_p"> ${thisUser.email} </p>
                    <p  class="link_user_info_edit_p"><span onclick="link_user_info_chpw()">修改密码</span> <span> | </span><span onclick="link_user_info_edit()">修改信息</span></p>
                </div>
            </c:if>


            <c:if test="${thisCmp != null}" >
                <div class="user_info_show">
                    <p class="user_info_show_title">企业信息</p>
                    <p class="user_info_show_p user_name">${thisCmp.fullname}
                    </p>
                    <hr>
                    <p class="user_info_show_p"> ${thisCmp.address} <span> | </span> ${thisCmp.industry} </p>
                    <p class="user_info_show_title">负责人信息</p>
                    <p class="user_info_show_p user_name">${thisCmp.mgrname}</p>
                    <hr>
                    <p class="user_info_show_p"> ${thisCmp.mgrpn}</p>

                    <p class="link_user_info_edit_p"><span  onclick="link_user_info_chpw()">修改密码</span> <span> | </span> <span onclick="link_user_info_edit()">修改信息</span></p>
                </div>
            </c:if>
        </div>

        <div class="user_info_div" id="user_edit_div_id">

            <c:if test="${thisUser != null}">
                <form action="infoupdate" class="user_info_show" method="post">
                    <input value="1" name="type" hidden>
                    <p class="user_info_show_title">个人信息</p>
                    <hr>
                    <p class="user_edit_p ">姓名:<input type="text" name="name" value="${thisUser.name}"></p>

                    <p class="user_edit_p_radio">
                        <c:if test="${thisUser.sex == '男'}">
                            性别:
                            <input type="radio" name="sex" value="男" checked="checked">男
                            <input type="radio" name="sex" value="女">女
                        </c:if>
                        <c:if test="${thisUser.sex == '女'}">
                            性别:
                            <input type="radio" name="sex" value="男">男
                            <input type="radio" name="sex" value="女"  checked="checked">女
                        </c:if>
                    </p>
                    <p class="user_edit_p">生日:<input type="date" name="birth" value="${thisUser.birth}"></p>

                    <p class="user_info_show_title">教育经历</p>
                    <hr>
                    <p class="user_edit_p">学历:<select name="educated" >
                        <c:if test="${thisUser.educated == '初中'}">
                        <option value="初中" selected="selected">初中</option>
                        </c:if>
                        <c:if test="${thisUser.educated != '初中'}">
                            <option value="初中">初中</option>
                        </c:if>
                        <c:if test="${thisUser.educated == '高中'}">
                            <option value="高中" selected="selected">高中</option>
                        </c:if>
                        <c:if test="${thisUser.educated != '高中'}">
                            <option value="高中">高中</option>
                        </c:if>
                        <c:if test="${thisUser.educated == '本科'}">
                            <option value="本科" selected="selected">本科</option>
                        </c:if>
                        <c:if test="${thisUser.educated != '本科'}">
                            <option value="本科">本科</option>
                        </c:if>
                        <c:if test="${thisUser.educated == '硕士'}">
                            <option value="硕士" selected="selected">硕士</option>
                        </c:if>
                        <c:if test="${thisUser.educated != '硕士'}">
                            <option value="硕士">硕士</option>
                        </c:if>
                        <c:if test="${thisUser.educated == '博士'}">
                            <option value="博士" selected="selected">博士</option>
                        </c:if>
                        <c:if test="${thisUser.educated != '博士'}">
                            <option value="博士">博士</option>
                        </c:if>
                    </select></p>
                    <p class="user_edit_p">学校:<input type="text" name="school" value="${thisUser.school}"></p>
                    <p class="user_edit_p">专业:<input type="text" name="major" value="${thisUser.major}"></p>

                    <p class="user_info_show_title">联系方式</p>
                    <hr>
                    <p class="user_edit_p">邮箱:<input type="email" name="email" value="${thisUser.email}"></p>
                    <p class="user_edit_p_buttun"><input type="submit" value="提交"> <input type="reset" value="重置">
                    <input type="button" value="取消" onclick="link_user_info_show()"></p>
                </form>
            </c:if>


            <c:if test="${thisCmp != null}" >
                <form action="infoupdate" class="user_info_show" method="post">
                    <input value="0" name="type" hidden>
                    <p class="user_info_show_title">企业信息</p>
                    <hr>
                    <p class="user_edit_p ">企业:<input type="text" name="fullname" value="${thisCmp.fullname}"></p>
                    <p class="user_edit_p">行业:<input type="text" name="industry" value="${thisCmp.industry}"></p>
                    <p class="user_edit_p">地址:<input type="text" name="address" value="${thisCmp.address}"></p>

                    <p class="user_info_show_title">负责人信息</p>
                    <hr>
                    <p class="user_edit_p ">姓名:<input type="text" name="mgrname" value="${thisCmp.mgrname}"></p>
                    <p class="user_edit_p">手机号:<input type="text" name="mgrpn" value="${thisCmp.mgrpn}"></p>
                    <p class="user_edit_p_buttun"><input type="submit" value="提交"> <input type="reset" value="重置">
                        <input type="button" value="取消" onclick="link_user_info_show()"></p>
                </form>
            </c:if>
        </div>

        <div class="user_info_div" id="user_chpw_div_id">

            <form action="infoupdate" class="user_info_show" method="post">
                <c:if test="${thisUser != null}">
                    <input value="3" name="type" hidden>
                    <p class="user_info_show_title">登陆账号</p>
                    <hr>
                    <p class="user_name">${thisUser.phonenum}</p>
                    <p class="user_info_show_title">重置密码</p>
                    <hr>
                    <p class="user_edit_p"><input type="password" name="oldpasswd" placeholder="原密码"></p>
                    <p class="user_edit_p"><input type="password" name="newpasswd" placeholder="新密码"></p>
                    <p class="user_edit_p"><input type="password" name="newpasswd2" placeholder="确认密码"></p>
                    <p class="user_edit_p_buttun"><input type="submit" value="提交"> <input type="reset" value="重置">
                        <input type="button" value="取消" onclick="link_user_info_show()"></p>
                </c:if>

                <c:if test="${thisCmp != null}">
                    <input value="2" name="type" hidden>
                    <p class="user_info_show_title">登陆账号</p>
                    <hr>
                    <p class="user_name">${thisCmp.loginname}</p>
                    <p class="user_info_show_title">重置密码</p>
                    <hr>
                    <p class="user_edit_p"><input type="password" name="oldpasswd" placeholder="原密码"></p>
                    <p class="user_edit_p"><input type="password" name="newpasswd" placeholder="新密码"></p>
                    <p class="user_edit_p"><input type="password" name="newpasswd2" placeholder="确认密码"></p>
                    <p class="user_edit_p_buttun"><input type="submit" value="提交"> <input type="reset" value="重置">
                        <input type="button" value="取消" onclick="link_user_info_show()"></p>
                </c:if>
            </form>

        </div>


        <span class="msg" >${msg}</span>

        <% session.setAttribute("msg",null);%>
    </div>
</div>
</body>
</html>
