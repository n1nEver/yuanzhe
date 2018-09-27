<%--
  Created by IntelliJ IDEA.
  User: nine
  Date: 2018/7/3 0003
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>招聘信息</title>
    <link href="css/inside.css" type="text/css" rel="stylesheet">
    <script src="js/js.js" type="text/javascript" charset="utf-8">
    </script>
</head>
<body>
<div class="_body">


    <div class="header">
        <span class="logop"><a href="index.jsp">YUANZHE</a></span>


        <span class="daohang" onmouseover="mOver(this)" onmouseout="mOut(this)">
              <a href="index.jsp">首页</a>


                <c:if test="${thisUser != null}">
                    <a href="recruitslist" class="link_thisPage">求职</a>
                    <a href="userinfo.jsp" class="link_userinfo">我</a>
                    <a href="logout" class="link_logout">登出</a>
                </c:if>

                <c:if test="${thisCmp != null}">
                    <a href="wanttinglist">招聘</a>
                    <a href="userinfo.jsp" class="link_userinfo">企业</a>
                    <a href="logout" class="link_logout">登出</a>
                </c:if>

                <c:if test="${thisUser == null && thisCmp == null}">
                    <a href="login.jsp" class="link_login">登陆</a>
                </c:if>

            </span>



    </div>

    <div class="content">

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

        <div class="user_info_show wantting_show" id="wantting_show">
            <c:forEach items="${recruitsList}" var="recruits">
                <div class="msg_info_show">
                    <form action="otherspage" method="post">
                        <input name="type" value="0" hidden>
                        <input name="cmpid" value="${recruits.cmpid}" hidden>
                        <p class="user_info_show_title">${recruits.cmpname}</p>
                        <hr>
                        <p class="msg_info_show_p">${recruits.job}<span>|</span>${recruits.sal}</p>
                        <p class="msg_info_show_p">${recruits.more_info}</p>
                        <p class="msg_info_show_p"><input type="submit" value="企业信息"></p>
                    </form>
                </div>
            </c:forEach>
        </div>

        <div class="user_info_show" id="wantting_edit">
            <c:if test="${thisUser != null}">
                <form action="msgadd" >
                    <input value="3" name="type" hidden>
                </form>
            </c:if>

            <c:if test="${thisCmp != null}" >
                <form action="msgadd" >
                    <input value="2" name="type" hidden>
                    <input type="text" name="search_info"  class="search-input " placeholder="搜索求职信息">
                    <input type="submit" value="搜索" class="search-submit">
                </form>
            </c:if>
        </div>

    </div>
</div>
</body>
</html>
