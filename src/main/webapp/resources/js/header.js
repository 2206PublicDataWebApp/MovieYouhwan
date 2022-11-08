const toggleBtn = $('.navbar-toggleBtn');
const bars = $('#bars');
const xmark = $('#xmark');
const menuItem = $('.navbar-menuItem');
const links = $('#navbar-links');

toggleBtn.click(function () {
  bars.toggleClass('show');
  xmark.toggleClass('show');
  menuItem.toggleClass('active');
});

function confirmLogout() {
  if (confirm('정말 로그아웃 하시겠습니까?')) {
    location.href = '/member/logout.yh';
  }
}

$('#mate-tab').click(function (e) {
  if (!$('#profile-user').length) {
    alert('로그인이 필요한 서비스입니다.');
    $(this).attr('href', '/member/loginView.yh');
  }
});
