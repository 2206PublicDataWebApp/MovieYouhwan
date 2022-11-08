<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>무비유환 : 스토어 장바구니</title>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/header.css" />
    <link rel="stylesheet" href="/resources/css/footer.css" />
    <link rel="stylesheet" href="/resources/css/store.css" />
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
    <script src="/resources/js/userStore.js" defer></script>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div id="store-wrapper">
      <div id="store-step-box">
        <div id="store-step-cart" class="store-each-step">
          <i class="fa-solid fa-cart-shopping fa-3x"></i>
          <div>
            <p>STEP 01</p>
            <p>장바구니</p>
          </div>
        </div>
        <i class="fa-solid fa-chevron-right fa-3x"></i>
        <div class="store-each-step">
          <i class="fa-regular fa-credit-card fa-3x"></i>
          <div>
            <p>STEP 02</p>
            <p>결제하기</p>
          </div>
        </div>
        <i class="fa-solid fa-chevron-right fa-3x"></i>
        <div class="store-each-step">
          <i class="fa-regular fa-circle-check fa-3x"></i>
          <div>
            <p>STEP 03</p>
            <p>결제완료</p>
          </div>
        </div>
      </div>
      <!-- TODO: PRODUCT_STATUS = 'N'이면 구매 못함 -->
      <div id="store-cart-list">
        <div id="ghead-cart-list">
          <div><input type="checkbox" id="check-all-product" /></div>
          <div>상품</div>
          <div>판매금액</div>
          <div>수량</div>
          <div>구매금액</div>
        </div>
        <div id="gbody-cart-list">
        <c:forEach items="${cartList }" var="cart">
          <input type="hidden" class="cart-no" value="${cart.cartNo }">
          <div><input type="checkbox" class="check-one-product" /></div>
          <div><img src="/resources/images/storeProduct/${cart.productImgRename }" alt="상품사진" /></div>
          <div>${cart.productName }</div>
          <div class="cart-price">${cart.productPrice }</div>
          <div>
            <input type="number" name="productCount" min="1" max="10" step="1" value="${cart.productCount }" <c:if test="${cart.productStatus eq 'N' }">disabled</c:if> />
            <button class="btn-change-count" <c:if test="${cart.productStatus eq 'N' }">disabled</c:if>>변경</button>
          </div>
          <div class="cart-price product-price-per-count">${cart.productPrice * cart.productCount }</div>
          </c:forEach>
        </div>
        <button id="btn-cart-delete">삭제</button>
      </div>
      <div id="store-cart-price">
        <div id="ghead-cart-price">
          <div>총 상품 금액</div>
          <div></div>
          <div>할인 금액</div>
          <div></div>
          <div>총 결제 예정 금액</div>
        </div>
        <div id="gbody-cart-price">
          <div id="total-cart-amount" class="cart-price"></div>
          <div></div>
          <div id="discount-amount" class="cart-price">0</div>
          <div></div>
          <div id="total-pay-amount" class="cart-price"></div>
        </div>
      </div>
      <div id="cart-btn-area">
        <button class="btn-store-cart" id="btn-cart-back">돌아가기</button>
        <button class="btn-store-cart" id="btn-cart-pay">구매하기</button>
      </div>
    </div>
  </body>
</html>
