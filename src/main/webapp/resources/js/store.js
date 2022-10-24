const registerBtn = $('#btn-store-register');
const modifyBtn = $('.btn-store-modify');
const registerModal = $('#modal-store-register');
const modifyModal = $('#modal-store-modify');
const cancelBtn = $('.modal-btn-cancel');

// 상품 등록 (모달)
registerBtn.click(function () {
  registerModal.css('display', 'block');
});

// 상품 수정 (모달)
modifyBtn.click(function () {
  modifyModal.css('display', 'block');
});

// 모달창 닫기
cancelBtn.click(function () {
  if (registerModal.css('display') == 'block') {
    registerModal.css('display', 'none');
  } else if (modifyModal.css('display') == 'block') {
    modifyModal.css('display', 'none');
  }
});

// 상품 재배치
$('#btn-store-reorder').click(function () {
  $(location).attr('href', '/admin/store/reorderView.yh');
});
$('.sortable').sortable({});
$('#btn-store-cancel').click(function () {
  if (confirm('변경사항이 저장되지 않습니다. 정말 취소하시겠습니까?')) {
    $(location).attr('href', '/admin/store/manage.yh');
  }
});

// 상품 삭제
$('.btn-store-delete').click(function () {
  if (confirm('정말 삭제하시겠습니까?')) {
    $(location).attr('replace', '/admin/store/delete.yh');
  }
});
