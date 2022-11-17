$('.review-star').on('click', function () {
  console.log('star click');
  var idx = $(this).index();
  $('.review-star').removeClass('on');
  for (var i = 0; i <= idx; i++) {
    $('.review-star').eq(i).addClass('on');
  }
  $('.selected-rate').html(idx + 1);
});

$('.review-create-date').each(function () {
  $(this).text($(this).text().substr(0, 10));
});

$('.review-rate').each(function () {
  let rate = $(this).data('value');
  for (let i = 0; i < rate; i++) {
    $(this).children().eq(i).addClass('on');
  }
});

let modalRate = $('.modal-review-rate').data('value');
console.log(modalRate);
for (let j = 0; j < modalRate; j++) {
  console.log($('.modal-review-rate').children().eq(j));
  $('.modal-review-rate').children().eq(j).addClass('on');
}

$('.modal-selected-star').on('click', function () {
  console.log('star click');
  var idx = $(this).index();
  $('.modal-selected-star').removeClass('on');
  for (var i = 0; i <= idx; i++) {
    $('.modal-selected-star').eq(i).addClass('on');
  }
  $('.modal-selected-rate').html(idx + 1);
});

$('#review-modify-btn').click(function () {
  console.log('modal click');
  lockScroll();
  $('#modal-review-modify').css('display', 'block');
});

$('.close-modal-btn').click(function () {
  unlockScroll();
  $('#modal-review-modify').css('display', 'none');
});

/**
 * 스크롤 잠금
 */
function lockScroll() {
  $('html, body').scrollTop(0, 0);
  $('html, body').css({ overflow: 'hidden', height: '100%' });
  $('html, body').on('scroll touchmove mousewheel', function (e) {
    e.preventDefault();
    e.stopPropagation();
  });
}

/**
 * 스크롤 잠금 해제
 */
function unlockScroll() {
  $('html, body').css({ overflow: 'visible', height: 'auto' });
  $('html, body').off('scroll touchmove mousewheel');
}
function registerMovieReview(loginUser) {
  if (!loginUser) {
    alert('로그인이 필요한 서비스입니다.');
    return;
  }
  if ($('.selected-rate').text() == '0') {
    alert('별점을 선택해주세요.');
  } else {
    $.ajax({
      url: '/movieReview.register.yh',
      method: 'post',
      data: {
        movieRate: $('.selected-rate').text(),
        movieNo: $('#movieNoInput').val(),
        movieReview: $('#review-input').val(),
      },
      success: function (result) {
        if (result == 'fail') {
          alert('이미 리뷰를 등록한 영화입니다.');
        } else if (result == 'success') {
          alert('리뷰가 등록되었습니다.');
          $(location).attr('href', '/movieReview.yh?movieNo=' + $('#movieNoInput').val());
        } else if (result == 'loginRequired') {
          alert('로그인이 필요한 서비스입니다.');
          $(location).attr('href', '/member/loginView.yh');
        }
      },
    });
  }
}

function deleteReview() {
  if (confirm('리뷰를 삭제하시겠습니까?')) {
    let formTag = $('<form></form>').attr('action', '/movieReview/delete.yh').attr('method', 'post');
    let inputTag = $('<input/>').attr('type', 'hidden').attr('name', 'movieNo').attr('value', $('#movieNNoInput'));
    formTag.append(inputTag);
    $('body').append(formTag);
    formTag.submit();
  }
}

function modifyReview() {
  let formTag = $('<form></form>').attr('action', '/movieReview/modify.yh').attr('method', 'post');
  let inputTag1 = $('<input/>').attr('type', 'hidden').attr('name', 'movieNo').attr('value', $('#modifyReviewNo').val());
  let inputTag2 = $('<input/>').attr('type', 'hidden').attr('name', 'movieRate').attr('value', $('.modal-selected-rate').text());
  let inputTag3 = $('<input/>').attr('type', 'hidden').attr('name', 'movieReview').attr('value', $('.modal-textarea').val());
  console.log($('.modal-textarea').val());

  formTag.append(inputTag1);
  formTag.append(inputTag2);
  formTag.append(inputTag3);
  $('body').append(formTag);
  formTag.submit();
}
