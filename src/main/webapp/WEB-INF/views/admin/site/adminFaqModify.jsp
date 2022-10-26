<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
      <form method="post">
        <input type="hidden" name="faqNo" value="${faq.faqNo}" />
      <h3><a href="#">FAQ 수정</a></h3>
      <br />
      <hr />
      <div id="input-title-area">
          <select name="faqType">
            <option value="theater" <c:if test="${faq.faqType eq 'theater' }">selected</c:if>>영화관</option>
            <option value="member" <c:if test="${faq.faqType eq 'member' }">selected</c:if>>회원</option>
            <option value="store" <c:if test="${faq.faqType eq 'store' }">selected</c:if>>스토어</option>
            <option value="pay" <c:if test="${faq.faqType eq 'pay' }">selected</c:if>>결제</option>
            <option value="refund" <c:if test="${faq.faqType eq 'refund' }">selected</c:if>>환불</option>
          </select>
        <input id="input-title" name="faqTitle" type="text" value="${faq.faqTitle}"/>
      </div>

      <hr />
      <div id="input-content-area">
        <textarea id="input-content" name="faqContent" wrap="hard" cols="100" >${faq.faqContent}</textarea>
      </div>

      <div id="btn-area">
        <button id="cancel-btn" type="button" onclick="javascript:history.go(-1);">취소</button>
        <button id="register-btn" type="submit" onclick="javascript:form.action='/admin/faqModify.yh'">수정</button>
      </div>
    </form>
    </div>
  </body>
</html>
