/** storeList */

/* 상품 구매 View (Page) */
$('.btn-store-buy').click(function () {
  $(location).attr('href', '/store/payView.yh');
});

/* 장바구니에 담고 이동 */
$('.btn-store-cart').click(function () {
  $(location).attr('href', '/store/cart.yh');
});

/* 결제내역 View */
$('#btn-store-history').click(function () {
  $(location).attr('href', '/my/myPage.yh');
});

/** storeCart */

/** storeComplete */
/* 스토어 View */
$('#btn-store-list').click(function () {
  $(location).attr('href', '/store/list.yh');
});
