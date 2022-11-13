// 상품 결제 - 아임포트 가맹점 번호
const IMP_ID = 'imp53374831';

IMP.init(IMP_ID);

// 상품 구매 - 결제하기
$('#btn-buy-pay').click(function () {
  if ($('#profile-user').length) {
    const payMethod = $('.pay-method').filter(':checked').val();
    if (payMethod) {
      const pg = payMethod === 'kakaopay' ? 'kakaopay' : 'html5_inicis';
      const productNameTag = $('.product-name');
      let productName;
      let productNameList = [];
      let productCountList = [];
      if (productNameTag.length > 1) {
        productName = productNameTag.eq(0).text() + ' 외 ' + (productNameTag.length - 1);
        productNameTag.each(function () {
          productNameList.push($(this).text());
          productCountList.push(strToNum($(this).siblings('.product-count').text()));
        });
      } else {
        productName = productNameTag.text();
        productNameList.push(productName);
        productCountList.push(strToNum($('.product-count').text()));
      }
      console.log('productNameList: ' + productNameList + '\nproductCountList: ' + productCountList);
      const totalAmount = strToNum($('#total-pay-amount').text());
      // NOTE: 주문자 정보(이름, 휴대폰 번호, 이메일) 가져오기
      $.ajax({
        url: '/store/pay/buyer.yh',
        type: 'POST',
        success: function (memberInfo) {
          requestPay(pg, payMethod, productName, productNameList, productCountList, totalAmount, memberInfo);
        },
        error: function (error) {
          alert(JSON.stringify(error));
        },
      });
    } else {
      alert('결제수단을 선택해주세요.');
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
 * 상품 결제 (일반 결제, 카카오페이 결제)
 * @param {*} payMethod
 * @param {*} productName
 * @param {*} totalAmount
 * @param {*} memberName
 * @param {*} memberPhone
 */
function requestPay(pg, payMethod, productName, productNameList, productCountList, totalAmount, memberInfo) {
  IMP.request_pay(
    {
      pg: pg,
      pay_method: payMethod, // card(신용카드), trans(실시간계좌이체), vbank(가상계좌)
      merchant_uid: 'store_' + new Date().getTime(),
      name: productName,
      amount: totalAmount,
      buyer_name: memberInfo.memberName,
      buyer_tel: memberInfo.memberPhone,
      buyer_email: memberInfo.memberEmail,
    },
    function (rsp) {
      // 결제 승인 또는 가상계좌 발급 성공
      if (rsp.success) {
        // NOTE: Must verify the payment
        $.ajax({
          url: '/pay/verify.yh',
          method: 'POST',
          data: {
            imp_uid: rsp.imp_uid, // 아임포트 고유 결제번호
          },
        })
          // 결제 검증 성공
          .done(function (result) {
            // 결제 금액 비교
            if (rsp.paid_amount === result.response.amount) {
              alert('[결제완료] 결제 완료 페이지로 이동합니다.');
              // NOTE: Insert the payment verified to DB
              $.ajax({
                url: '/store/pay.yh',
                method: 'POST',
                // headers: { 'Content-Type': 'application/json' },
                data: {
                  // imp_uid: rsp.imp_uid, // 아임포트 고유 결제번호
                  orderNo: rsp.merchant_uid, // 가맹점에서 생성/관리하는 고유 주문번호
                  productName: rsp.name, // 주문명
                  payAmount: rsp.paid_amount, // 결제 승인 또는 가상계좌 입금예정 금액
                  paid_at: rsp.paid_at, // 결제승인시각
                  productNameList: productNameList, // 실제 주문한 상품명 리스트
                  productCountList: productCountList, // 실제 주문한 상품수량 리스트
                  status: rsp.status, // 결제상태 (ready, paid->사용가능(A), failed)
                },
                // TODO: Find out what they are
                // beforeSend: function (xhr) {
                //   xhr.setRequestHeader(header, token);
                // },
              })
                // 결제 데이터 삽입 성공
                .done(function (msg) {
                  // NOTE: 결제 완료 페이지로 이동
                  $.ajax({
                    url: '/store/pay/complete.yh',
                    method: 'POST',
                    data: {
                      // FIXME: 결제 완료 페이지로 전송할 데이터 수정
                      productName: result.response.name,
                      payAmount: result.response.amount,
                      payDate: rsp.paid_at,
                      // NOTE: 여기까지 옴
                    },
                  })
                    .done(function () {
                      $(location).attr('href', '/store/pay/complete.yh');
                    })
                    .fail(function (error) {
                      alert(JSON.stringify(error)); // NOTE: Wondering what error msg will come out
                      alert('[페이지 이동 실패] 결제 완료 페이지로 이동할 수 없습니다.');
                    });
                })
                .fail(function (error) {
                  alert(JSON.stringify(error));
                });
            } else {
              alert('[결제이상] 결제 금액이 일치하지 않습니다.');
              // TODO: 결제 취소 처리
            }
          });
      } else {
        alert('[결제실패] ' + rsp.error_msg);
        $(location).attr('href', '/store.yh');
      }
    }
  );
}
