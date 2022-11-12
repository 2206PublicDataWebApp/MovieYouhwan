<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>무비유환 : 스토어</title>
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
    <div id="store-banner"><img src="/resources/images/storeBanner03.jpg" alt="배너사진" /></div>
    <div id="store-wrapper">
      <div id="store-menu">
        <ul id="store-tab">
          <li class="store-tab-item"><a href="">콤보</a></li>
          <li class="store-tab-item"><a href="">팝콘</a></li>
          <li class="store-tab-item"><a href="">음료</a></li>
          <li class="store-tab-item"><a href="">스낵</a></li>
        </ul>
        <ul id="store-links">
          <li>
            <a id="store-link-cart" href="/store/cart.yh">장바구니<i class="fa-solid fa-cart-shopping"></i></a>
          </li>
        </ul>
      </div>
      <form action="/store/buy.yh" method="post">
        <input type="hidden" name="productNo" value="${product.productNo }" id="product-no">
        <input type="hidden" name="productTypeNo" value="${productTypeNo }" id="product-type-no">
        <input type="hidden" name="productType" value="${product.productType }" id="product-type">
        <div id="grid-store-detail">
          <div class="gitem-store-detail"><h2 id="product-name">${product.productName }</h2></div>
          <div class="gitem-store-detail"><img src="/resources/images/storeProduct/${product.productImgRename }" alt="상품사진" class="detail-product-img" id="${product.productImgRename }" /></div>
          <div class="gitem-store-detail detail-price">${product.productPrice }</div>
          <div class="gitem-store-detail">상품구성</div>
          <div class="gitem-store-detail">${product.productDesc }</div>
          <div class="gitem-store-detail">유효기간</div>
          <div class="gitem-store-detail">구매일로부터 6개월 이내</div>
          <div class="gitem-store-detail">상품수량</div>
          <div class="gitem-store-detail">
            <input type="number" name="productCount" id="detail-product-count" min="1" max="10" step="1" value="1" />
          </div>
          <div class="gitem-store-detail">총 상품 금액</div>
          <div class="gitem-store-detail detail-price">${product.productPrice }</div>
          <div class="gitem-store-detail">
            <button class="btn-detail" id="btn-detail-buy">구매</button>
          </div>
          <div class="gitem-store-detail">
            <button type="button" class="btn-detail" id="btn-detail-cart"><i class="fa-solid fa-cart-plus"></i></button>
          </div>
        </div>
      </form>
      <div>
        <h4>이용안내</h4>
        <p>- 스토어 상품은 회원만 구매할 수 있습니다.</p>
        <p>- 본 상품은 오프라인 매점에서 실제 상품으로 교환할 수 있는 온라인 상품권입니다.</p>
        <p>- 결제가 완료된 상품은 "마이페이지 > 구매내역"에서 확인 가능합니다.</p>
        <p>- 오프라인 매점에서 주문번호 제시 후 상품으로 교환할 수 있습니다.</p>
        <p>- 팝콘 및 음료의 크기 변경 시 추가 금액이 발생할 수 있습니다.</p>
        <p>- 상기 이미지는 실제 제품과 상이할 수 있습니다.</p>
        <p>- 본 상품은 실 결제 금액에 한하여 상품 교환 후 포인트 적립이 가능합니다.</p>
      </div>
      <br />
      <div>
        <h4>취소/환불</h4>
          <p>- 최초 유효기간 이내에 취소하면 결제 금액의 100% 환불이 가능합니다.</p>
          <p>- 이미 사용된 상품권에 대해서는 취소/환불이 불가능합니다.</p>
          <p>- 결제 취소는 "마이페이지 > 구매내역"에서 가능합니다.</p>
      </div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
  </body>
</html>
