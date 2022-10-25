/** 상품 구매 View (Page) */
$('.btn-store-buy').click(function () {
  $(location).attr('href', '/store/payView.yh');
});

/** 장바구니 View (Page) */
$('.btn-store-cart').click(function () {
  $(location).attr('href', '/store/cart.yh');
});

/** 결제내역 View */
$('#btn-store-history').click(function () {
  $(location).attr('href', '/my/myPage.yh');
});

/** 스토어 View */
$('#btn-store-list').click(function () {
  $(location).attr('href', '/store/list.yh');
});
