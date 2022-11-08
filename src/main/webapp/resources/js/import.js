IMP.init('imp53374831');

function requestStorePay() {
  IMP.request_pay({
    pg: 'inicis',
    pay_method: 'card',
    merchant_uid: 'merchant_' + new Date().getTime(),
    // name: name,
    // amount: amount,
    // buyer_name: buyer_name,
    // buyer_tel: buyer_tel,
    // buyer_addr: buyer_addr,
    // buyer_postcode: buyer_postcode,
  });
}
