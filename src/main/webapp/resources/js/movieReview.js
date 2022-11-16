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
