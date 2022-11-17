// 구매내역 - 가격에 천 단위로 콤마(,) 삽입
showCommas($('.order-price'));

// 구매내역, 구매내역 상세 - 결제일자 포맷
formatDate($('.order-pay-date'));

// 구매내역 - 주문상태별 색상 변경
setColorByStatus($('.order-availability'));

//////////////////////////////////////////////////////
/////////////////// Event Listener ///////////////////
//////////////////////////////////////////////////////

// 구매내역 - 기간 조회 필터 버튼 클릭 시 색상 변경 및 날짜 조회 필터 값 초기화
$('.btn-search-by-period').click(function () {
  $(this).removeClass('filter-not-clicked');
  $(this).addClass('filter-clicked');
  $(this).siblings().removeClass('filter-clicked');
  $(this).siblings().addClass('filter-not-clicked');
  $('#search-by-date').find('input[type=date]').val('');
});

// 구매내역 - 날짜 조회 필터 값 변경 시 기간 조회 버튼 초기화
$('#search-by-date')
  .find('input[type=date]')
  .change(function () {
    $('.btn-search-by-period').each(function () {
      $(this).addClass('filter-not-clicked');
      $(this).removeClass('filter-clicked');
    });
  });

// 구매내역 - 기간 조회 필터로 검색
$('#btn-search-by-filter').click(function () {
  const optionVal = $('#select-search-by-option').val();
  const periodVal = $('.btn-search-by-period.filter-clicked').text();
  const startDateVal = $('#start-date').val();
  const endDateVal = $('#end-date').val();

  if (startDateVal.length && !endDateVal.length) {
    alert('시작 날짜를 선택해주세요.');
    return;
  } else if (!startDateVal.length && endDateVal.length) {
    alert('종료 날짜를 선택해주세요.');
    return;
  }

  // NOTE: VC
  console.log(optionVal);
  console.log(periodVal);
  console.log(startDateVal);
  console.log(endDateVal);

  let searchForm = $('<form></form>');
  searchForm.attr('action', '/mypage/store/history.yh');
  searchForm.attr('method', 'get');

  let option = $('<input />');
  option.attr('type', 'hidden');
  option.attr('name', 'option');
  option.attr('value', optionVal);
  option.appendTo(searchForm);

  if (periodVal.length) {
    let period = $('<input />');
    period.attr('type', 'hidden');
    period.attr('name', 'period');
    period.attr('value', periodVal);
    period.appendTo(searchForm);
  }

  if (startDateVal.length && endDateVal.length) {
    let startDate = $('<input />');
    startDate.attr('type', 'hidden');
    startDate.attr('name', 'startDate');
    startDate.attr('value', startDateVal);
    startDate.appendTo(searchForm);

    let endDate = $('<input />');
    endDate.attr('type', 'hidden');
    endDate.attr('name', 'endDate');
    endDate.attr('value', endDateVal);
    endDate.appendTo(searchForm);
  }

  searchForm.appendTo('body');
  searchForm.submit();
});

// TODO: 결제 취소 구현
// 구매내역 - 주문 취소
$('#btn-order-cancel').click(function () {
  if ($('#profile-user').length) {
    if (confirm('정말 취소하시겠습니까?')) {
      // let cancelForm = $('<form></form>');
      // cancelForm.attr('action', '/store/order/cancel.yh');
      // cancelForm.attr('method', 'post');

      // let cancelInput = $('<input />');
      // cancelInput.attr('type', 'hidden');
      // cancelInput.attr('name', 'orderNo');
      // cancelInput.attr('value', $(this).data('value'));

      // cancelInput.appendTo(cancelForm);
      // cancelForm.appendTo('body');
      // cancelForm.submit();
      alert('취소 기능은 현재 구현 중입니다.');
    }
  } else {
    $(location).attr('href', '/member/loginView.yh');
  }
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
 * 날짜 포맷 (yyyy-MM-dd)
 * @param {*} dateElem
 */
function formatDate(dateElem) {
  dateElem.each(function () {
    $(this).text($(this).text().substr(0, 10));
  });
}

/**
 * 주문상태별 글자 색상 변경 (green, yellow, red)
 * @param {*} statusElem
 */
function setColorByStatus(statusElem) {
  statusElem.each(function () {
    switch ($(this).text()) {
      case '사용가능':
        $(this).css('color', 'green');
        break;
      case '기간만료':
        $(this).css('color', '#59500');
        break;
      case '취소완료':
        $(this).css('color', 'red');
        break;
      default:
    }
  });
}
