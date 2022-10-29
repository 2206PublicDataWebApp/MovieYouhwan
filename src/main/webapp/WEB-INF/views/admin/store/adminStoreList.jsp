<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
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
    <link rel="stylesheet" href="/resources/css/jquery-ui.min.css" />
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/jquery-ui.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/adminStore.js" defer></script>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
    <div id="store-wrapper">
      <div id="store-menu">
        <ul id="store-tab">
          <c:forEach items="${productTypeList }" var="productType">
            <li class="store-tab-item"><a href="#">${productType.productType }</a></li>
          </c:forEach>
        </ul>
        <div id="store-links">
          <button type="button" class="btn-store-list btn-store-mng" id="btn-store-register">등록</button>
          <button type="button" class="btn-store-list btn-store-mng" id="btn-store-reorder">재배치</button>
        </div>
      </div>
      <div id="store-main">
        <%-- #product-per-type 반복 --%>
        <c:forEach items="${productTypeList }" var="productType">
        <div class="product-per-type">
          <%-- .product-type에 동적으로 id 값 주기 --%>
          <h2 class="product-type">${productType.productType }</h2>
          <ul class="product-list">
            <%-- .product-item 반복 --%>
            <c:forEach items="${productList }" var="product">
              <li class="product-item">
                <img src="${product.productImgRename}" alt="" class="product-img" />
                <div class="product-detail">
                  <p class="product-desc">${product.productDesc}</p>
                  <p class="product-name">${product.productName}</p>
                  <p class="product-price">${product.productPrice}</p>
                </div>
                <div class="store-btn">
                  <button class="btn-store-list btn-store-modify">수정</button>
                  <button class="btn-store-list btn-store-delete">삭제</button>
                </div>
              </li>
            </c:forEach>
          </ul>
        </div>
      </c:forEach>
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
