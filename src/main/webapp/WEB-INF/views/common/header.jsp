<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../../../resources/css/common.css" />
    <link rel="stylesheet" href="../../../resources/css/header.css" />
    <title>무비유환 : 헤더</title>
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="../../../../resources/js/jquery-3.6.1.min.js"></script>
    <script src="../../../../resources/js/header.js" defer></script>
  </head>
  <body>
    <nav id="navbar">
      <a href="#" class="navbar-toggleBtn show" id="bars"><i class="fa-solid fa-bars show"></i></a>
      <a href="#" class="navbar-toggleBtn" id="xmark"><i class="fa-solid fa-xmark"></i></a>
      <ul id="navbar-links">
        <li><a href="#">로그인</a></li>
        <li><a href="#">회원가입</a></li>
      </ul>
      <ul id="navbar-menu">
        <li class="navbar-menuList"><a href="#">영화</a></li>
        <li class="navbar-menuList"><a href="#">영화관 </a></li>
        <li class="navbar-menuList"><a href="#">메이트</a></li>
        <li id="navbar-logo">
          <a href="#">
            <img src="../../../resources/images/logo.png" alt="" width="150px" />
          </a>
        </li>
        <li class="navbar-menuList"><a href="#">예매</a></li>
        <li class="navbar-menuList"><a href="#">스토어</a></li>
        <li class="navbar-menuList"><a href="#">고객지원</a></li>
      </ul>
    </nav>
  </body>
</html>
