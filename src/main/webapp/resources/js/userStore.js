// 상품 구매 페이지로 이동
$('.btn-store-buy').click(function () {
  $(location).attr('href', '/store/payView.yh');
});

// 상품 목록 - 상품 상세 페이지로 이동
$('');

// 상품 목록, 상품 상세 - 장바구 또는 구매내역 페이지로 이동 전 로그인 체크
$('#link-store-history, #link-store-cart').click(function (e) {
  if (!$('#profile-user').length) {
    if (confirm('로그인이 필요한 서비스입니다.\n로그인 화면으로 이동하시겠습니까?')) {
      $(this).attr('href', '/member/loginView.yh');
    } else {
      e.preventDefault();
    }
  }
});

// 상품 목록 - 장바구니에 상품 담기
$('.btn-store-list.btn-store-cart').click(function (e) {
  if ($('#profile-user').length) {
    let productNo = $(this).parent().parent().attr('id');
    let productName = $(this).parent().siblings('.product-detail').children('.product-name').text();
    let productTypeNo = $(this)
      .parent()
      .parent()
      .parent()
      .siblings('.product-type')
      .attr('id')
      .replace(/[^0-9]/g, '');
    let productType = $(this).parent().parent().parent().siblings('.product-type').text();
    let productCount = 1;
    addProductToCart(productNo, productName, productTypeNo, productType, productCount);
  } else {
    if (confirm('로그인이 필요한 서비스입니다.\n로그인 화면으로 이동하시겠습니까?')) {
      $(location).attr('href', '/member/loginView.yh');
    }
  }
});

// 장바구니, 결제완료 - 상품 목록 페이지로 이동
$('#btn-store-list').click(function () {
  $(location).attr('href', '/store/list.yh');
});

/**
 * 장바구니에 상품 담기
 * @param {*} name
 * @param {*} type
 * @param {*} count
 */
function addProductToCart(productNo, productName, productTypeNo, productType, productCount) {
  $.ajax({
    url: '/store/addToCart.yh',
    type: 'POST',
    data: {
      productNo: productNo,
      productName: productName,
      productTypeNo: productTypeNo,
      productType: productType,
      productCount: productCount,
    },
    success: function () {
      if (confirm('장바구니에 상품을 담았습니다.\n장바구니로 이동하시겠습니까?')) {
        $(location).attr('href', '/store/cart.yh');
      }
    },
    error: function () {},
  });
}
