const toggleBtn = $('.navbar-toggleBtn');
const bars = $('#bars');
const xmark = $('#xmark');
const menuList = $('.navbar-menuList');
const links = $('#navbar-links');

toggleBtn.click(function () {
  bars.toggleClass('show');
  xmark.toggleClass('show');
  menuList.toggleClass('active');
});
