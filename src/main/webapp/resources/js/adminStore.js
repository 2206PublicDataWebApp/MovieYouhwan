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

let productTypeField = $('.modal-product-type');
let productTypeBtn = $('button[class^=btn-to]');
let imgPreview = $('.img-preview');
let imgIcon = $('#img-icon');
// let isNewType = $('input[type=hidden]'); // TODO: Delete this later

/** 모달창 닫기 */
cancelBtn.click(function () {
  if (confirm('입력 사항은 저장되지 않습니다. 정말 취소하시겠습니까?')) {
    if (registerModal.css('display') == 'block') {
      registerModal.css('display', 'none');
    } else if (modifyModal.css('display') == 'block') {
      modifyModal.css('display', 'none');
    }
    initModal(productTypeField, productTypeBtn);
    // isNewType.val(''); // TODO: Delete this later
  }
});

/** 클래스 변경 초기화 */
function initModal(field, btn) {
  $('.modal-form').each(function () {
    this.reset();
  });
  field.filter(':even').removeClass('hidden').attr('name', 'productType').prop('required', true);
  field.filter(':odd').addClass('hidden').removeAttr('name').prop('required', false);
  btn.filter(':odd').addClass('hidden');
  btn.filter(':even').removeClass('hidden');
  imgPreview.attr('src', '');
  imgIcon.removeClass('hidden');
}

/** 상품 사진 미리보기 */
$('#product-img-register').change(function () {
  if ($(this)[0].files && $(this)[0].files[0]) {
    let reader = new FileReader();
    reader.onload = function (e) {
      imgPreview.attr('src', e.target.result);
    };
    reader.readAsDataURL($(this)[0].files[0]);
    imgIcon.addClass('hidden');
  } else {
    imgPreview.attr('src', '');
  }
});

/** 상품 등록 시 상품구분 select ~ input 변경 */
productTypeBtn.click(function () {
  productTypeField.toggleClass('hidden');
  productTypeBtn.toggleClass('hidden');
  // isNewType.toggleClass('hidden'); // TODO: Delete this later

  productTypeField.not('.hidden').attr('name', 'productType').prop('required', true);
  productTypeField.filter('.hidden').removeAttr('name').prop('required', false);

  $('input.hidden').val('');
  // isNewType.not('.hidden').val('Y'); // TODO: Delete this later
});

/** 상품 재배치 페이지로 이동 */
$('#btn-store-reorder').click(function () {
  $(location).attr('href', '/admin/store/reorderView.yh');
});

// 드래그 앤 드롭으로 순서 재배치를 위한 메소드
$('.sortable').sortable({});

/** 상품 재배치 취소 (Alert) */
$('#btn-store-cancel').click(function () {
  if (confirm('변경 사항은 저장되지 않습니다. 정말 취소하시겠습니까?')) {
    $(location).attr('href', '/admin/store/manage.yh');
  }
});

/** 상품 삭제 (Alert) */
$('.btn-store-delete').click(function () {
  if (confirm('정말 삭제하시겠습니까?')) {
    $(location).attr('replace', '/admin/store/delete.yh');
  }
});
