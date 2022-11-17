<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
    <link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
    <link href="/resources/css/header.css" rel="stylesheet" />
    <link rel="stylesheet" href="/resources/css/footer.css" />
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/mate.css" />
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
    <script src="/resources/js/mate.js" defer></script>

    <title>무비유환 : 메이트 서비스 시작하기</title>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div class="mate-start-wrapper">
      <div class="mate-start-header">
        <div id="header-first">영화를 즐기는 또 하나의 방법,</div>
        <div id="header-second">당신의 메이트를 찾아보세요.</div>
      </div>
      <div class="slide-icon-area">
        <i class="slide-icon fa-solid fa-chevron-down fa-5x"></i>
      </div>
      <div id="agreement-area">
        <div id="agree-txt-box">
          <div class="agreement-title"><h3>[개인정보 수집 및 이용 동의]</h3></div>
          <pre class="agreement-content">
1. 회원은 (주)무비유환에서 제공하는 메이트 서비스에 이름, 생년월일, 성별, 주소, 이메일, 핸드폰번호를 제공한다. 
2. 회원은 (주)무비유환 메이트 서비스 탈퇴를 언제든지 할 수 있지만, 입력했던 회원 정보는 회원 탈퇴일로부터 1년간 
   (주)무비유환에 보관된다.
</pre
          >
          <br />
          <div class="agreement-title"><h3>[영화 메이트 이용약관 동의]</h3></div>
          <pre class="agreement-content">
1. 메이트 서비스 이용 중 다른 사용자에게 신고를 당했을 경우 다른 사용자와 나눴던 채팅 내용을 (주)무비유환이 확인할 수 있다.
2. 메이트 서비스를 이용하면서 다른 사용자에게 신고를 당했을 경우 메이트 서비스를 일정 기간 또는 영구 정지된다. 
   (1회 30일, 2회 100일, 3회 영구정지)
3. 메이트 서비스를 사용하면 다른 사용자에게 자신의 나이, 성별이 노출된다.
</pre
          >
          <hr class="mate-agree-hr" />
          <div class="mate-agree-check">
            <label><input class="agree-checkbox" type="checkbox" name="mateAgreeCheck" value="mateAgreeCheck" />개인정보 수집 및 이용 동의</label>
          </div>
          <hr class="mate-agree-hr" />
          <div class="mate-agree-check">
            <label><input class="agree-checkbox" type="checkbox" name="mateAgreeCheck" value="mateAgreeCheck" />영화 메이트 이용약관 동의</label>
          </div>
        </div>
        <button id="mate-agree-btn" onclick="mateStart('${loginUser.memberId}');">시작하기</button>
      </div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
  </body>
</html>
