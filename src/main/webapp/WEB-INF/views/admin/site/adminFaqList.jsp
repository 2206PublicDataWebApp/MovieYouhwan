<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!-- <form method="post">
  <div id="search-area">
    <select>
      <option>제목</option>
      <option>내용</option>
      <option>전체</option>
    </select>
    <input class="search-input" type="text" placeholder="검색어를 입력하세요" />
    <button type="submit" class="search-btn" onclick="form.action='/admin/faqSearch.yh'">검색</button>

    <button type="button" class="left-top-dark-btn" onclick="location.href='/admin/faqWriteForm.yh'">등록</button>
    <button type="button" class="right-top-white-btn" onclick=deleteFaq();>삭제</button>
  </div>
  <hr />
</form> -->


<div id="board">
  <div class="board-row" id="board-header">
    <div class="check-col"><input id="faq-check-all" type="checkbox" name="delete-check"/></div>
    <div class="num-col">번호</div>
    <div class="type-col">구분</div>
    <div id="faq-title-header">질문</div>
  </div>
  <c:if test="${!empty fList}">
    <c:forEach items="${fList}" var="faq" varStatus="i">
      <form action="/admin/faqModifyForm.yh" method="post">
        <div class="board-row">
          <input type="hidden" name="faqNo" value="${faq.faqNo}">
          <div class="check-col"><input class="faq-check support-check" type="checkbox" name="delete-check" value="${faq.faqNo}" /></div>
          <div class="num-col">${i.count}</div>
          <div class="type-col">
            <c:if test="${faq.faqType eq 'theater'}">영화관</c:if>
            <c:if test="${faq.faqType eq 'member'}">회원</c:if>
            <c:if test="${faq.faqType eq 'store'}">스토어</c:if>
            <c:if test="${faq.faqType eq 'pay'}">결제</c:if>
            <c:if test="${faq.faqType eq 'refund'}">환불</c:if>
          </div>
          <div class="title-col">
            <a class="answer-title">${faq.faqTitle}<i class="fa-solid fa-chevron-down"></i></a>
          </div>
        </div>
        <div class="faq-board-answer no-show">
          <div class="answer-content">${faq.faqContent}</div>
          <div class="modify-btn-area"><button type="submit" class="faq-modify-btn">수정</button></div>
        </div>
      </form>
    </c:forEach>
  </c:if>
</div>

