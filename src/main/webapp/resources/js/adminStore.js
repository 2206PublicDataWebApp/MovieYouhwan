// 상품 목록 - 상품 가격에 천 단위로 콤마(,) 삽입
showCommas($('p.product-price'));

const registerBtn = $('#btn-store-register');
let modifyBtn = $('.btn-store-modify');
const registerModal = $('#modal-store-register');
const modifyModal = $('#modal-store-modify');
let cancelBtn = $('.modal-btn-cancel');

// 상품 등록 - 모달창 출현
registerBtn.click(function () {
  registerModal.css('display', 'block');
});

// 상품 수정 - 모달창 출현
modifyBtn.click(function () {
  modifyModal.css('display', 'block');
  let productNo = $(this).parent().parent('.product-item').attr('id');
  let productImgSrc = $(this).parent().siblings('.product-img').attr('src');
  let productType = $(this).parent().parent().parent().siblings('.product-type').text();
  let productDetail = $(this).parent().siblings('.product-detail');
  let productName = productDetail.children('.product-name').text();
  let productPrice = parseInt(
    productDetail
      .children('.product-price')
      .text()
      .replace(/[^0-9]/g, '')
  );
  let productDesc = productDetail.children('.product-desc').text();

  modifyModal.find('input[name=productNo]').val(productNo);
  modifyModal.find('.img-preview').attr('src', productImgSrc);
  modifyModal.find('option').each(function () {
    if ($(this).text() === productType) {
      $(this).prop('selected', true);
    }
  });
  modifyModal.find('input[name=productName').val(productName);
  modifyModal.find('input[name=productPrice').val(productPrice);
  modifyModal.find('input[name=productDesc').val(productDesc);
});

let regProductTypeField = registerModal.find('.modal-product-type');
let regProductTypeBtn = registerModal.find('button[class^=btn-to]');
let regImgPreview = registerModal.find('.img-preview');
let regImgIcon = $('#img-icon');

let modProductTypeField = modifyModal.find('.modal-product-type');
let modProductTypeBtn = modifyModal.find('button[class^=btn-to]');
let modImgPreview = modifyModal.find('.img-preview');

// 상품 등록 - 상품 사진 미리보기
$('#product-img-register').change(function () {
  previewImg($(this));
});

// 상품 등록 - 상품 유형 입력창 전환
regProductTypeBtn.click(function () {
  toggleProductType(regProductTypeField, regProductTypeBtn);
});

// 상품 수정 - 상품 사진 미리보기
$('#product-img-modify').change(function () {
  previewImg($(this));
});

// 상품 수정 - 상품 유형 입력창 전환
modProductTypeBtn.click(function () {
  toggleProductType(modProductTypeField, modProductTypeBtn);
});

// 상품 등록, 수정 - 모달창 닫기
cancelBtn.click(function () {
  if (confirm('변경사항은 저장되지 않습니다. 정말 취소하시겠습니까?')) {
    if (registerModal.css('display') == 'block') {
      registerModal.css('display', 'none');
      initModal(regProductTypeField, regProductTypeBtn, regImgPreview);
    } else if (modifyModal.css('display') == 'block') {
      modifyModal.css('display', 'none');
      initModal(modProductTypeField, modProductTypeBtn, modImgPreview);
    }
  }
});

// 상품 재배치 - 페이지 이동
$('#btn-store-reorder').click(function () {
  $(location).attr('href', '/admin/store/reorder.yh');
});

// 상품 재배치 - 드래그앤드롭 순서 변경
$('.sortable').sortable({
  error: function (event, ui) {
    alert('순서 변경 중 에러가 발생하였습니다. 잠시 후 다시 시도해주세요.');
  },
});

// 상품 재배치 - 저장
$('#btn-store-save').click(function () {
  let productNoList = [];

  $('.product-item').each(function () {
    productNoList.push($(this).attr('id'));
  });

  $.ajax({
    url: '/admin/store/sort.yh',
    type: 'POST',
    data: {
      productNoList: productNoList,
    },
    success: function (data) {
      $(location).attr('href', '/admin/store/manage.yh');
    },
    error: function (data) {},
  });
});

// 상품 재배치 - 취소
$('#btn-store-cancel').click(function () {
  if (confirm('변경 사항은 저장되지 않습니다. 정말 취소하시겠습니까?')) {
    $(location).attr('href', '/admin/store/manage.yh');
  }
});

// 상품 삭제
$('.btn-store-delete').click(function (e) {
  e.preventDefault();
  if (confirm('정말 삭제하시겠습니까?')) {
    let deleteForm = $('<form></form>');
    deleteForm.attr('action', '/admin/store/delete.yh');
    deleteForm.attr('method', 'post');

    let deleteInput = $('<input />');
    deleteInput.attr('type', 'hidden');
    deleteInput.attr('name', 'productNo');
    deleteInput.attr('value', $(this).parent().parent('.product-item').attr('id'));

    deleteInput.appendTo(deleteForm);
    deleteForm.appendTo('body');
    deleteForm.submit();
  }
});

/**
 * 상품 가격에 천 단위로 콤마(,) 삽입
 * @param {*} numberStr
 */
function showCommas(numberStr) {
  numberStr.each(function () {
    let productPrice = Number($(this).text());
    $(this).text(productPrice.toLocaleString() + '원');
  });
}

/**
 * 사진 미리보기
 * @param {*} img
 */
function previewImg(img) {
  if (img[0].files && img[0].files[0]) {
    let reader = new FileReader();
    reader.onload = function (e) {
      img.parent().find('.img-preview').attr('src', e.target.result);
    };
    reader.readAsDataURL(img[0].files[0]);
    regImgIcon.addClass('hidden');
  }
}

/**
 * 상품 유형 입력창 전환
 * @param {*} field
 * @param {*} btn
 */
function toggleProductType(field, btn) {
  field.toggleClass('hidden');
  btn.toggleClass('hidden');
  field.not('.hidden').attr('name', 'productType').prop('required', true);
  field.filter('.hidden').removeAttr('name').prop('required', false);
  $('input.hidden').val('');
}

/**
 * 모달 초기화
 * @param {*} field
 * @param {*} btn
 * @param {*} img
 */
function initModal(field, btn, img) {
  $('.modal-form').each(function () {
    this.reset();
  });
  field.filter('select').removeClass('hidden').attr('name', 'productType').prop('required', true);
  field.filter('input').addClass('hidden').removeAttr('name').prop('required', false);
  btn.filter('select').removeClass('hidden');
  btn.filter('input').addClass('hidden');
  img.attr('src', '');
  regImgIcon.removeClass('hidden');
}
