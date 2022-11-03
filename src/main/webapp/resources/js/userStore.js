// 상품 구매 페이지로 이동
$('.btn-store-buy').click(function () {
  $(location).attr('href', '/store/payView.yh');
});

// 상품 목록 - 장바구니에 상품 담기
$('.btn-store-list.btn-store-cart').click(function () {
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
  console.log(productNo, productName, productTypeNo, productType, productCount); // vc
  addProductToCart(productNo, productName, productTypeNo, productType, productCount);
});

// 상품 목록, 상품 상세 - 결제내역 페이지로 이동
$('#btn-store-history').click(function () {
  $(location).attr('href', '/my/myPage.yh');
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
  console.log(productNo, productName, productTypeNo, productType, productCount); // vc
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
    error: function () {
      alert('안 됨 ㅅㄱ');
    },
  });
}
