//////////////////////////////////////////////////////
///////////////// Auto Call Function /////////////////
//////////////////////////////////////////////////////

formatDate($('.movie-chart-item .movie-opening-date'));
showCommas($('.store-best-item .product-price'));

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
    $(this).text($(this).text().substr(0, 10) + ' 개봉');
  });
}
