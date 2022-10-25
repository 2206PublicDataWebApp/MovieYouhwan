<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>무비유환 : 스토어 결제 완료</title>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/header.css" />
    <link rel="stylesheet" href="/resources/css/store.css" />
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
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
        <div class="store-each-step">
          <i class="fa-regular fa-credit-card fa-3x"></i>
          <div>
            <p>STEP 02</p>
            <p>결제하기</p>
          </div>
        </div>
        <i class="fa-solid fa-chevron-right fa-3x"></i>
        <div id="store-step-complete" class="store-each-step">
          <i class="fa-regular fa-circle-check fa-3x"></i>
          <div>
            <p>STEP 03</p>
            <p>결제완료</p>
          </div>
        </div>
      </div>
      <div id="store-complete-main">
        <div id="msg-store-complete">
          <h3>결제가 완료되었습니다.</h3>
          <br /><br />
          <p>주문번호: 20221012000001</p>
        </div>
        <table id="tbl-store-complete">
          <tr>
            <th>총 상품 금액</th>
            <td>21,900 원</td>
          </tr>
          <tr>
            <th>할인 금액</th>
            <td>0 원</td>
          </tr>
          <tr>
            <th>총 결제 금액</th>
            <td>21,900 원</td>
          </tr>
        </table>
        <p>* 오프라인 매점에서 주문번호를 제시하여 상품으로 교환 가능합니다.</p>
        <div>
          <button class="btn-store-complete" id="btn-store-history">결제내역</button>
          <button class="btn-store-complete" id="btn-store-list">상품 더보기</button>
        </div>
      </div>
    </div>
  </body>
</html>
