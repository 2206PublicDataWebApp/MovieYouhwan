<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal-wrapper">
  <div class="modal-store">
    <h3 class="modal-title">상품 정보 수정</h3>
    <hr />
    <form action="/admin/store/modify.yh" method="post" class="modal-form">
      <table width="500px" height="150px">
        <tr>
          <td rowspan="4" width="30%" class="modal-img-area">
            <label for="product-img-modify"><img src="" alt="origin img" /></label><input type="file" class="product-img" id="product-img-modify" value="" accept="image/png, image/jpeg" required />
          </td>
          <th width="20%">구분</th>
          <td width="50%">
            <select name="productType" class="modal-product-type product-type-select" required>
              <!-- <%-- TODO: Bring values and contents from DB --%> -->
              <%--
              <option value="combo">콤보</option>
              --%>
            </select>
            <button type="button" class="btn-to-input"><i class="fa-solid fa-plus"></i></button>
            <input type="text" class="modal-product-type product-type-input hidden" placeholder="상품 옵션을 입력해주세요." />
            <button type="button" class="btn-to-select hidden"><i class="fa-solid fa-rotate-left"></i></button>
          </td>
        </tr>
        <tr>
          <th>상품명</th>
          <td><input type="text" value="" class="modal-input" placeholder="상품 이름을 입력해주세요." required /></td>
        </tr>
        <tr>
          <th>가격</th>
          <td><input type="number" value="" class="modal-input" placeholder="상품 가격을 입력해주세요." required /></td>
        </tr>
        <tr>
          <th>구성</th>
          <td><input type="text" value="" class="modal-input" placeholder="상품 구성을 입력해주세요." required /></td>
        </tr>
      </table>
      <div class="modal-btn-area">
        <button class="modal-btn modal-btn-save">저장</button>
        <button type="button" class="modal-btn modal-btn-cancel">취소</button>
      </div>
    </form>
  </div>
</div>
