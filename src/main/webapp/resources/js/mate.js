$('.match-toggle-switch').click(function () {
  $(this).toggleClass('active');
});

/* 메이트 약관동의 -> 시작하기 버튼 */
function mateStart(id) {
  let mateCheckBox = $('.agree-checkbox');
  let checkedMateCheckBox = $('[class=agree-checkbox]:checked');
  if (mateCheckBox.length == checkedMateCheckBox.length) {
    let formTag = $('<form></form>');
    formTag.attr('action', '/mate/modifyMstatusY.yh').attr('method', 'post');
    let inputTag = $('<input/>');
    inputTag.attr('value', id).attr('type', 'hidden').attr('name', 'memberId');
    formTag.append(inputTag);
    $('body').append(formTag);
    formTag.submit();
  } else {
    alert('모든 약관에 동의해야 합니다.');
  }
}

$('.slide-icon-area').click(function () {
  let target = $('#agreement-area').offset().top;
  $('html, body').animate({ scrollTop: target }, 500);
});
