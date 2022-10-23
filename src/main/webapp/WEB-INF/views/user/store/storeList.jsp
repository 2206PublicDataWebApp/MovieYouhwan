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
    <link rel="stylesheet" href="/resources/css/store.css" />
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div id="store-banner"><img src="" alt="배너사진" /></div>
    <div id="store-wrapper">
      <div id="store-menu">
        <ul id="store-tab">
          <%-- TODO: Use c:forEach to repeat .store-tab-item, Modify values of href attr --%>
          <li class="store-tab-item"><a href="#">콤보</a></li>
          <li class="store-tab-item"><a href="#">팝콘</a></li>
          <li class="store-tab-item"><a href="#">음료</a></li>
          <li class="store-tab-item"><a href="#">스낵</a></li>
        </ul>
        <ul id="store-links">
          <li><a href="#">구매내역</a></li>
          <li>
            <a href="/store/cart.yh">장바구니<i class="fa-solid fa-cart-shopping"></i></a>
          </li>
        </ul>
      </div>
      <div id="store-main">
        <%-- TODO: Use c:forEach to repeat #product-per-type--%>
        <div class="product-per-type">
          <%-- TODO: Bring value of id of .product-type from DB --%>
          <h3 class="product-type">콤보</h3>
          <ul class="product-list">
            <%-- TODO: Use c:forEach to repeat .product-item --%>
            <li class="product-item">
              <img src="/resources/images/storeProduct/solo_combo.jpg" alt="${product.productImageRename}" class="product-img" />
              <div class="product-detail">
                <p class="product-desc">${product.productDesc}</p>
                <p class="product-name">${product.productName}</p>
                <p class="product-price">${product.productPrice}</p>
              </div>
              <div class="store-btn">
                <button class="btn-store-list btn-store-buy">구매</button>
                <button class="btn-store-list btn-store-cart"><i class="fa-solid fa-cart-plus"></i></button>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </body>
</html>
