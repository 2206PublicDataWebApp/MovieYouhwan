<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
    <script src="/resources/js/userStore.js" defer></script>
  </head>
  <body>
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
    </div>
  </body>
</html>
