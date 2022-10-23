<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>관리자 : 공지사항 목록</title>
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/jquery-3.6.1.min.js"></script>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/support.css" />
    <style>
      @font-face {
        font-family: mice-bold;
        src: url('../font/MICEGothic\ Bold.ttf');
      }

      #admin-wrapper {
        width: 1000px;
        margin: 0 auto;
      }
      .search-input {
        border: 1px solid;
        width: 50%;
        height: 30px;
        margin-right: 10px;
        border-radius: 2px;
      }

      .search-btn {
        border: 1px solid;
        border-color: #0f1a3b;
        width: 5%;
        height: 30px;
        background-color: #0f1a3b;
        color: white;
        border-radius: 2px;
      }

      #search-area {
        margin: 20px 0;
      }
      hr {
        border: none;
        height: 1px;
        background-color: lightgray;
      }

      select {
        border: 1px solid;
        width: 7%;
        height: 30px;
        margin-right: 10px;
        margin-left: 10px;
        border-radius: 2px;
      }
      .left-top-dark-btn {
        margin-left: 180px;
        border: 1px solid #0f1a3b;
        background-color: #0f1a3b;
        color: white;
        width: 7%;
        height: 30px;
      }

      .right-top-white-btn {
        border: 1px solid #0f1a3b;
        background-color: white;
        color: black;
        width: 7%;
        height: 30px;
      }

      #board-header {
        padding: 20px 0;
      }

      .board-row {
        display: flex;
        text-align: center;
        border-bottom: 1px solid lightgray;
        padding: 10px 0;
      }

      .num-col {
        width: 10%;
      }

      .title-col {
        width: 70%;
        text-align: left;
      }

      .date-col {
        width: 15%;
      }

      .check-col {
        width: 5%;
      }

      #board-header > .title-col {
        text-align: center;
      }

      homepage 탭메뉴 
      #homepage-notice {
        border-bottom: 3px solid #0f1a3b;
      }
    </style>
  </head>
  <body> -->
<!-- <h3><a href="#">공지사항 관리</a></h3>
  <br />
  <hr />
  <div id="homepage-menu">
    <ul id="homepage-tab">
      <li class="homepage-tab-item" id="homepage-banner"><a href="#">배너</a></li>
      <li class="homepage-tab-item" id="homepage-faq="><a href="#">FAQ</a></li>
      <li class="homepage-tab-item" id="homepage-qna"><a href="#">Q&A</a></li>
      <li class="homepage-tab-item" id="homepage-notice"><a href="#">공지사항</a></li>
    </ul>
  </div>
  <div id="search-area">
    <select>
      <option>제목</option>
      <option>내용</option>
      <option>전체</option>
    </select>
    <input class="search-input" type="text" placeholder="검색어를 입력하세요" />
    <button class="search-btn">검색</button>
    <button class="left-top-dark-btn">등록</button>
    <button class="right-top-white-btn">삭제</button>
  </div>
  <hr /> -->
<div id="search-area">
  <select>
    <option>제목</option>
    <option>내용</option>
    <option>전체</option>
  </select>
  <input class="search-input" type="text" placeholder="검색어를 입력하세요" />
  <button class="search-btn">검색</button>
  <button class="left-top-dark-btn" id="">등록</button>
  <button class="right-top-white-btn">삭제</button>
</div>
<div id="board">
  <div class="board-row" id="board-header">
    <div class="num-col">번호</div>
    <div class="title-col">제목</div>
    <div class="date-col">등록일</div>
    <div class="check-col"><input id="notice-check-all" type="checkbox" name="delete-check" /></div>
  </div>
  <div class="board-row">
    <div class="num-col">1</div>
    <div class="title-col"><a href="#">영화관람권 가격 변경 안내</a></div>
    <div class="date-col">2022-10-07</div>
    <div class="check-col"><input class="notice-check support-check" type="checkbox" name="delete-check" /></div>
  </div>
  <div class="board-row">
    <div class="num-col">2</div>
    <div class="title-col"><a href="#">무비유환 개인정보처리방침 개정 안내</a></div>
    <div class="date-col">2022-09-25</div>
    <div class="check-col"><input class="notice-check support-check" type="checkbox" name="delete-check" /></div>
  </div>
</div>
<!-- <script>
      $('#check-all').change(function () {
        console.log($('.check-col').children('input:checkbox'));
        if ($(this).is(':checked')) {
          console.log('true');
          $('.check-col').children('input:checkbox').prop('checked', true);
        } else {
          $('.check-col').children('input:checkbox').prop('checked', false);
        }
      });

      $('.homepage-tab-item').mouseover(function () {
        console.log('mouseover');
        $('#homepage-notice').css('border', 'none');
      });

      $('.homepage-tab-item').mouseout(function () {
        $('#homepage-notice').css('border-bottom', '3px solid #0f1a3b');
      });
    </script>
  </body>
</html> -->
