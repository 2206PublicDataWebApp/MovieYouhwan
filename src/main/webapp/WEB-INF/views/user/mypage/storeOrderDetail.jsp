<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>무비유환 : 스토어 구매내역</title>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/header.css" />
    <link rel="stylesheet" href="/resources/css/footer.css" />
    <link rel="stylesheet" href="/resources/css/user/my/myPage.css" />
    <link rel="stylesheet" href="/resources/css/user/my/myPageMain.css" />
    <link rel="stylesheet" href="/resources/css/storeHistory.css" />
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/jquery-3.6.1.min.js"></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
    <script src="/resources/js/userStoreHistory.js" defer></script>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/user/mypage/myPage.jsp"></jsp:include>
    <div id="mypage-content-wrap">
      <div id="order-detail-header">
        <h3>구매내역 상세</h3>
        <button id="btn-order-cancel" data-value="${order.orderNo }">주문 취소</button>
      </div>
      <div id="order-info">
        <div>
          <div>주문번호</div>
          <div id="order-no">${order.orderNo }</div>
          <div>상태</div>
          <div class="order-availability">${order.availability }</div>
        </div>
        <div>
          <div>결제일</div>
          <div class="order-pay-date">${order.payDate }</div>
          <div>유효기간</div>
          <div>${order.expiryDate }</div>
        </div>
      </div>
      <div id="order-detail-list">
        <div>
          <div>상품명</div>
          <div>수량</div>
        </div>
        <c:forEach items="${orderDetailList }" var="orderDetail">
          <div class="order-detail-item">
            <div class="detail-product-name">${orderDetail.productName }</div>
            <div class="detail-product-count">${orderDetail.productCount }개</div>
          </div>
        </c:forEach>
      </div>
      <p class="order-info-msg">* 부분취소는 불가능합니다.</p>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
  </body>
</html>
