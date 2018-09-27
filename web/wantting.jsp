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
    <title>求职信息</title>
    <link href="css/inside.css" type="text/css" rel="stylesheet">
    <script src="js/js.js" type="text/javascript" charset="utf-8">
    </script>

</head>
<body onload="link_wantting_show()">
<div class="_body" >


    <div class="header">
        <span class="logop"><a href="index.jsp">YUANZHE</a></span>


        <span class="daohang" onmouseover="mOver(this)" onmouseout="mOut(this)">
              <a href="index.jsp">首页</a>


                <c:if test="${thisUser != null}">
                    <a href="recruitslist">求职</a>
                    <a href="userinfo.jsp" class="link_userinfo">我</a>
                    <a href="logout" class="link_logout">登出</a>
                </c:if>

                <c:if test="${thisCmp != null}">
                    <a href="wanttinglist" class="link_thisPage">招聘</a>
                    <a href="userinfo.jsp" class="link_userinfo">企业</a>
                    <a href="logout" class="link_logout">登出</a>
                </c:if>

                <c:if test="${thisUser == null && thisCmp == null}">
                    <a href="login.jsp" class="link_login">登陆</a>
                </c:if>
            </span>
    </div>

    <div class="content" >

        <c:if test="${thisCmp == null}">
            <form action="" class="search-form">
                <input type="text" name="search_info"  class="search-input" placeholder="搜索职位信息">
                <input type="submit" value="搜索" class="search-submit">
            </form>
        </c:if>

        <c:if test="${thisCmp != null}" >
            <form action="" class="search-form">
                <input type="text" name="search_info"  class="search-input " placeholder="搜索求职信息">
                <input type="submit" value="搜索" class="search-submit">
            </form>
        </c:if>


        <div class="user_info_div wantting_show" id="wantting_show">
            <button onclick="link_recruits_edit()" value="发布招聘信息" class="buttun">发布招聘信息</button>
             <c:forEach items="${wanttingList}" var="wantting">


                 <div class="msg_info_show">

                     <form action="otherspage" method="post">
                         <input name="type" value="1" hidden >
                         <input name="userid" value="${wantting.userid}" hidden>
                         <p class="user_info_show_title">${wantting.job}</p>
                         <hr>
                         <p class="msg_info_show_p">${wantting.username}<span>|</span>${wantting.sal}</p>
                         <input type="submit" value="他的信息">
                     </form>
                 </div>


             </c:forEach>
        </div>

        <div class="user_info_show recruits_edit" id="recruits_edit">
            <form action="msgadd" class="user_info_show" method="post">

                <input value="2" name="type" hidden>
                <p class="user_reg_title">发布招聘信息</p>
                <p class="user_info_show_title">填写招聘信息</p>
                <hr>
                <p class="user_edit_p"><input type="text" name="job" placeholder="请输入要招聘的工作岗位"></p>
                <p class="user_edit_p"><input type="text" name="sal" placeholder="请输入要给出的薪资"></p>
                <p class="user_edit_p"><input type="text" name="edu_need" placeholder="请输入学历要求"></p>

                <p class="user_edit_p"><textarea name="more_info" cols="30" rows="10" placeholder="请输入其他要求或介绍"></textarea></p>
                <p class="user_edit_p_buttun"><input type="submit" value="提交"> <input type="reset" value="重置">
                    <input type="button" value="取消" onclick="link_wantting_show()"></p>

            </form>
        </div>
    </div>
</div>
</body>
</html>
