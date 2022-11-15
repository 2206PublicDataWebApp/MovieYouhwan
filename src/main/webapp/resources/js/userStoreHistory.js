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
