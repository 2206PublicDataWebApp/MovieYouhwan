// 상품 삭제
$('.btn-store-delete').click(function () {
  if (confirm('정말 삭제하시겠습니까?')) {
    $(location).attr('replace', '/admin/store/delete.yh');
  }
});
