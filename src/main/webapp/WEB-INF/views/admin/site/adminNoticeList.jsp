<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<form method="post" action="/admin/noticeSearch.yh">
  <input type="hidden" name="nCurrentPage" value="${nPageInfo.currentPage}" />
  <div id="search-area">
    <select name="searchOption">
      <option value="title">제목</option>
      <option value="content">내용</option>
      <option value="all">전체</option>
    </select>
    <input class="search-input" type="text" name="searchValue" placeholder="검색어를 입력하세요" />
    <button type="submit" class="search-btn">검색</button>
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
        <div class="title-col"><a href="/admin/noticeDetail.yh?noticeNo=${notice.noticeNo}&nCurrentPage=${nPageInfo.currentPage}">${notice.noticeTitle}</a></div>
        <div class="date-col">${notice.noticeCreate}</div>
        <div class="check-col"><input class="notice-check support-check" type="checkbox" name="delete-check" value="${notice.noticeNo}" /></div>
      </div>
    </c:forEach>
  </c:if>

  <div class="pagination-area">
    <ul class="pagination">
      <c:if test="${nPageInfo.startPage ne 1}">
        <li><a href="/admin/site/manage.yh?nCurrentPage=${nPageInfo.startPage-1}&tabIndex=1&">&laquo;</a></li>
      </c:if>
      <c:forEach var="page" begin="${nPageInfo.startPage }" end="${nPageInfo.endPage }">
        <c:if test="${nPageInfo.currentPage eq page}">
          <li><a class="currentP" href="#">${page }</a></li>
        </c:if>
        <c:if test="${nPageInfo.currentPage ne page}">
          <li><a href="/admin/site/manage.yh?nCurrentPage=${page}&tabIndex=1">${page}</a></li>
        </c:if>
      </c:forEach>
      <c:if test="${nPageInfo.endPage ne nPageInfo.pageCount}">
        <li><a href="/admin/site/manage.yh?nCurrentPage=${nPageInfo.endPage+1}&tabIndex=1">&raquo;</a></li>
      </c:if>
    </ul>
  </div>
</div>
