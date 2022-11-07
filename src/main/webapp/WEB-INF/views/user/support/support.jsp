<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/support.css" />
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/adminSiteManage.js" defer></script>
    <title>무비유환 : 고객지원</title>
  </head>
  <body>
    <div id="admin-wrapper">
      <!-- 메뉴 탭 -->
      <div id="homepage-menu">
        <input type="hidden" id="tabIndex" value="${tabIndex}" />
        <ul id="homepage-tab">
          <li class="homepage-tab-item" id="homepage-tab-banner"><a href="/support.yh?tabIndex=0">FAQ</a></li>
          <li class="homepage-tab-item" id="homepage-tab-faq"><a href="/support.yh?tabIndex=1">Q&A</a></li>
          <li class="homepage-tab-item" id="homepage-tab-qna"><a href="/support.yh?tabIndex=2">공지사항</a></li>
        </ul>
      </div>
      <hr />
      <!-- jsp 영역 -->
      <div class="page no-show" id="faq-page">
        <jsp:include page="faqList.jsp" />
      </div>
      <div class="page" id="qna-page"></div>
      <div class="page no-show" id="notice-page">
        <jsp:include page="noticeList.jsp" />
      </div>
      <!-- <div class="page no-show" id="banner-page"></div> -->
    </div>
    <br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
  </body>
</html>
