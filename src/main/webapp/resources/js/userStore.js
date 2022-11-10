// import * as pay from './requestPay.js';

// 상품 목록 - 상품 가격에 천 단위로 콤마(,) 삽입
showCommas($('p.product-price'));

// 장바구니, 상품 구매 - 총 상품 금액 및 총 결제 예정 금액 계산
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

// 상품 구매 - 상품 가격에 천 단위로 콤마(,) 삽입
showCommas($('.buy-price'));

// 상품 목록 - 상품 구매
$('.btn-buy-product').click(function () {
  if ($('#profile-user').length) {
    let productNo = $(this).parent().parent('.product-item').attr('id');
    buyProduct('productNo', productNo);
  } else {
    if (confirm('로그인이 필요한 서비스입니다.\n로그인 화면으로 이동하시겠습니까?')) {
      $(location).attr('href', '/member/loginView.yh');
    }
  }
});

// TODO: ajax -> 동적 form (근데 form 태그로도 list 보낼 수 있었나?)
// 장바구니 - 상품 구매
$('#btn-cart-buy').click(function () {
  let flag = true;
  if ($('#profile-user').length) {
    let cartNoList = [];
    $('.cart-no:checked').each(function () {
      if ($(this).is(':disabled')) {
        let disabledProduct = $(this).parent().next().next().text();
        alert(disabledProduct + '는 구매 불가능한 상품입니다.\n장바구니에서 삭제한 후 다시 시도해주세요.');
        flag = false;
      } else {
        cartNoList.push($(this).val());
      }
    });
    if (!flag) {
      return;
    }
    if (cartNoList.length > 0) {
      $.ajax({
        url: '/store/buy.yh',
        type: 'POST',
        data: {
          cartNoList: cartNoList,
        },
        success: function () {},
        error: function () {
          alert('문제가 발생했습니다. 다시 시도해주세요.');
          location.reload();
        },
      });
    } else {
      alert('구매할 상품을 선택해주세요.');
    }
  } else {
    $(location).attr('href', '/member/loginView.yh');
  }
});

// 상품 목록, 상품 상세 - 장바구니 페이지로 이동 시 로그인 체크
$('#store-link-cart').click(function (e) {
  if (!$('#profile-user').length) {
    if (confirm('로그인이 필요한 서비스입니다.\n로그인 화면으로 이동하시겠습니까?')) {
      $(location).attr('href', '/member/loginView.yh');
    } else {
      e.preventDefault();
    }
  }
});

// 상품 목록 - 장바구니에 상품 담기
$('.btn-store-list.btn-add-cart').click(function (e) {
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

// 상품 상세 - 장바구니에 상품 담기
$('#btn-detail-cart').click(function () {
  if ($('#profile-user').length) {
    let productNo = $('#product-no').val();
    let productName = $('#product-name').text();
    let productTypeNo = $('#product-type-no').val();
    let productType = $('#product-type').val();
    let productPrice = strToNum($('.detail-price').eq(0).text());
    let productCount = $('#detail-product-count').val();
    let productImgRename = $('.detail-product-img').attr('id');

    addProductToCart(productNo, productName, productTypeNo, productType, productPrice, productCount, productImgRename);
  } else {
    if (confirm('로그인이 필요한 서비스입니다.\n로그인 화면으로 이동하시겠습니까?')) {
      $(location).attr('href', '/member/loginView.yh');
    }
  }
});

// 상품 상세 - 상품 수량 변경 시 총 상품 금액 변경
$('#detail-product-count').bind('keyup mouseup', function () {
  let productPricePerCount = $(this).val() * strToNum($('.detail-price').eq(0).text());
  $('.detail-price').eq(1).text(productPricePerCount);
  showCommas($('.detail-price').eq(1));
});

// 장바구니, 결제 완료 - 상품 목록 페이지로 이동
$('#btn-cart-back, #btn-to-store').click(function () {
  $(location).attr('href', '/store.yh');
});

// 장바구니 - 전체 선택 체크박스 체크하면 개별 체크박스 모두 체크
$('#check-all-product').click(function () {
  if ($(this).is(':checked')) {
    $('.check-one-product').not(':disabled').prop('checked', true);
  } else {
    $('.check-one-product').not(':disabled').prop('checked', false);
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
    let productCount = $(this).siblings('input[type=number]').val();
    let productPrice = $(this).parent().prev();
    let productPricePerCount = $(this).parent().next();
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
        } else {
          productPricePerCount.text(strToNum(productPrice.text()) * productCount);
          showCommas(productPricePerCount);
        }
      },
      error: function () {
        alert('문제가 발생했습니다. 다시 시도해주세요.');
        location.reload();
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

// 상품 구매 - 이전 단계로 이동
$('#btn-buy-prev').click(function () {
  history.back();
});

// 상품 구매 - 결제하기
$('#btn-buy-pay').click(function () {
  console.log('pay!!!!');
  let payMethod = $('.pay-method').filter(':checked').val();
  let productName = $('#product-name').text();
  let totalAmount = strToNum($('#total-pay-amount').text());
  let memberName = '최현지';
  let memberPhone = '010-1111-2222';

  requestKgpay(payMethod, productName, totalAmount, memberName, memberPhone);
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

/**
 * 상품 구매
 * @param {*} name
 * @param {*} value
 */
function buyProduct(name, value) {
  let buyForm = $('<form></form>');
  buyForm.attr('action', '/store/buy.yh');
  buyForm.attr('method', 'post');

  let buyInput = $('<input />');
  buyInput.attr('type', 'hidden');
  buyInput.attr('name', name);
  buyInput.attr('value', value);

  buyInput.appendTo(buyForm);
  buyForm.appendTo('body');
  buyForm.submit();
}

let IMP = window.IMP;
IMP.init('imp53374831');

/**
 * 일반 결제
 * @param {*} payMethod
 * @param {*} productName
 * @param {*} totalAmount
 * @param {*} memberName
 * @param {*} memberPhone
 */
function requestKgpay(payMethod, productName, totalAmount, memberName, memberPhone) {
  IMP.request_pay(
    {
      pg: 'inicis',
      pay_method: payMethod, // card(신용카드), trans(실시간계좌이체), vbank(가상계좌)
      merchant_uid: 'store_' + new Date().getTime(),
      name: productName,
      amount: totalAmount,
      buyer_name: memberName,
      buyer_tel: memberPhone,
      m_redirect_url: '/store/pay/complete.yh',
    },
    function (rsp) {
      if (rsp.success) {
        let msg = '결제가 완료되었습니다.';
        $(location).attr('href', '결제 후 url');

        $.ajax({
          url: '/store/pay.yh',
          method: 'POST',
          data: {
            imp_uid: rsp.imp_uid,
            merchant_uid: rsp.merchant_uid,
          },
        });
      } else {
        let msg = '결제가 실패하였습니다.';
        rsp.error_msg;
      }
    }
  );
}
