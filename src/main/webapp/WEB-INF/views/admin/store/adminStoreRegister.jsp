<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<div class="modal-wrapper">
  <div class="modal-store">
    <h3 class="modal-title">상품 등록</h3>
    <hr />
    <form action="/admin/store/register.yh" method="post" class="modal-form" enctype="multipart/form-data">
      <!-- <input type="hidden" name="isNewType" class="hidden"> -->
      <table width="500px" height="150px">
        <tr>
          <td rowspan="4" width="30%" class="modal-img-area">
            <label for="product-img-register"><i class="fa-solid fa-image fa-xl" id="img-icon"></i><img class="img-preview" /></label>
            <input type="file" name="productImg" class="product-img" id="product-img-register" accept="image/png, image/jpeg" required />
          </td>
          <th width="20%">유형</th>
          <td width="50%">
            <select name="productType" class="modal-product-type product-type-select" required <c:if test="${empty productTypeList }">disabled</c:if>>
              <c:if test="${empty productTypeList }"><option>없음</option></c:if>
              <c:if test="${not empty productTypeList }">
                <c:forEach items="${productTypeList }" var="productType">
                  <option>${productType.productType }</option>
                </c:forEach>
              </c:if>
            </select>
            <button type="button" class="btn-to-input"><i class="fa-solid fa-plus"></i></button>
            <input type="text" class="modal-product-type product-type-input hidden" placeholder="상품 유형을 입력해주세요." autocomplete="off" />
            <button type="button" class="btn-to-select hidden"><i class="fa-solid fa-rotate-left"></i></button>
          </td>
        </tr>
        <tr>
          <th>상품명</th>
          <td><input type="text" name="productName" class="modal-input" placeholder="상품 이름을 입력해주세요." autocomplete="off" required /></td>
        </tr>
        <tr>
          <th>가격</th>
          <td><input type="number" name="productPrice" class="modal-input" placeholder="상품 가격을 입력해주세요." autocomplete="off" required /></td>
        </tr>
        <tr>
          <th>구성</th>
          <td><input type="text" name="productDesc" class="modal-input" placeholder="상품 구성을 입력해주세요." autocomplete="off" required /></td>
        </tr>
      </table>
      <div class="modal-btn-area">
        <button class="modal-btn modal-btn-save">저장</button>
        <button type="button" class="modal-btn modal-btn-cancel">취소</button>
      </div>
    </form>
  </div>
</div>
