<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav id="navbar">
  <a href="#" class="navbar-toggleBtn show" id="bars"><i class="fa-solid fa-bars show"></i></a>
  <a href="#" class="navbar-toggleBtn" id="xmark"><i class="fa-solid fa-xmark"></i></a>
  <c:if test="${empty loginUser}">
    <ul class="navbar-links">
      <li><a href="/member/loginView.yh">로그인</a></li>
      <li><a href="/member/joinView.yh">회원가입</a></li>
    </ul>
  </c:if>
  <c:if test="${not empty loginUser}">
    <ul id="profile-user" class="navbar-links">
      <c:if test="${empty loginUser.memberImgRename}">
        <li id="profile-icon">
          <a href="/my/myPageMain.yh">
            <i class="fa-solid fa-user fa-xl"></i>
          </a>
        </li>
      </c:if>
      <c:if test="${not empty loginUser.memberImgRename}">
        <li id="profile-img">
          <a href="/my/myPageMain.yh">
            <img src="/resources/images/userProfileImg/${loginUser.memberImgRename}" />
          </a>
        </li>
      </c:if>
      <li id="profile-nickname"><a href="/my/myPageMain.yh">${loginUser.memberNick}</a></li>
      <li id="profile-logout"><a href="javascript:void(0);" onclick="confirmLogout();">로그아웃</a></li>
    </ul>
  </c:if>
  <ul id="navbar-menuList">
    <li class="navbar-menuItem"><a href="/movieList.yh">영화</a></li>
    <li class="navbar-menuItem"><a href="/user/cinemaList.yh">영화관 </a></li>
    <li class="navbar-menuItem"><a id="mate-tab" href="/mate/main.yh">메이트</a></li>
    <li id="navbar-logo">
      <a href="/home.yh"><img src="/resources/images/logo.png" alt="" width="150px" /></a>
    </li>
    <li class="navbar-menuItem"><a id="ticket-tab" href="/movieTicketTime.yh">예매</a></li>
    <li class="navbar-menuItem"><a href="/store.yh">스토어</a></li>
    <li class="navbar-menuItem"><a href="/support.yh">고객지원</a></li>
  </ul>
</nav>
