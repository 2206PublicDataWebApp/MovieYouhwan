<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>무비유환 : 스토어 상품 재배치</title>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/header.css" />
    <link rel="stylesheet" href="/resources/css/footer.css" />
    <link rel="stylesheet" href="/resources/css/store.css" />
    <link rel="stylesheet" href="/resources/css/jquery-ui.min.css" />
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/jquery-ui.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
    <script src="/resources/js/adminStore.js" defer></script>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
    <div id="store-wrapper">
      <div id="store-menu">
        <ul id="store-tab-list">
          <c:forEach items="${productTypeList }" var="productType">
            <li class="store-tab-item"><a href="#productTypeNo${productType.productTypeNo }">${productType.productType }</a></li>
          </c:forEach>
        </ul>
        <div id="store-links">
          <button class="btn-store-list btn-store-mng" id="btn-store-cancel">취소</button>
          <button class="btn-store-list btn-store-mng" id="btn-store-save">저장</button>
        </div>
      </div>
      <div id="store-main">
        <c:forEach items="${productTypeList }" var="productType">
          <div class="product-per-type">
            <h2 class="product-type" id="productTypeNo${productType.productTypeNo }">${productType.productType }</h2>
            <ul class="product-list sortable">
              <c:forEach items="${productList }" var="product">
                <c:if test="${productType.productType eq product.productType }">
                  <li class="product-item" id="${product.productNo }">
                    <input type="hidden" value="${product.productOrder }" />
                    <img src="/resources/images/storeProduct/${product.productImgRename}" alt="" class="product-img" />
                    <div class="product-detail">
                      <p class="product-desc">${product.productDesc}</p>
                      <p class="product-name">${product.productName}</p>
                      <p class="product-price">${product.productPrice}</p>
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
