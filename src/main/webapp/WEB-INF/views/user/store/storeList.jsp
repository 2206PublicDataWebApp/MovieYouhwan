<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>무비유환 : 스토어</title>
    <link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
    <link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
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
        <ul id="store-tab-list">
          <c:forEach items="${productTypeList }" var="productType">
            <li class="store-tab-item" data-value="product-per-type${productType.productTypeNo }"><a>${productType.productType }</a></li>
          </c:forEach>
        </ul>
        <ul id="store-links">
          <li>
            <a id="store-link-cart" href="/store/cart.yh">장바구니<i class="fa-solid fa-cart-shopping"></i></a>
          </li>
        </ul>
      </div>
      <div id="store-main">
        <c:forEach items="${productTypeList }" var="productType">
          <div class="product-per-type" id="product-per-type${productType.productTypeNo }">
            <h2 class="product-type" id="product-type-no${productType.productTypeNo }">${productType.productType }</h2>
            <ul class="product-list">
              <c:forEach items="${productList }" var="product">
                <c:if test="${productType.productType eq product.productType }">
                  <li class="product-item" id="${product.productNo }">
                    <a href="/store/detail.yh?productTypeNo=${productType.productTypeNo }&productNo=${product.productNo}">
                      <img src="/resources/images/storeProduct/${product.productImgRename}" alt="" class="product-img" id="${product.productImgRename }" />
                    </a>
                    <div class="product-detail">
                      <p class="product-desc">${product.productDesc}</p>
                      <p class="product-name">${product.productName}</p>
                      <p class="product-price">${product.productPrice}</p>
                    </div>
                    <div class="store-btn">
                      <button type="button" class="btn-store-list btn-buy-product">구매</button>
                      <button type="button" class="btn-store-list btn-add-cart"><i class="fa-solid fa-cart-plus"></i></button>
                    </div>
                  </li>
                </c:if>
              </c:forEach>
            </ul>
          </div>
        </c:forEach>
      </div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
  </body>
</html>
