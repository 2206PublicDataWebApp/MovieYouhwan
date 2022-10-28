const registerBtn = $('#btn-store-register');
let modifyBtn = $('.btn-store-modify');
const registerModal = $('#modal-store-register');
const modifyModal = $('#modal-store-modify');
let cancelBtn = $('.modal-btn-cancel');

/** 상품 등록 모달창 띄우기 */
registerBtn.click(function () {
  registerModal.css('display', 'block');
});

/** 상품 수정 모달창 띄우기 */
modifyBtn.click(function () {
  modifyModal.css('display', 'block');
});

let productType = $('.modal-product-type');
let isNewType = $('input[type=hidden]');

/** 모달창 닫기 */
cancelBtn.click(function () {
  if (confirm('변경사항이 저장되지 않습니다. 정말 취소하시겠습니까?')) {
    if (registerModal.css('display') == 'block') {
      registerModal.css('display', 'none');
    } else if (modifyModal.css('display') == 'block') {
      modifyModal.css('display', 'none');
    }
    $('.modal-form').each(function () {
      this.reset();
    });
    isNewType.val('');
    initClass(productType, $('[class^=btn-to]'));
  }
});

function initClass(field, btn) {
  field.filter(':even').removeClass('hidden').attr('name', 'productType').prop('required', true);
  field.filter(':odd').addClass('hidden').removeAttr('name').prop('required', false);
  btn.filter(':odd').addClass('hidden');
  btn.filter(':even').removeClass('hidden');
}

/** 상품 등록 시 상품구분 select ~ input 변경 */
$('[class^=btn-to]').click(function () {
  productType.toggleClass('hidden');
  $('[class^=btn-to]').toggleClass('hidden');
  isNewType.toggleClass('hidden');

  productType.not('.hidden').attr('name', 'productType').prop('required', true);
  productType.filter('.hidden').removeAttr('name').prop('required', false);

  $('input.hidden').val('');
  isNewType.not('.hidden').val('Y');
});

/** 상품 재배치 페이지로 이동 */
$('#btn-store-reorder').click(function () {
  $(location).attr('href', '/admin/store/reorderView.yh');
});

// 드래그 앤 드롭으로 순서 재배치를 위한 메소드
$('.sortable').sortable({});

/** 상품 재배치 취소 (Alert) */
$('#btn-store-cancel').click(function () {
  if (confirm('변경사항이 저장되지 않습니다. 정말 취소하시겠습니까?')) {
    $(location).attr('href', '/admin/store/manage.yh');
  }
});

/** 상품 삭제 (Alert) */
$('.btn-store-delete').click(function () {
  if (confirm('정말 삭제하시겠습니까?')) {
    $(location).attr('replace', '/admin/store/delete.yh');
  }
});
