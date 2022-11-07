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
    alert('로그아웃되었습니다');
    location.href = '/member/logout.yh';
  }
}
