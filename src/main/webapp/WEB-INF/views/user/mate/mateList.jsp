<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/header.css" />
    <link rel="stylesheet" href="/resources/css/mate.css" />
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/mate.js" defer></script>
    <title>무비유환 : 나의 메이트</title>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div id="user-wrapper">
      <div id="back-navy"></div>
      <div id="mymate-wrap">
        <div id="mymate-form">
          <div id="mypage-top">
            <div id="now-level">
              <c:choose>
                <c:when test="${member.memberLevel eq 0}">Bronze</c:when>
                <c:when test="${member.memberLevel eq 1}">Silver</c:when>
                <c:when test="${member.memberLevel eq 2}">Gold</c:when>
                <c:when test="${member.memberLevel eq 3}">VIP</c:when>
                <c:when test="${member.memberLevel eq 4}">VVIP</c:when>
              </c:choose>
            </div>
            <div id="editProfile">
              <a href="#"><i class="fa-solid fa-pencil" id="pen"></i>매칭 설정 변경</a>
            </div>
          </div>
          <div id="profile-img">
            <c:if test="${!empty member.memberImgRename}">
              <img src="/resources/images/userProfileImg/${matchInfo.memberImgRename}" id="img-frame" />
            </c:if>
            <c:if test="${empty member.memberImgRename}">
              <i class="fa-solid fa-user fa-xl"></i>
            </c:if>
            <div id="bangabanga">${member.memberNick}님 반가워요!</div>
          </div>
          <div id="level-wrap">
            <div class="level-name">
              <div>이번달 매칭 횟수</div>
            </div>
            <div id="level-bar-wrap">
              <div class="mate-count-bar">
                <div class="mate-count"></div>
              </div>
            </div>
            <div class="level-count">
              <div>0회</div>
              <div>2회</div>
              <div>4회</div>
              <div>6회</div>
              <div>8회</div>
            </div>
          </div>
          <div id="bottom-line"></div>
          <div class="point-mate">
            <div class="my-point-wrap">
              <div class="go-matching-btn-wrap">
                <button class="yellow matching-btn" onclick="location.href='/mate/matching.yh'">매칭하러 가기</button>
              </div>
            </div>
          </div>

          <div class="matching-toggle-wrap">
            <span>MATCHING</span>
            <label for="toggle" class="match-toggle-switch">
              <span class="match-toggle-btn"></span>
              <input id="isMatchingActive" type="hidden" name="matchingActive" value="${mySurvey.matchingActive}" />
            </label>
          </div>
        </div>
      </div>
    </div>
    <div class="mate-wrapper">
      <div class="mate-title">나의 메이트</div>
      <div class="mate-list-table">
        <div class="mate-list-row">
          <div class="match-date-col">매칭 일자</div>
          <div class="mate-profile-col">메이트 프로필</div>
          <div class="mate-location-col">지역</div>
          <div class="mate-genre-col">선호 장르</div>
          <div class="chat-btn-col"></div>
          <div class="delete-btn-col"></div>
        </div>

        <c:forEach items="${mateInfoList}" var="mateInfo">
          <div class="mate-list-row">
            <div class="match-date-col">${mateInfo.createDate}</div>
            <div class="mate-profile-col">
              <c:if test="${empty mateInfo.memberImgRename}">
                <i class="fa-solid fa-user fa-xl"></i>
              </c:if>
              <c:if test="${not empty matchInfo.memberImgRename}">
                <img src="/resources/images/userProfileImg/${mateInfo.memberImgRename}" />
              </c:if>
              ${mateInfo.memberNick} (${mateInfo.memberAge}, ${mateInfo.memberGender})
            </div>
            <div class="mate-location-col">${mateInfo.cinemaName}</div>
            <div class="mate-genre-col">${mateInfo.genre}</div>
            <div class="chat-btn-col"><button class="btn yellow">채팅</button></div>
            <div class="delete-btn-col"><button class="btn navy">삭제</button></div>
          </div>
        </c:forEach>
      </div>
    </div>
  </body>
</html>
