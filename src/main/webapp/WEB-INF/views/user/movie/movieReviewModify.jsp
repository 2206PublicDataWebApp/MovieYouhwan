<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<div class="modal-wrapper">
  <div class="modal-review">
    <div class="modal-header">
      평점 수정하기
      <i class="close-modal-btn fa-solid fa-xmark"></i>
    </div>
    <input type="hidden" id="modifyReviewNo" name="movieNo" value="${myMovieReview.movieNo}" />
    <div class="modal-review-rate" data-value="${myMovieReview.movieRate}">
      <i class="modal-selected-star fa-solid fa-star"></i>
      <i class="modal-selected-star fa-solid fa-star"></i>
      <i class="modal-selected-star fa-solid fa-star"></i>
      <i class="modal-selected-star fa-solid fa-star"></i>
      <i class="modal-selected-star fa-solid fa-star"></i>
      <div class="modal-selected-rate">${myMovieReview.movieRate}</div>
    </div>
    <textarea class="modal-textarea">${myMovieReview.movieReview}</textarea>
    <div class="modal-btn-area"><button id="modal-modify-btn" onclick="modifyReview()">수정하기</button></div>
  </div>
</div>
