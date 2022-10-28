<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<form method="post">
  <div id="search-area">
    <select>
      <option>제목</option>
      <option>내용</option>
      <option>전체</option>
    </select>
    <input class="search-input" type="text" placeholder="검색어를 입력하세요" />
    <button class="search-btn">검색</button>
    <button type="button" class="left-top-dark-btn" onclick="location.href='/admin/noticeWriteForm.yh'">등록</button>
    <button type="button" class="right-top-white-btn" onclick="deleteNotice();">삭제</button>
  </div>
  <hr />
</form>
<div id="board">
  <div class="board-row" id="board-header">
    <div class="num-col">번호</div>
    <div class="title-col">제목</div>
    <div class="date-col">등록일</div>
    <div class="check-col"><input id="notice-check-all" type="checkbox" name="delete-check" /></div>
  </div>

  <c:if test="${!empty nList}">
    <c:forEach items="${nList}" var="notice" varStatus="i">
      <div class="board-row">
        <div class="num-col">${i.count}</div>
        <div class="title-col"><a href="/admin/NoticeDetail.yh?noticeNo=${notice.noticeNo}">${notice.noticeTitle}</a></div>
        <div class="date-col">${notice.noticeCreate}</div>
        <div class="check-col"><input class="notice-check support-check" type="checkbox" name="delete-check" value="${notice.noticeNo}" /></div>
      </div>
    </c:forEach>
  </c:if>
</div>
