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
  if (checkBoxCount === checkedCount) {
    $('#check-all-product').prop('checked', true);
  } else {
    $('#check-all-product').prop('checked', false);
  }
});

// 장바구니 - 상품 구매 전 체크
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

// 장바구니 - 변경 버튼 클릭 시 상품 수량 변경
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

// 상품 구매 - 이전 단계로 이동
$('#btn-buy-prev').click(function () {
  history.back();
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

// FIXME: 총 상품 금액 부분도 변경
/**
 * 장바구니 상품 수량 변경
 * @param {*} btn
 */
function changeProductCountInCart(btn) {
  let cartNo = btn.parent().prev().prev().prev().prev().children('input[type=checkbox]').val();
  let productCount = btn.siblings('input[type=number]').val();
  let productPrice = btn.parent().prev();
  let productPricePerCount = btn.parent().next();
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

IMP.init('imp53374831');

// 상품 구매 - 결제하기
$('#btn-buy-pay').click(function () {
  if ($('#profile-user').length) {
    let payMethod = $('.pay-method').filter(':checked').val();
    if (payMethod) {
      let pg = payMethod === 'kakaopay' ? 'kakaopay' : 'html5_inicis';
      let productName;
      if ($('.product-name').length > 1) {
        productName = $('.product-name').eq(0).text() + ' 외 ' + ($('.product-name').length - 1);
      } else {
        productName = $('.product-name').text();
      }
      let totalAmount = strToNum($('#total-pay-amount').text());

      // FIXME: Use AJAX to get memberName, memberPhone, memberEmail from session.loginUser
      let memberName = '최현지'; // FIXME:
      let memberPhone = '010-1111-2222'; // FIXME:
      let memberEmail = 'i0hyeon@naver.com'; // FIXME:
      requestPay(pg, payMethod, productName, totalAmount, memberName, memberPhone, memberEmail);
    } else {
      alert('결제수단을 선택해주세요.');
    }
  } else {
    $(location).attr('href', '/member/loginView.yh');
  }
});

/**
 * 일반 결제, 카카오페이 결제
 * @param {*} payMethod
 * @param {*} productName
 * @param {*} totalAmount
 * @param {*} memberName
 * @param {*} memberPhone
 */
function requestPay(pg, payMethod, productName, totalAmount, memberName, memberPhone, memberEmail) {
  IMP.request_pay(
    {
      pg: pg,
      pay_method: payMethod, // card(신용카드), trans(실시간계좌이체), vbank(가상계좌)
      merchant_uid: 'store_' + new Date().getTime(),
      name: productName,
      amount: totalAmount,
      buyer_name: memberName,
      buyer_tel: memberPhone,
      buyer_email: memberEmail,
    },
    function (rsp) {
      // 결제 성공 시
      if (rsp.success) {
        // 결제 검증
        $.ajax({
          url: '/pay/verify.yh',
          method: 'POST',
          data: {
            imp_uid: rsp.imp_uid,
            merchant_uid: rsp.merchant_uid,
          },
          // TODO: Find out what they are
          // beforeSend: function (xhr) {
          //   xhr.setRequestHeader(header, token);
          // },
        })
          .done(function (result) {
            if (rsp.paid_amount === result.response.amount) {
              alert('결제가 완료되었습니다.');
              // 결제내역 추가
              $.ajax({
                url: '/store/pay.yh',
                method: 'POST',
                data: {
                  productName: result.response.name,
                  totalAmount: result.response.amount,
                  payDate: paid_at,
                  imp_uid: rsp.imp_uid,
                },
                // TODO: Find out what they are
                // beforeSend: function (xhr) {
                //   xhr.setRequestHeader(header, token);
                // },
              })
                .done(function () {
                  $(location).attr('href', '/store/pay/complete.yh');
                })
                .fail(function (error) {
                  alert(JSON.stringify(error));
                });
            } else {
              alert('[결제내역 저장 실패] ' + rsp.error_msg);
            }
          })
          .fail(function (error) {
            alert(JSON.stringify(error));
            alert('[결제 이상]' + rsp.error_msg);
          });
      } else {
        alert('[결제 실패] ' + rsp.error_msg);
        $(location).attr('href', '/store.yh');
      }
    }
  );
}
