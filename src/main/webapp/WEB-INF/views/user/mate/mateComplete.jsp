<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>무비유환 : 매칭 완료</title>
    <link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/header.css" />
    <link rel="stylesheet" href="/resources/css/mate.css" />
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/mate.js" defer></script>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div class="matching-result-wrapper">
      <div class="mate-title">매칭 완료</div>
      <div class="mate-list-table">
        <div class="mate-list-row">
          <div class="match-profile-col">메이트 프로필</div>
          <div class="match-location-col">자주찾는 지점</div>
          <div class="match-genre-col">선호 장르</div>
          <div class="match-grade-col">매칭 점수</div>
          <div class="match-btn-col"></div>
        </div>
        <c:if test="${!empty matchList}">
          <c:forEach items="${matchList}" var="matchInfo">
            <div class="mate-list-row">
              <div class="match-profile-col">
                <c:if test="${empty matchInfo.memberImgRename}">
                  <i class="fa-solid fa-user fa-xl"></i>
                </c:if>
                <c:if test="${not empty matchInfo.memberImgRename}">
                  <img src="/resources/images/userProfileImg/${matchInfo.memberImgRename}" />
                </c:if>
                ${matchInfo.memberNick}(${matchInfo.memberAge}, ${matchInfo.memberGender})
              </div>
              <div class="match-location-col">${matchInfo.cinemaName}</div>
              <div class="match-genre-col">${matchInfo.genre}</div>
              <div class="match-grade-col">${matchInfo.matchingGrade}</div>
              <div class="match-btn-col"><button class="btn yellow" onclick="chatting('${memberId}','${matchInfo.memberId}', '${matchInfo.memberNick}');">신청</button></div>
            </div>
          </c:forEach>
          <div class="match-btn-area">
            <button class="rematch-btn" onclick="location.href='/mate/matching.yh'">다시 매칭</button>
            <button class="list-btn" onclick="location.href='/mate/main.yh'">돌아가기</button>
          </div>
        </c:if>
      </div>
    </div>
    <!-- <div class="mate-option-wrapper">
      <h3>매칭 완료!</h3>
      <div id="mate-text">
        <div class="matecomplete-profile">메이트 프로필</div>
        <div class="matecomplete-grade">평가</div>
      </div>
      <div id="mate-data">
        <div class="matecomplete-profile">
          철수
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
    </div> -->
  </body>
</html>
