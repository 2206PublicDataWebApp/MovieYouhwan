//////////////////////////////////////////////////////
////////////////////// Variable //////////////////////
//////////////////////////////////////////////////////

//////////////////////////////////////////////////////
///////////////// Auto Call Function /////////////////
//////////////////////////////////////////////////////

// 헤더 - 탭 메뉴 스타일
$('.store-tab').addClass('tab-selected');

// 상품 목록 - 가격에 천 단위로 콤마(,) 삽입
showCommas($('p.product-price'));

// 상품 상세 - 가격에 천 단위로 콤마(,) 삽입
showCommas($('.detail-price'));

// 장바구니, 상품 구매 - 총 상품 금액 및 총 결제 예정 금액 계산
showTotalAmount();

// 장바구니 - 가격에 천 단위로 콤마(,) 삽입
showCommas($('.cart-price'));

// 상품 구매 - 가격에 천 단위로 콤마(,) 삽입
showCommas($('.buy-price'));

// 결제 완료 - 가격에 천 단위로 콤마(,) 삽입
showCommas($('.complete-price'));

//////////////////////////////////////////////////////
/////////////////// Event Listener ///////////////////
//////////////////////////////////////////////////////

// 상품 목록 - 탭 메뉴로 스크롤 이동
$('.store-tab-item').click(function () {
  let type = $(this).data('value');
  let target = $('div#' + type).offset().top - 50;
  console.log(target);
  $('html, body').animate({ scrollTop: target }, 200);
});

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

// 상품 목록 - 장바구니에 상품 담기
$('.btn-store-list.btn-add-cart').click(function (e) {
  if ($('#profile-user').length) {
    const productNo = $(this).parent().parent().attr('id');
    const productName = $(this).parent().siblings('.product-detail').children('.product-name').text();
    const productTypeNo = strToNum($(this).parent().parent().parent().siblings('.product-type').attr('id'));
    const productType = $(this).parent().parent().parent().siblings('.product-type').text();
    const productPrice = strToNum($(this).parent().siblings('.product-detail').children('.product-price').text());
    const productCount = 1;
    const productImgRename = $(this).parent().siblings('a').children('img').attr('id');

    addProductToCart(productNo, productName, productTypeNo, productType, productPrice, productCount, productImgRename);
  } else {
    if (confirm('로그인이 필요한 서비스입니다.\n로그인 화면으로 이동하시겠습니까?')) {
      $(location).attr('href', '/member/loginView.yh');
    }
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

// 상품 상세 - 장바구니에 상품 담기
$('#btn-detail-cart').click(function () {
  if ($('#profile-user').length) {
    const productNo = $('#product-no').val();
    const productName = $('#product-name').text();
    const productTypeNo = $('#product-type-no').val();
    const productType = $('#product-type').val();
    const productPrice = strToNum($('.detail-price').eq(0).text());
    const productCount = $('#detail-product-count').val();
    const productImgRename = $('.detail-product-img').attr('id');

    addProductToCart(productNo, productName, productTypeNo, productType, productPrice, productCount, productImgRename);
  } else {
    if (confirm('로그인이 필요한 서비스입니다.\n로그인 화면으로 이동하시겠습니까?')) {
      $(location).attr('href', '/member/loginView.yh');
    }
  }
});

// 상품 상세 - 상품 수량 변경 시 총 상품 금액 변경
$('#detail-product-count').bind('keyup mouseup', function () {
  const productPricePerCount = $(this).val() * strToNum($('.detail-price').eq(0).text());
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
  const checkBox = $('.check-one-product');
  const checkBoxCount = checkBox.length;
  let checkedCount = 0;
  checkBox.each(function (idx, element) {
    if (checkBox.eq(idx).is(':checked')) {
      checkedCount++;
    }
  });
  if (checkBoxCount === checkedCount) {
    $('#check-all-product').prop('checked', true);
  } else {
    $('#check-all-product').prop('checked', false);
  }
});

// 장바구니 - 상품 구매 시 상품 선택 여부 및 선택 상품 상태 체크
$('#btn-cart-buy').click(function (e) {
  if ($('#profile-user').length) {
    if ($('.cart-no:checked').length) {
      $('.cart-no:checked').each(function () {
        if ($(this).is(':disabled')) {
          let disabledProduct = $(this).parent().next().next().text();
          alert(disabledProduct + '는 구매 불가능한 상품입니다.\n장바구니에서 삭제한 후 다시 시도해주세요.');
          e.preventDefault();
        }
        let changeBtn = $(this).parent().next().next().next().next().children('button');
        changeProductCountInCart(changeBtn);
      });
    } else {
      alert('구매할 상품을 선택해주세요.');
      e.preventDefault();
    }
  } else {
    e.preventDefault();
    $(location).attr('href', '/member/loginView.yh');
  }
});

// 장바구니 - 상품 수량 변경
$('.btn-change-count').click(function () {
  if ($('#profile-user').length) {
    changeProductCountInCart($(this));
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
          if (url === '') {
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

// 결제완료 - 결제내역 페이지로 이동
$('#btn-to-history').click(function () {
  $(location).attr('href', '/mypage/store/history.yh');
});

///////////////////////////////////////////////////////
////////////////////// Function ///////////////////////
///////////////////////////////////////////////////////

/**
 * 상품 가격에 천 단위로 콤마(,) 삽입
 * @param {*} numberStr
 */
function showCommas(numElem) {
  numElem.each(function () {
    const price = strToNum($(this).text());
    $(this).text(price.toLocaleString() + '원');
  });
}

/**
 * 상품 가격에서 콤마(,) 제거 후 숫자형 반환
 * @param {*} str
 * @returns
 */
function strToNum(strVal) {
  return parseInt(strVal.replace(/[^0-9]/g, ''));
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
      if (url === '') {
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
 * 장바구니 상품 수량 변경
 * @param {*} btn
 */
function changeProductCountInCart(btn) {
  const cartNo = btn.parent().prev().prev().prev().prev().children('input[type=checkbox]').val();
  const productCount = btn.siblings('input[type=number]').val();
  const productPrice = btn.parent().prev();
  const productPricePerCount = btn.parent().next();
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
        showTotalAmount();
        showCommas($('.cart-price'));
      }
    },
    error: function () {
      alert('문제가 발생했습니다. 다시 시도해주세요.');
      location.reload();
    },
  });
}

/**
 * 총 상품 금액 및 총 결제 예정 금액 계산
 */
function showTotalAmount() {
  let totalCartAmount = 0;
  let totalPayAmount = 0;
  const discountAmount = strToNum($('#discount-amount').text());
  $('.product-price-per-count').each(function () {
    totalCartAmount += strToNum($(this).text());
  });
  totalPayAmount = totalCartAmount - discountAmount;
  $('#total-cart-amount').text(totalCartAmount);
  $('#total-pay-amount').text(totalPayAmount);
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
