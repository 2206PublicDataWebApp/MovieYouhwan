<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>무비유환 : 스토어 구매내역</title>
    <link rel="stylesheet" href="/resources/css/store.css" />
    <link rel="stylesheet" href="/resources/css/common.css" />
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/userStore.js" defer></script>
  </head>
  <body>
    <!-- FIXME: MUST DELETE #store-history-wrap BEFORE MERGE -->
    <div id="store-history-wrap">
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
            <button class="btn-search-by-period not-clicked">1주일</button>
            <button class="btn-search-by-period not-clicked">1개월</button>
            <button class="btn-search-by-period not-clicked">3개월</button>
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
      <div id="store-history-list">
        <h3>총 ${fn:length(storeHistory) }개</h3>
        <div>
          <div>주문번호</div>
          <div>상품명</div>
          <div>결제일</div>
          <div>유효기간</div>
          <div>결제금액</div>
          <div>상태</div>
        </div>
        <div>
          <div>202210130001</div>
          <div>무비유환 외 2</div>
          <div>2022.11.13</div>
          <div>~ 2023.11.12</div>
          <div>17,000원</div>
          <div class="status-canceled">취소완료</div>
        </div>
        <c:forEach items="${storeHistory }" var="history">
          <div>
            <div>${history.orderNo } 1</div>
            <div>${history.productName } 무비유환 외 2</div>
            <div>${history.payDate } 2022-11-13</div>
            <div>~${history.expiryDate } 2023-11-12</div>
            <div>${history.payAmount } 17,000원</div>
            <c:if test="${history.availability eq 'A'}">
              <div class="status-available">${history.availability } 사용가능</div>
            </c:if>
            <c:if test="${history.availability eq 'E'}">
              <div class="status-expired">${history.availability } 기간만료</div>
            </c:if>
            <c:if test="${history.availability eq 'C'}">
              <div class="status-canceled">${history.availability } 취소완료</div>
            </c:if>
          </div>
        </c:forEach>
      </div>
    </div>
  </body>
</html>
