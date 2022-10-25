<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>관리자 : FAQ 목록</title>
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
        background-color: gray;
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

      .modify-btn {
        margin: 20px 0;
        border: 1px solid #0f1a3b;
        background-color: #0f1a3b;
        color: white;
        width: 90%;
        height: 30px;
      }

      #board-header {
        font-weight: mice-bold;
        padding: 20px 0;
        border: none;
      }

      .board-row {
        display: flex;
        justify-content: space-between;
        align-items: center;
        width: 100%;
        text-align: center;
        padding: 10px 0 10px 0;
      }

      .faq-board-answer {
        display: flex;
        border-bottom: 1px solid gray;
      }

      #check-header,
      .check-col {
        width: 5%;
      }
      #num-header,
      .num-col {
        width: 10%;
      }
      #type-header,
      .type-col {
        width: 15%;
      }
      #title-header,
      .title-col {
        width: 70%;
      }

      .title-col,
      .board-answer {
        text-align: left;
      }

      .answer-content {
        width: 85%;
        padding: 20px 40px 20px 30px;
      }

      .board-answer::before {
        display: inline-block;
        content: 'A. ';
        height: 100%;
        padding: 20px 0 20px 70px;
        float: left;
      }

      .title-col::before {
        display: inline-block;
        content: 'Q. ';
        margin: 0 5px;
      }
      .modify-btn-area {
        width: 8%;
      }

      i {
        float: right;
      }

      .no-show {
        display: none;
      }

      a {
        cursor: pointer;
      }
    </style>
  </head>
  <body> -->
<h5>${fList}</h5>
<form method="post">
  <div id="search-area">
    <select>
      <option>제목</option>
      <option>내용</option>
      <option>전체</option>
    </select>
    <input class="search-input" type="text" placeholder="검색어를 입력하세요" />
    <button type="submit" class="search-btn" onclick="javascript:form.action='/admin/faqSearch.yh'">검색</button>

    <button type="button" class="left-top-dark-btn" onclick="location.href='/admin/FaqWriteForm.yh'">등록</button>
    <button type="submit" class="right-top-white-btn" onclick="javascript:form.action='/admin/faqRemove.yh'">삭제</button>
  </div>
  <div id="board">
    <div class="board-row" id="board-header">
      <div class="check-col"><input id="faq-check-all" type="checkbox" name="delete-check" /></div>
      <div class="num-col">번호</div>
      <div class="type-col">구분</div>
      <div id="faq-title-header">질문</div>
    </div>
    <div class="board-row">
      <div class="check-col"><input class="faq-check support-check" type="checkbox" name="delete-check" /></div>
      <div class="num-col">1</div>
      <div class="type-col">영화</div>
      <div class="title-col">
        <a location.href="/admin/faqDetail.yh" class="answer-title">Lorem, ipsum dolor sit amet consectetur adipisicing elit.<i class="fa-solid fa-chevron-down"></i></a>
      </div>
    </div>
    <div class="faq-board-answer no-show">
      <div class="answer-content">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ut ullam dolorem dolores recusandae reiciendis accusamus mollitia velit iusto nulla quo, delectus commodi possimus. Illo nam consectetur asperiores sint, facere quos! Lorem ipsum dolor sit amet consectetur adipisicing elit. Tenetur quis a veniam officiis nisi nesciunt pariatur, iusto sit facilis neque soluta unde impedit delectus? Mollitia voluptates facere assumenda quo veritatis.</div>
      <div class="modify-btn-area"><button class="faq-modify-btn">수정</button></div>
    </div>

    <div class="board-row">
      <div class="check-col"><input class="faq-check support-check" type="checkbox" name="delete-check" /></div>
      <div class="num-col">2</div>
      <div class="type-col">영화관</div>
      <div class="title-col">
        <a class="answer-title">Lorem, ipsum dolor sit amet consectetur adipisicing elit.<i class="fa-solid fa-chevron-down"></i></a>
      </div>
    </div>
    <div class="faq-board-answer no-show">
      <div class="answer-content">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ut ullam dolorem dolores recusandae reiciendis accusamus mollitia velit iusto nulla quo, delectus commodi possimus. Illo nam consectetur asperiores sint, facere quos! Lorem ipsum dolor sit amet consectetur adipisicing elit. Tenetur quis a veniam officiis nisi nesciunt pariatur, iusto sit facilis neque soluta unde impedit delectus? Mollitia voluptates facere assumenda quo veritatis.</div>
      <div class="modify-btn-area"><button class="faq-modify-btn">수정</button></div>
    </div>
  </div>
</form>
<!-- <script>
      $('.answer-title').click(function () {
        let answer = $(this).parent().parent().next('.faq-board-answer');
        answer.toggleClass('no-show');
        answer.siblings('.faq-board-answer').addClass('no-show');
      });

      $('#check-all').change(function () {
        console.log($('.check-col').children('input:checkbox'));
        if ($(this).is(':checked')) {
          console.log('true');
          $('.check-col').children('input:checkbox').prop('checked', true);
        } else {
          $('.check-col').children('input:checkbox').prop('checked', false);
        }
      });
    </script>
  </body>
</html> -->
