if ($('#isMatchingActive').val() == 'Y') {
  $('.match-toggle-switch').toggleClass('active');
}
$('.mate-tab').addClass('tab-selected');
let matchingCount = $('.matching-count').val();
console.log(matchingCount);
$('.mate-count').css('width', (matchingCount / 50) * 100 + '%');

$('.match-toggle-switch').click(function () {
  $(this).toggleClass('active');
  if ($(this).hasClass('active')) {
    $('#isMatchingActive').val('Y');
  } else {
    $('#isMatchingActive').val('N');
  }
  $.ajax({
    url: '/mate/modifyMatchingActive.yh',
    data: {
      matchingActive: $('#isMatchingActive').val(),
      memberId: $('#mate-memberId').val(),
    },
    method: 'POST',
    success: function (msg) {
      console.log(msg);
    },
  });
});

$('.matching-date').each(function () {
  $(this).text($(this).text().substr(0, 10));
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

function chatting(requesterId, respondentId, respondentNickname) {
  console.log('chatting');
  $.ajax({
    url: '/mate/matchingComplete.yh',
    data: {
      requesterId: requesterId,
      respondentId: respondentId,
    },
    type: 'POST',
    success: function (result) {
      if (result == '0') {
        alert('이미 메이트인 회원입니다.');
      } else if (result == 'loginError') {
        alert('로그인이 필요한 서비스입니다.');
        $(location).attr('href', '/member/loginView.yh');
      } else if (result == 'insertError') {
        alert('메이트 매칭 실패');
      } else {
        alert(respondentNickname + '님과 메이트가 되었습니다.');
      }
    },
    error: function (result) {
      alert('매칭 전송 실패');
    },
  });
}

function deleteMatching(memberId) {
  console.log(memberId);
  if (confirm('메이트를 삭제하시겠습니까?')) {
    let formTag = $('<form></form>').attr('action', '/mate/deleteMatching.yh').attr('method', 'post');
    let inputTag = $('<input/>').attr('type', 'hidden').attr('name', 'mateId').attr('value', memberId);
    formTag.append(inputTag);
    $('body').append(formTag);
    $(formTag).submit();
  }
}
