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
    <title>무비유환 : 매칭 조건 선택</title>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div class="mate-option-wrapper">
      <div class="option-title">매칭 조건 선택</div>
      <div class="option-sex">
        <div class="box-top">
          선호하는 메이트 성별을 선택해주세요.
        </div>
        <div class="box-under">
          <input type="radio" name="sex" value="female">여성
          <input type="radio" name="sex" value="male">남성
          <input type="radio" name="sex" value="all">무관
        </div>
      </div>
      <div class="option-age">
        <div class="box-top">
          선호하는 메이트 연령대를 선택해주세요.
        </div>
        <div class="box-under">
			<input type="radio" name="age" value="two">20대
			<input type="radio" name="age" value="three">30대
			<input type="radio" name="age" value="four">40대
			<input type="radio" name="age" value="five">50대 이상
        </div>
      </div>

      <div class="option-location">
        <div class="box-top">
          자주 이용하는 지점을 선택해주세요.
        </div>
        <div class="box-under">

        </div>
      </div>

      <div class="option-genre">
        <div class="box-top">
          선호하는 장르를 선택해주세요.
        </div>
        <div class="box-under">
        </div>
      </div class="btn-area">
        <button class="next-btn">다음
          <span class="fa-stack fa-xs">
            <i class="fa-solid fa-angle-right fa-stack-1x"></i>
            <i class="fa-regular fa-circle fa-stack-2x"></i>
          </button>
          </span>
      </div>
    </div>
  </body>
</html>
