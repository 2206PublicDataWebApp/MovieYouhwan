// 상품 목록 - 상품 가격에 천 단위로 콤마(,) 삽입
showCommas($('p.product-price'));

// 장바구니 - 총 상품 금액 및 총 결제 예정 금액 계산
let totalCartAmount = 0;
let totalPayAmount = 0;
let discountAmount = $('#discount-amount').text();
$('.product-price-per-count').each(function () {
  totalCartAmount += parseInt($(this).text());
});
totalPayAmount = totalCartAmount - discountAmount;
$('#total-cart-amount').text(totalCartAmount);
$('#total-pay-amount').text(totalPayAmount);

// 장바구니 - 상품 가격에 천 단위로 콤마(,) 삽입
showCommas($('.cart-price'));

// 상품 상세 - 상품 가격에 천 단위로 콤마(,) 삽입
showCommas($('.detail-price'));

// 상품 목록 - 상품 구매 페이지로 이동
$('.btn-store-buy').click(function () {
  if (!$('#profile-user').length) {
    if (confirm('로그인이 필요한 서비스입니다.\n로그인 화면으로 이동하시겠습니까?')) {
      $(this).attr('href', '/member/loginView.yh');
    } else {
      e.preventDefault();
    }
  } else {
    $(location).attr('href', '/store/pay.yh');
  }
});

// 상품 목록, 상품 상세 - 장바구니 페이지로 이동 시 로그인 체크
// 장바구니 - 상품 수량 변경 또는 구매하기 버튼 클릭 시 로그인 체크
$('#store-link-cart, .btn-change-count').click(function (e) {
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
    let productTypeNo = strToNum($(this).parent().parent().parent().siblings('.product-type').attr('id'));
    let productType = $(this).parent().parent().parent().siblings('.product-type').text();
    let productPrice = strToNum($(this).parent().siblings('.product-detail').children('.product-price').text());
    let productCount = 1;
    let productImgRename = $(this).parent().siblings('a').children('img').attr('id');

    addProductToCart(productNo, productName, productTypeNo, productType, productPrice, productCount, productImgRename);
  } else {
    if (confirm('로그인이 필요한 서비스입니다.\n로그인 화면으로 이동하시겠습니까?')) {
      $(location).attr('href', '/member/loginView.yh');
    }
  }
});

// 상품 상세 - 상품 수량 변경 시 총 상품 금액 변경
$('#detail-product-count').change(function () {
  let productPricePerCount = $(this).val() * strToNum($('.detail-price').eq(0).text());
  console.log(productPricePerCount);
  $('.detail-price').eq(1).text(showCommas(productPricePerCount));
});

// 장바구니, 결제 완료 - 상품 목록 페이지로 이동
$('#btn-cart-back, #btn-store-list').click(function () {
  $(location).attr('href', '/store.yh');
});

// 장바구니 - 전체 선택 체크박스 체크하면 개별 체크박스 모두 체크
$('#check-all-product').click(function () {
  if ($(this).is(':checked')) {
    $('.check-one-product').prop('checked', true);
  } else {
    $('.check-one-product').prop('checked', false);
  }
});

// 장바구니 - 개별 체크박스 모두 체크하면 전체 선택 체크박스 체크
$('.check-one-product').click(function () {
  let checkBox = $('.check-one-product');
  let checkBoxCount = checkBox.length;
  let checkedCount = 0;
  checkBox.each(function (idx, element) {
    if (checkBox.eq(idx).is(':checked')) {
      checkedCount++;
    }
  });
  if (checkBoxCount == checkedCount) {
    $('#check-all-product').prop('checked', true);
  } else {
    $('#check-all-product').prop('checked', false);
  }
});

// 장바구니 - 상품 수량 변경
$('.btn-change-count').click(function () {
  if ($('#profile-user').length) {
    let cartNo = $(this).parent().prev().prev().prev().prev().children('input[type=checkbox]').val();
    console.log(cartNo);
    let productCount = $(this).siblings('input[type=number]').val();
    $.ajax({
      url: '/store/cart/modifyProductCount.yh',
      type: 'POST',
      data: {
        cartNo: cartNo,
        productCount: productCount,
      },
      success: function (url) {
        if (url != '') {
          $(location).attr('href', '/member/loginView.yh');
        }
      },
      error: function () {
        alert('문제가 발생했습니다. 다시 시도해주세요.');
        $(window).prop('location', loation.href);
      },
    });
  } else {
    $(location).attr('href', '/member/loginView.yh');
  }
});

// 장바구니 - 상품 삭제
$('#btn-cart-delete').click(function () {
  if ($('#profile-user').length) {
    let cartNoList = [];
    $('.cart-no:checked').each(function () {
      cartNoList.push($(this).val());
    });
    if (cartNoList.length > 0) {
      $.ajax({
        url: '/store/cart/deleteProducts.yh',
        type: 'POST',
        data: {
          cartNoList: cartNoList,
        },
        success: function (url) {
          if (url == '') {
            console.log(url);
            alert('문제가 발생했습니다. 다시 시도해주세요.');
            location.reload();
          } else {
            $(location).attr('href', url);
          }
        },
        error: function () {
          alert('문제가 발생했습니다. 다시 시도해주세요.');
          location.reload();
        },
      });
    } else {
      alert('삭제할 상품을 선택해주세요.');
    }
  } else {
    $(location).attr('href', '/member/loginView.yh');
  }
});

/**
 * 상품 가격에 천 단위로 콤마(,) 삽입
 * @param {*} numberStr
 */
function showCommas(num) {
  num.each(function () {
    let price = Number($(this).text());
    $(this).text(price.toLocaleString() + '원');
  });
}

/**
 * 상품 가격에서 콤마 제거 후 숫자형 반환
 * @param {*} str
 * @returns
 */
function strToNum(str) {
  let price = parseInt(str.replace(/[^0-9]/g, ''));
  return price;
}

/**
 * 장바구니에 상품 담기
 * @param {*} name
 * @param {*} type
 * @param {*} count
 */
function addProductToCart(productNo, productName, productTypeNo, productType, productPrice, productCount, productImgRename) {
  $.ajax({
    url: '/store/cart/addProduct.yh',
    type: 'POST',
    data: {
      productNo: productNo,
      productName: productName,
      productTypeNo: productTypeNo,
      productType: productType,
      productPrice: productPrice,
      productCount: productCount,
      productImgRename: productImgRename,
    },
    success: function (url) {
      if (url == '') {
        if (confirm('장바구니에 상품을 담았습니다.\n장바구니로 이동하시겠습니까?')) {
          $(location).attr('href', '/store/cart.yh');
        }
      } else {
        $(location).attr('href', url);
      }
    },
    error: function () {
      alert('문제가 발생했습니다. 다시 시도해주세요.');
      location.reload();
    },
  });
}
