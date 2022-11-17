<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
    <link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/header.css" />
    <link rel="stylesheet" href="/resources/css/footer.css" />
    <link rel="stylesheet" href="/resources/css/user/my/myPage.css" />
    <link rel="stylesheet" href="/resources/css/user/my/myPageMain.css" />
    <link rel="stylesheet" href="/resources/css/mateHistory.css" />
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
    <script src="/resources/js/mate.js" defer></script>
    <title>무비유환 - 마이페이지</title>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/user/mypage/myPage.jsp"></jsp:include>

    <div class="mate-history-wrapper">
      <div class="mate-history">
        <div class="list-row">
          <div class="create-date">매칭 날짜</div>
          <div class="delete-date">매칭 삭제 날짜</div>
          <div class="mate-profile">매칭 상대</div>
        </div>
        <c:forEach items="${mateList}" var="mate">
          <div class="list-row">
            <div class="create-date">${mate.createDate}</div>
            <div class="end-date delete-date"><c:if test="${not empty mate.deleteDate}">${mate.deleteDate}</c:if><c:if test="${empty mate.deleteDate}"></c:if></div>
            <div class="mate-profile">
              <c:if test="${empty mate.memberImgRename}">
                <i class="fa-solid fa-user fa-xl"></i>
              </c:if>
              <c:if test="${not empty mate.memberImgRename}">
                <img src="/resources/images/userProfileImg/${mate.memberImgRename}" />
              </c:if>
              ${mate.memberNick}(${mate.memberAge}, ${mate.memberGender})
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
  </body>
</html>
