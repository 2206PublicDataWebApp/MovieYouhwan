<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav id="navbar" class="admin">
  <a href="#" class="navbar-toggleBtn show" id="bars"><i class="fa-solid fa-bars show"></i></a>
  <a href="#" class="navbar-toggleBtn" id="xmark"><i class="fa-solid fa-xmark"></i></a>
  <ul id="navbar-menuList" class="admin">
    <li id="navbar-logo" class="admin">
      <a class="admin" href="/admin/adminCinemaList.yh"> <img src="/resources/images/logo.png" alt="" width="100px" /></a>
    </li>
    <li class="navbar-menuItem admin"><a class="admin-cinema-tab" href="/admin/adminCinemaList.yh">영화관관리</a></li>
    <li class="navbar-menuItem admin"><a class="admin-movie-tab" href="/admin/adminMovieList.yh">영화관리</a></li>
    <li class="navbar-menuItem admin"><a class="admin-store-tab" href="/admin/store/manage.yh">스토어관리</a></li>
    <li class="navbar-menuItem admin"><a class="admin-member-tab" href="#">회원관리</a></li>
    <li class="navbar-menuItem admin"><a class="admin-site-tab" href="/admin/site/manage.yh">사이트관리</a></li>
  </ul>
</nav>
