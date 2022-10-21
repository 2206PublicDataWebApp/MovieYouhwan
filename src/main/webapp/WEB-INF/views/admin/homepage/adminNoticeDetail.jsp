<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>관리자 : 공지사항 상세</title>
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/jquery-3.6.1.min.js"></script>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/adminhome.css" />
    <style>
      @font-face {
        font-family: mice-bold;
        src: url('../font/MICEGothic\ Bold.ttf');
      }

      #btn-area {
        padding: 20px 0;
        text-align: right;
      }

      .dark-btn {
        margin-left: 180px;
        border: 1px solid #0f1a3b;
        background-color: #0f1a3b;
        color: white;
        width: 7%;
        height: 30px;
      }

      .white-btn {
        border: 1px solid #0f1a3b;
        background-color: white;
        color: black;
        width: 7%;
        height: 30px;
      }
    </style>
  </head>
  <body>
    <div id="admin-wrapper">
      <h3><a href="#">공지사항 관리</a></h3>
      <br />
      <hr />
      <div id="homepage-menu">
        <ul id="homepage-tab">
          <li class="homepage-tab-item"><a href="#">배너</a></li>
          <li class="homepage-tab-item"><a href="#">FAQ</a></li>
          <li class="homepage-tab-item"><a href="#">Q&A</a></li>
          <li class="homepage-tab-item"><a href="#">공지사항</a></li>
        </ul>
      </div>
      <div id="btn-area">
        <button class="dark-btn">수정</button>
        <button class="white-btn">삭제</button>
      </div>
    </div>
  </body>
</html>
