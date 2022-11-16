<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>무비유환</title>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/header.css" />
    <link rel="stylesheet" href="/resources/css/footer.css" />
    <link rel="stylesheet" href="/resources/css/home.css" />
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/jquery-3.6.1.min.js"></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
    <script src="/resources/js/home.js" defer></script>
  </head>
  <body>
    <jsp:include page="common/header.jsp"></jsp:include>
    <div id="main-banner">
      <video src="/resources/images/cinemaLodeImg/"></video>
    </div>
    <div id="main-wrap">
      <div id="movie-chart-wrap">
        <h2><a href="/movieList.yh">MOVIE CHART</a></h2>
        <div id="movie-chart-list">
          <!-- TODO: c:forEach 사용 -->
          <div class="movie-chart-item">
            <div class="movie-img">
              <a href="/movieDetail.yh"><img src="/resources/images/movieLodeImg/202210281010222.jpg" alt="" /></a>
            </div>
            <div class="movie-title">듄</div>
            <div class="movie-opening-date">2022-10-11 개봉</div>
          </div>
        </div>
      </div>
      <div id="store-best-wrap">
        <h2><a href="/store.yh">STORE BEST</a></h2>
        <div id="store-best-list">
          <c:forEach items="${productList }" var="product">
            <div class="store-best-item">
              <div class="product-img">
                <a href="/store/detail.yh?productTypeNo=${product.productTypeNo }&productNo=${product.productNo }"><img src="/resources/images/storeProduct/${product.productImgRename}" alt="" /></a>
              </div>
              <div class="product-name">${product.productName }</div>
              <div class="product-price">${product.productPrice }</div>
            </div>
          </c:forEach>
        </div>
      </div>
      <div id="support-preview-wrap">
        <h2><a href="/support.yh">SUPPORT</a></h2>
        <div id="support-preview-list">
          <div id="faq-preview-wrap">
            <h3><a href="/support.yh?tabIndex=0">FAQ</a></h3>
            <div id="faq-preview-list">
              <c:forEach items="${faqList }" var="faq">
                <a href="/support.yh?tabIndex=0" class="faq-preview-item">${faq.faqTitle } </a>
              </c:forEach>
            </div>
          </div>
          <div id="notice-preview-wrap">
            <h3><a href="/support.yh?tabIndex=2">공지사항</a></h3>
            <div id="notice-preview-list">
              <c:forEach items="${noticeList }" var="notice">
                <a href="/support/noticeDetail.yh?noticeNo=${notice.noticeNo }" class="notice-preview-item">${notice.noticeTitle }</a>
              </c:forEach>
            </div>
          </div>
        </div>
      </div>
    </div>
    <jsp:include page="common/footer.jsp"></jsp:include>
  </body>
</html>
