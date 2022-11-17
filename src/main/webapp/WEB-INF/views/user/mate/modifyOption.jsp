<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/header.css" />
    <link rel="stylesheet" href="/resources/css/mate.css" />
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/mate.js" defer></script>
    <title>무비유환 : 매칭 조건 선택</title>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div class="mate-option-wrapper">
      <form action="/mate/selectOption.complete.yh" method="post">
        <div class="option-title">매칭 조건 선택</div>
        <div class="option-sex">
          <div class="box-top">선호하는 메이트 성별을 선택해주세요.</div>
          <div class="box-under">
            <label class="mate-label"><input class="mate-option-radio" type="radio" name="gender" value="여" />여성 </label>
            <label class="mate-label"><input class="mate-option-radio" type="radio" name="gender" value="남" />남성</label>
            <label class="mate-label"><input class="mate-option-radio" type="radio" name="gender" value="무관" />무관</label>
          </div>
        </div>
        <div class="option-age">
          <div class="box-top">선호하는 메이트 연령대를 선택해주세요.</div>
          <div class="box-under">
            <label class="mate-label"><input class="mate-option-radio" type="radio" name="age" value="20대" />20대</label>
            <label class="mate-label"><input class="mate-option-radio" type="radio" name="age" value="30대" />30대</label>
            <label class="mate-label"><input class="mate-option-radio" type="radio" name="age" value="40대" />40대</label>
            <label class="mate-label"><input class="mate-option-radio" type="radio" name="age" value="50대 이상" />50대 이상</label>
          </div>
        </div>

        <div class="option-location">
          <div class="box-top">자주 이용하는 지점을 선택해주세요.</div>
          <div class="box-under">
            <select class="select-cinema-option" name="cinemaName">
              <c:forEach var="cinemaOption" items="${cinemaOptionList}">
                <option value="${cinemaOption.cinemaName}">${cinemaOption.cinemaName}</option>
              </c:forEach>
            </select>
          </div>
        </div>

        <div class="option-genre">
          <div class="box-top">선호하는 장르를 선택해주세요.</div>
          <div class="box-under box-genre">
            <c:forEach var="genreOption" items="${genreOptionList}" varStatus="i">
              <label class="mate-label"><input class="mate-option-radio" type="checkbox" name="genreList" value="${genreOption.genre}" />${genreOption.genre} </label>
            </c:forEach>
          </div>
        </div>
        <button type="submit" class="next-btn">
          수정
          <span class="fa-stack fa-xs">
            <i class="fa-solid fa-angle-right fa-stack-1x"></i>
            <i class="fa-regular fa-circle fa-stack-2x"></i>
          </span>
        </button>
      </form>
    </div>
  </body>
</html>
