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
      <div id="search-box">
        <div id="search-by-option">
          <div>조회내용</div>
          <div>
            <select name="" id="">
              <option value="all">전체</option>
              <option value="pay">결제내역</option>
              <option value="cancel">취소내역</option>
            </select>
          </div>
        </div>
        <div id="search-by-period">
          <div>조회기간</div>
          <div>
            <button class="btn-search-by-period filter-not-clicked">1주일</button>
            <button class="btn-search-by-period filter-not-clicked">1개월</button>
            <button class="btn-search-by-period filter-not-clicked">3개월</button>
          </div>
        </div>
        <div id="search-by-date">
          <div>
            <input type="date" id="start-date" />
          </div>
          <div>~</div>
          <div>
            <input type="date" id="end-date" />
          </div>
        </div>
        <div>
          <button id="btn-search-by-filter">조회</button>
        </div>
      </div>
      <div id="store-order-list">
        <h3>총 ${fn:length(orderList) }건</h3>
        <div>
          <div>주문번호</div>
          <div>상품명</div>
          <div>결제일</div>
          <div>유효기간</div>
          <div>결제금액</div>
          <div>상태</div>
        </div>
        <c:if test="${not empty orderList }">
          <c:forEach items="${orderList }" var="order">
            <div class="store-order-item">
              <a href="/mypage/store/detail.yh?orderNo=${order.orderNo}" class="order-no">${order.orderNo }</a>
              <a href="/mypage/store/detail.yh?orderNo=${order.orderNo}" class="order-product-name">${order.productName }</a>
              <div class="order-pay-date">${order.payDate }</div>
              <div>~${order.expiryDate }</div>
              <div class="order-price">${order.payAmount }</div>
              <div class="order-availability">${order.availability }</div>
            </div>
          </c:forEach>
        </c:if>
        <c:if test="${empty orderList}">
          <div id="no-data-msg">조회 결과가 없습니다.</div>
        </c:if>
      </div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
  </body>
</html>
