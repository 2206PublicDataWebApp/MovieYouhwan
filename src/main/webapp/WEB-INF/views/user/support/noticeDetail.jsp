<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>관리자 : 공지사항 상세</title>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/header.css" />
    <link rel="stylesheet" href="/resources/css/footer.css" />
    <link rel="stylesheet" href="/resources/css/noticeDetail.css">
    <link rel="stylesheet" href="/resources/css/support.css">
    <script src="/resources/js/jquery-3.6.1.min.js"></script>
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div id="admin-wrapper">
      <h2 class="support-title"><a href='/admin/site/manage.yh?tabIndex=2'>공지사항</a></h2>
      <form method="post"> 
        <input type="hidden" name="noticeNo" value="${notice.noticeNo}">
        <div id="btn-area">
        </div>
      </form>
      <hr />
      <div class="notice-detail-header">
        <div id="notice-title">${notice.noticeTitle}</div>
        <div id="notice-create">등록일 : ${notice.noticeCreate}</div>
      </div>
      <hr />
      <div class="notice-detail-content">${notice.noticeContent}</div>

      <hr />
      <div class="prev-next-area">
        <div class="prev-area">
          <a <c:if test="${!empty notice.prevNotice}">href="/support/noticeDetail.yh?noticeNo=${notice.prevNotice.noticeNo}&nCurrentPage=${nCurrentPage}"</c:if>>이전글 <i class="arrow fa-solid fa-chevron-up"></i>
            <c:choose>
              <c:when test="${empty notice.prevNotice}">
                이전글이 없습니다.
              </c:when>
              <c:otherwise>
                ${notice.prevNotice.noticeTitle}
              </c:otherwise>
            </c:choose> </a>
        </div>
        <hr />
        <div class="next-area">
          <a <c:if test="${!empty notice.nextNotice}">href="/support/noticeDetail.yh?noticeNo=${notice.nextNotice.noticeNo}&nCurrentPage=${nCurrentPage}"</c:if>>다음글 <i class="arrow fa-solid fa-chevron-down"></i>
            <c:choose>
              <c:when test="${empty notice.nextNotice}">
                다음글이 없습니다.
              </c:when>
              <c:otherwise>
                ${notice.nextNotice.noticeTitle}
              </c:otherwise>
            </c:choose> 
          </a>
        </div>
        <hr />
      </div>
      <div class="list-btn-area">
        <button type="button" class="list-btn" onclick="location.href='/support.yh?tabIndex=2&nCurrentPage=${nCurrentPage}'">목록</button>
      </div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
  </body>
</html>
