<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>무비유환 : 매칭 완료</title>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/header.css" />
    <link rel="stylesheet" href="/resources/css/mate.css" />
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/header.js" defer></script>
    <script type="module" src="/resources/js/mate.js" defer></script>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div class="mate-option-wrapper">
      <h3>매칭 완료!</h3>
      <div id="mate-text">
        <div class="matecomplete-profile">메이트 프로필</div>
        <div class="matecomplete-grade">평가</div>
      </div>
      <div id="mate-data">
        <div class="matecomplete-profile">
          철수
          <!-- matecomplete-userimage div : matecomplete-userimage -->
          <div class="matecomplete-userimage"></div>
        </div>
        <div class="matecomplete-grade">3.6</div>
        <div class="matecomplete-chatting">
          <button class="go-chatting">채팅하기</button>
        </div>
      </div>
      <div id="matecomplete-button">
        <button class="matecomplete-button">메이트 목록</button>
        <button class="matecomplete-button">다시 매칭</button>
      </div>
    </div>
  </body>
</html>
