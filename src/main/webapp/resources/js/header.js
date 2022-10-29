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
