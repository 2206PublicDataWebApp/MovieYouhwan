<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>무비유환 : 스토어 결제</title>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/header.css" />
    <link rel="stylesheet" href="/resources/css/footer.css" />
    <link rel="stylesheet" href="/resources/css/store.css" />
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
    <script src="/resources/js/userStore.js" defer></script>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div id="store-wrapper">
      <div id="store-step-box">
        <div class="store-each-step">
          <i class="fa-solid fa-cart-shopping fa-3x"></i>
          <div>
            <p>STEP 01</p>
            <p>장바구니</p>
          </div>
        </div>
        <i class="fa-solid fa-chevron-right fa-3x"></i>
        <div id="store-step-pay" class="store-each-step">
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
      <div id="store-buy-list">
        <div id="store-buy-head">
          <div>상품</div>
          <div>판매금액</div>
          <div>수량</div>
          <div>구매금액</div>
        </div>
        <c:forEach items="${cartList}" var="cart">
          <div class="store-buy-body">
            <div><img src="/resources/images/storeProduct/${cart.productImgRename }" alt="상품사진" /></div>
            <div>${cart.productName }</div>
            <div>${cart.productPrice }</div>
            <div>${cart.productCount }</div>
            <div>${cart.productPrice * productCount }</div>
          </div>
        </c:forEach>
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
          <div><i class="fa-solid fa-plus"></i></div>
          <div id="discount-amount" class="cart-price">0</div>
          <div><i class="fa-solid fa-equals"></i></div>
          <div id="total-pay-amount" class="cart-price"></div>
        </div>
      </div>
    </div>
    <div>
      <h2>결제수단</h2>
      <div id="radio-pay-method">
        <label for="pay-method-card"> <input type="radio" name="pay-method" value="card" id="pay-method-card" />신용카드 </label>
        <label for="pay-method-trans"><input type="radio" name="pay-method" value="trans" id="pay-method-trans" />계좌이체</label>
        <label for="pay-method-vbank"><input type="radio" name="pay-method" value="vbank" id="pay-method-vbank" />무통장입금</label>
        <label for="pay-method-kakaopay"><input type="radio" name="pay-method" value="kakaopay" id="pay-method-kakaopay" />카카오페이</label>
      </div>
      <div></div>
    </div>
    <div id="buy-btn-area">
      <button class="btn-store-buy" id="btn-buy-prev">이전 단계</button>
      <button class="btn-store-buy" id="btn-buy-next">결제하기</button>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
  </body>
</html> -->
