<%--
  Created by IntelliJ IDEA.
  User: nine
  Date: 2018/6/30 0030
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>

      <title>愿者主页</title>

      <link href="css/inside.css" type="text/css" rel="stylesheet">
      <script src="js/js.js" type="text/javascript" charset="utf-8">
      </script>
  </head>
  <body >
<div class="_body">

          <div class="header">
            <span class="logop"><a href="index.jsp">YUANZHE</a></span>


            <span class="daohang" onmouseover="mOver(this)" onmouseout="mOut(this)">
              <a href="index.jsp" class="link_thisPage">首页</a>


                <c:if test="${thisUser != null}">
                    <a href="recruitslist">求职</a>
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

            <div class="slideshow">

                <div class="slideshow-container">
                    <div class="mySlides fade">
                        <img src="img/1.jpg" style="width:100%">
                        <div class="text">WelCome To 愿者！</div>
                    </div>

                    <div class="mySlides fade">
                        <img src="img/2.jpg" style="width:100%">
                        <div class="text">WelCome To 愿者！</div>
                    </div>

                    <div class="mySlides fade">
                        <img src="img/3.jpg" style="width:100%">
                        <div class="text">WelCome To 愿者！</div>
                    </div>

                    <a class="prev" onclick="plusSlides(-1)">❮</a>
                    <a class="next" onclick="plusSlides(1)">❯</a>
                </div>
                <br>
                <c:if test="${thisCmp == null}">
                    <form action="searchser" class="search-form">
                        <input value="0" name="type" hidden>
                        <input type="text" name="search_info"  class="search-input" placeholder="搜索在招职位信息">
                        <input type="submit" value="搜索" class="search-submit">
                    </form>
                </c:if>

                <c:if test="${thisCmp != null}" >
                    <form action="searchser" class="search-form">
                        <input value="1" name="type" hidden>
                        <input type="text" name="search_info"  class="search-input " placeholder="搜索求职信息">
                        <input type="submit" value="搜索" class="search-submit">
                    </form>
                </c:if>

            </div>
            <hr class="index_hr">

            <div class="invitation_show">
                <form action="otherspage">
                <c:if test="${thisUser != null}">
                    <input value="0" name="type" hidden>

                    <p class="user_info_show_title index_msg_title">我收到的邀请</p>
                    <hr>
                    <c:forEach items="${invitationList}" var="invitation">
                        <input value="${invitation.cmpid}" name="cmpid" hidden>


                        <p class="user_info_show_p">
                                ${invitation.cmpname}<span>|</span>${invitation.job}
                        </p>


                        <p class="user_info_show_p">
                            <input type="submit" value="企业详情">
                        </p>

                        <hr>
                    </c:forEach>
                </c:if>

                <c:if test="${thisCmp != null}" >
                    <input value="1" name="type" hidden>
                    <p class="user_info_show_title">企业收到的申请</p>
                    <hr>
                    <c:forEach items="${applyList}" var="apply">
                        <input value="${apply.userid}" name="userid" hidden>
                        <p class="user_info_show_p">${apply.username}<span>|</span>${apply.job}</p>
                        <p class="user_info_show_p"><input type="submit" value="他的信息"></p>
                        <hr>
                    </c:forEach>
                </c:if>

                </form>


            </div>
            <div class="user_info_show index_show">
                <p class="user_info_show_title">热门企业</p>
                <hr>
                <div class="index_show_div">腾讯<img style="width: 100%;" src="img/tencent.jpg"></div>
                <div class="index_show_div">阿里巴巴<img style="width: 100%;" src="img/alibab.jpg"></div>
                <div class="index_show_div">网易<img style="width: 100%;" src="img/netease.jpg"></div>
                <div class="index_show_div">搜狐<img style="width: 100%;" src="img/sohu.jpg"></div>
                <div class="index_show_div">雅虎<img style="width: 100%;" src="img/yahoo.gif"></div>
                <div class="index_show_div">京东<img style="width: 100%;" src="img/jd.jpg"></div>
            </div>


        </div>


    <script>

        var slideIndex = 1;
        showSlides(slideIndex);

        function plusSlides(n) {
            showSlides(slideIndex += n);
        }

        function currentSlide(n) {
            showSlides(slideIndex = n);
        }

        function showSlides(n) {
            var i;
            var slides = document.getElementsByClassName("mySlides");
            var dots = document.getElementsByClassName("dot");
            if (n > slides.length) {slideIndex = 1}
            if (n < 1) {slideIndex = slides.length}
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
            slides[slideIndex-1].style.display = "block";
            dots[slideIndex-1].className += " active";
        }

    </script>
</div>
  </body>
</html>
