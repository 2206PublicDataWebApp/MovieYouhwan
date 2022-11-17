<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 회원 목록 (관리자)</title>
<link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link href="/resources/css/common.css" rel="stylesheet">
<link href="/resources/css/header.css" rel="stylesheet"/>
<link href="/resources/css/user/member/adminMemberList.css" rel="stylesheet">
<script src="/resources/js/user/userMember.js" defer></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
<div class="wrap">
    <div class="title-item">회원 목록</div>
    
    <!-- <div id="point-history-lookup-wrap">
        <div id="point-history-lookup">이용내역 조회</div>
        <div id="point-info">- 적립 예정 포인트는 사용 가능포인트에 포함되지 않으며, 환불 또는 거래 취소가 될 경우 내역에서 삭제됩니다.</div>
    </div>
    <div class="lookup-period">
        <div class="period-lookup">조회기간</div>
        <div class="period" id="1week">1주일</div>
        <div class="period" id="1month">1개월</div>
        <div class="period" id="1month">1개월</div>
        <div class="period" id="3month">3개월</div>
        <div class="period" id="6month">6개월</div>
    </div>
    <h3>전체 2건</h3> -->
    ${member}
    <form class="search-form" action="/admin/memberSearch.yh" method="get">
        <div id="search-input-btn">
            <select id="search-select" name="searchCondition">
                <option value="id" <c:if test="${searchCondition eq 'id'}">selected</c:if>>아이디</option>
                <option value="name" <c:if test="${searchCondition eq 'name'}">selected</c:if>>이름</option>
                <option value="nick" <c:if test="${searchCondition eq 'nick'}">selected</c:if>>닉네임</option>
                <option value="all" <c:if test="${searchCondition eq 'all'}">selected</c:if>>전체</option>
            </select>
            <input type="text" id="searchInput" name="searchValue" value="${searchValue }" autocomplete="off">
            <div class="search-button">
                <input type="submit" class="search" value="검색">
            </div>
        </div>
    </form>
        <table class="pointHistoryBoard">
            <thead id="title">
                <tr class="underLine">
                    <th class="td-id">ID</th>
                    <th class="td-name">이름</th>
                    <th class="td-nickname">닉네임</th>
                    <th class="td-point">포인트</th>
                </tr>
            </thead>
        <c:if test="${!empty uMemberList }">
            <!-- var는 변수 -->
        <c:forEach items="${uMemberList }" var="member" varStatus="i">
            <tbody id="historyList">
                <tr>
                    <td class="td-id"><div class="userId">${member.memberId}</div></td>
                    <td class="td-name"><div class="movie">${member.memberName}</div></td>
                    <td class="td-nickname"><div class="branch">${member.memberNick}</div></td>
                    <td class="td-point"><div class="point">${member.memberPoint}</div></td>
                </tr>
            </tbody>
        </c:forEach>
        </table>
        <div id="paging">
            <ul id="paging-wrap">
                <c:if test="currentPage != 1 }">
                    <li>
                        <a href="/admin/${urlVal }.yh?page=${currentPage - 1 }">＜</a>
                    </li>
                </c:if>
                
                <c:forEach var="p" begin="${startNavi }" end="${endNavi }">
                        <c:if test="${currentPage eq p }">
                            <b>${p }</b>
                        </c:if>
                        <c:if test="${currentPage ne p }">
                            <li id="paging-number"><a href="/admin/${urlVal }.yh?page=${p }&searchCondition=${searchCondition}&searchValue=${searchValue}">${p }</a></li>
                        </c:if>
                </c:forEach>
                <c:if test="${maxPage > currentPage }">
                    <li id="paging-number">
                        <a href="/admin/${urlVal }.yh?page=${currentPage + 1 }"><span>＞</span></a> 
                    </li>
                </c:if>
            </ul>
        </div>
    </c:if>
        
</div>
</div>
</body>
</html>