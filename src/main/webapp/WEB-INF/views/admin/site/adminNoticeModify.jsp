<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>관리자 : 공지사항 등록</title>
    <script src="/resources/js/jquery-3.6.1.min.js"></script>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/support.css" />
    <style>
      @font-face {
        font-family: mice-bold;
        src: url('../font/MICEGothic\ Bold.ttf');
      }

      hr {
        border: none;
        height: 1px;
        background-color: gray;
      }

      #input-title {
        margin: 20px 0;
        height: 30px;
        width: 60%;
        outline: none;
        padding: 0 10px;
      }

      #input-content {
        padding: 10px;
        margin: 20px 0;
        height: 400px;
        width: 100%;
        resize: none;
        outline: none;
      }

      #input-content-area {
        text-align: center;
      }

      #btn-area {
        text-align: right;
      }

      #register-btn {
        border: 1px solid #0f1a3b;
        background-color: #0f1a3b;
        color: white;
        width: 12%;
        height: 40px;
      }

      #cancel-btn {
        margin-right: 10px;
        border: 1px solid #0f1a3b;
        background-color: white;
        color: black;
        width: 12%;
        height: 40px;
      }

      #input-title-area {
        width: 100%;
      }
    </style>
  </head>
  <body>
    <div id="admin-wrapper">
      <form method="post">
        <input type="hidden" name="adminId" value="eunhye0910" />
        <h3><a href="#">공지사항 수정</a></h3>
        <br />
        <hr />
        <div id="input-title-area">
          <input id="input-title" name="noticeTitle" type="text" value="${notice.noticeTitle}" />
        </div>
        <hr />
        <div id="input-content-area">${notice.noticeContent}<textarea id="input-content" name="noticeContent" wrap="hard" cols="100"></textarea></div>
        <div id="btn-area">
          <button id="cancel-btn" type="button" onclick="javascript:history.go(-1);">취소</button>
          <button id="register-btn" type="submit" onclick="javascript:form.action='/admin/noticeModify.yh'">수정</button>
        </div>
      </form>
    </div>
  </body>
</html>
