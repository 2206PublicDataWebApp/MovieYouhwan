<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>관리자 : FAQ 목록</title>
    <script src="/resources/js/jquery-3.6.1.min.js"></script>
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <style>
      /* 합칠 때 빼고 넣기 */
      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }

      body {
        margin: 0 auto;
      }

      #admin-wrapper {
        width: 1000px;
        margin: 0 auto;
      }

      a {
        text-decoration: none;
        color: #0f1a3b;
      }
      /* 여기까지 */

      button {
        cursor: pointer;
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
        margin: 20px 0 20px 0;
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

      .modify-btn {
        margin-left: 180px;
        border: 1px solid #0f1a3b;
        background-color: #0f1a3b;
        color: white;
        width: 7%;
        height: 30px;
      }

      .delete-btn {
        border: 1px solid #0f1a3b;
        background-color: white;
        color: black;
        width: 7%;
        height: 30px;
      }

      .check-td {
        width: 80px;
      }
      .num-td {
        width: 130px;
      }
      .type-td {
        width: 130px;
      }
      .title-td {
        width: 860px;
        padding-left: 30px;
      }
      #title-td {
        text-align: center;
      }

      table,
      td {
        font-size: 13px;
        border-collapse: collapse;
        line-height: 40px;
      }

      th {
        border-collapse: collapse;
        line-height: 50px;
      }

      tr {
        border-bottom: 1px solid gray;
        text-align: center;
      }

      i {
        float: right;
      }

      #content {
        background-color: lightgray;
      }

      .arccodion-btn {
        font-size: 13px;
        text-align: left;
        vertical-align: middle;
        background-color: white;
        width: 100%;
        border: none;
        height: 100%;
      }
    </style>
  </head>
  <body>
    <div id="admin-wrapper">
      <h3><a href="#">FAQ 관리</a></h3>
      <br />
      <hr />
      <div id="search-area">
        <select>
          <option>제목</option>
          <option>내용</option>
          <option>전체</option>
        </select>
        <input class="search-input" type="text" placeholder="검색어를 입력하세요" />
        <button class="search-btn">검색</button>
        <button class="modify-btn">등록</button>
        <button class="delete-btn">삭제</button>
      </div>
      <hr />
      <table>
        <thead>
          <tr>
            <th class="check-td">체크박스</th>
            <th class="num-td">번호</th>
            <th class="type-td">구분</th>
            <th id="title-td">질문</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>체크박스</td>
            <td>1</td>
            <td>영화관</td>
            <td class="title-td">
              <button class="arccodion-btn" onclick="showContent(this);">영화관 위치는 어떻게 찾나요?<i class="fa-solid fa-chevron-down"></i></button>
            </td>
          </tr>
          <tr>
            <td>체크박스</td>
            <td>1</td>
            <td>영화관</td>
            <td class="title-td">
              <button class="arccodion-btn" onclick="showContent(this);">영화관 위치는 어떻게 찾나요?<i class="fa-solid fa-chevron-down"></i></button>
            </td>
          </tr>
          <tr class="content"></tr>
          <tr>
            <td>체크박스</td>
            <td>1</td>
            <td>영화관</td>
            <td class="title-td">
              <button class="arccodion-btn" onclick="showContent(this);">영화관 위치는 어떻게 찾나요?<i class="fa-solid fa-chevron-down"></i></button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <script>
      function showContent(obj) {
        if ($('#content') != null) {
          $('#content').remove();
        }
        console.log($(obj));
        var contentArea = $(obj).parent().parent();
        console.log(contentArea);
        contentArea.after("<tr id='content'><td colspan='4'>;;네이버 지도 보고 오세요</td></tr>");
      }
    </script>
  </body>
</html>
