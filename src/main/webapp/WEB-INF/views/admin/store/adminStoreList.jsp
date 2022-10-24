<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>무비유환 : 스토어 관리</title>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/header.css" />
    <link rel="stylesheet" href="/resources/css/store.css" />
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/store.js" defer></script>
  </head>
  <body>
  <jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
  <div id="store-wrapper">
    <div id="store-menu">
      <ul id="store-tab">
        <li class="store-tab-item"><a href="#">콤보</a></li>
        <li class="store-tab-item"><a href="#">팝콘</a></li>
        <li class="store-tab-item"><a href="#">음료</a></li>
        <li class="store-tab-item"><a href="#">스낵</a></li>
      </ul>
      <div id="store-links">
        <button class="btn-store-list btn-store-mng" id="btn-store-register">등록</button>
        <button class="btn-store-list btn-store-mng" id="btn-store-reorder">재배치</button>
      </div>
    </div>
    <div id="store-main">
      <%-- #product-per-type 반복 --%>
      <div class="product-per-type">
        <%-- .product-type에 동적으로 id 값 주기 --%>
        <h2 class="product-type">콤보</h2>
        <ul class="product-list">
          <%-- .product-item 반복 --%>
          <li class="product-item">
            <img src="/resources/images/storeProduct/hotdog.png" alt="${product.productImageRename}" class="product-img" />
            <div class="product-detail">
              <p class="product-desc">${product.productDesc}상품 설명</p>
              <p class="product-name">${product.productName}상품 이름</p>
              <p class="product-price">${product.productPrice}9,000원</p>
            </div>
            <div class="store-btn">
              <button class="btn-store-list btn-store-modify">수정</button>
              <button class="btn-store-list btn-store-delete">삭제</button>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
  <div id="modal-store-register">
    <jsp:include page="adminStoreRegister.jsp" />
  </div>
  <div id="modal-store-modify">
    <jsp:include page="adminStoreModify.jsp" />
  </div>
  </body>
</html>
