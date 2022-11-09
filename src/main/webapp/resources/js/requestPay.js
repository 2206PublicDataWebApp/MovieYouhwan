let IMP = window.IMP;
IMP.init('imp53374831');

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
          url: '',
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

function requestKakaopay() {
  IMP.request_pay(
    {
      pg: 'kakaopay',
      pay_method: 'card',
      merchant_uid: 'merchant_' + new Date().getTime(),
      name: name,
      amount: amount,
      buyer_name: buyer_name,
      buyer_tel: buyer_tel,
      buyer_addr: buyer_addr,
      buyer_postcode: buyer_postcode,
      m_redirect_url: redirect_url,
    },
    function (rsp) {
      if (rsp.success) {
        let msg = '결제가 완료되었습니다.';
        $(location).attr('href', '결제 후 url');

        $.ajax({
          url: '',
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
