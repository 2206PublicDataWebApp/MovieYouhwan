// 페이지가 로드될 때 탭 메뉴 선택
init();
function init() {
  let idx = $('#tabIndex').val();
  console.log(idx);
  $('.page').eq(idx).removeClass('no-show');
  $('.page').eq(idx).siblings('.page').addClass('no-show');
  $('.homepage-tab-item>a').eq(idx).addClass('homepage-tab-border');
  $('.homepage-tab-item>a').eq(idx).parent().siblings().children().removeClass('homepage-tab-border');
}

// faq 답변 아코디언
$('.answer-title').click(function () {
  let answer = $(this).parent().parent().next('.faq-board-answer');
  answer.toggleClass('no-show');
  answer.siblings('.faq-board-answer').addClass('no-show');
});

// notice 전체 선택
$('#notice-check-all').change(function () {
  if ($(this).is(':checked')) {
    $('.notice-check').prop('checked', true);
  } else {
    $('.notice-check').prop('checked', false);
  }
});

// faq 전체 선택
$('#faq-check-all').change(function () {
  if ($(this).is(':checked')) {
    $('.faq-check').prop('checked', true);
  } else {
    $('.faq-check').prop('checked', false);
  }
});

// 탭 메뉴 클릭 시 이벤트
$('.homepage-tab-item>a').click(function () {
  // 1. 탭메뉴 아래 선 border-bottom
  $(this).toggleClass('homepage-tab-border');
  $(this).parent().siblings().children().removeClass('homepage-tab-border');
  let idx = $(this).index('.homepage-tab-item>a');
  $('.page').eq(idx).removeClass('no-show');
  $('.page').eq(idx).siblings('.page').addClass('no-show');

  // 2. faq 열려있던 답변창 닫힘
  $('.faq-board-answer').addClass('no-show');

  // 3. 선택됐던 checkbox들 선택 해제
  $('input:checkbox').prop('checked', false);
});

// check box 개별로 모두 선택하면 전체 선택 checkbox도 선택되게 함
// check box 전체 선택 상태에서 하나 체크 해제하면 전체선택도 해제됨
$('.support-check').click(function () {
  if ($(this).hasClass('faq-check')) {
    let oneChkBx = $('.faq-check');
    let chkBxCount = oneChkBx.length;
    let chkedCount = 0;
    for (let i = 0; i < oneChkBx.length; i++) {
      if (oneChkBx.eq(i).is(':checked')) {
        chkedCount++;
      }
    }
    if (chkBxCount == chkedCount) {
      $('#faq-check-all').prop('checked', true);
    } else {
      $('#faq-check-all').prop('checked', false);
    }
  } else if ($(this).hasClass('notice-check')) {
    let oneChkBx = $('.notice-check');
    let chkBxCount = oneChkBx.length;
    let chkedCount = 0;
    for (let i = 0; i < oneChkBx.length; i++) {
      if (oneChkBx.eq(i).is(':checked')) {
        chkedCount++;
      }
    }
    if (chkBxCount == chkedCount) {
      $('#notice-check-all').prop('checked', true);
    } else {
      $('#notice-check-all').prop('checked', false);
    }
  } else if ($(this).hasClass('banner-check')) {
    let oneChkBx = $('.banner-check');
    let chkBxCount = oneChkBx.length;
    let chkedCount = 0;
    for (let i = 0; i < oneChkBx.length; i++) {
      if (oneChkBx.eq(i).is(':checked')) {
        chkedCount++;
      }
    }
    if (chkBxCount == chkedCount) {
      $('#banner-check-all').prop('checked', true);
    } else {
      $('#banner-check-all').prop('checked', false);
    }
  }
});
