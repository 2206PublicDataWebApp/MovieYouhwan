$(window).scroll(function () {
  console.log('ddd');
  $('.fade-in-bottom').each(function (i) {
    console.log('dgasdgad');
    var bottom_of_element = $(this).offset().top + $(this).outerHeight();
    var bottom_of_window = $(window).scrollTop() + $(window).height();

    if (bottom_of_window > bottom_of_element) {
      console.log('gggggggggggggggggg');
      $(this).animate({ opacity: '0.8', top: '-300px' }, 800);
    }
  });
});

$('.match-toggle-switch').click(function () {
  $(this).toggleClass('active');
});
