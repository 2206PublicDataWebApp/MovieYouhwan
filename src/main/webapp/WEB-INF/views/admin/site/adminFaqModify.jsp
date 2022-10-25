<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>관리자 : FAQ 등록</title>
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/jquery-3.6.1.min.js"></script>
    <link rel="stylesheet" href="/resources/css/common.css" />
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
    </style>
  </head>
  <body>
    <div id="admin-wrapper">
      <h3><a href="#">FAQ 수정</a></h3>
      <br />
      <hr />
      <div id="input-title-area">
        <input id="input-title" type="text" />
      </div>

      <hr />
      <div id="input-content-area">
        <textarea id="input-content" wrap="hard" cols="100"> </textarea>
      </div>

      <div id="btn-area">
        <button id="cancel-btn">취소</button>
        <button id="register-btn">등록</button>
      </div>
    </div>
  </body>
</html>
