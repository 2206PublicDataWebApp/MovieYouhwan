<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화 목록(관리자)</title>
<link href="/resources/css/common.css" rel="stylesheet">
<link href="/resources/css/header.css" rel="stylesheet"/>
<link href="/resources/css/movie.css" rel="stylesheet">
</head>
<body>
	<jsp:useBean id="now" class="java.util.Date" />
	<jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
	<div class="widemovie-wrapper">
		<div id="movielist-top">
			<h3 id="movietop-text">영화 관리</h3>
			<form action="/admin/movieSearch.yh">
				<div id="movie-searchwrap">
					<input type="search" id="movie-search" placeholder="영화 제목으로 검색해보세요." name="searchName" value="${searchName }" autocomplete="off" />
					<button type="submit" id="search-button">검색</button>
				</div>
			</form>
			<button id="movie-button" onclick="location.href='/admin/adminMovieRegister.yh'">영화 등록</button>		
		</div>
		<div class="movielist-title">
			<div class="list-num">순번</div>
			<div class="list-title">제목</div>
			<div class="list-genre">장르</div>
			<div class="list-actor">배우</div>
			<div class="list-runtime">상영 시간</div>
			<div class="list-age">관람가능 연령</div>
			<div class="list-status">상영 상태</div>
		</div>
		<hr>
		<c:if test="${!empty mList }">
			<c:forEach items="${mList }" var="movie" varStatus="i">
				<div class="movielist-title">
					<div class="list-num" onclick="location.href='/admin/adminMovieDetail.yh?movieNo=${movie.movieNo}'">${i.count }</div>
					<div class="list-title" onclick="location.href='/admin/adminMovieDetail.yh?movieNo=${movie.movieNo}'">${movie.movieTitle }</div>
					<div class="list-genre" onclick="location.href='/admin/adminMovieDetail.yh?movieNo=${movie.movieNo}'">${movie.movieGenre }</div>
					<div class="list-actor" onclick="location.href='/admin/adminMovieDetail.yh?movieNo=${movie.movieNo}'">${movie.movieActor }</div>
					<div class="list-runtime" onclick="location.href='/admin/adminMovieDetail.yh?movieNo=${movie.movieNo}'">${movie.movieRuntime }분</div>
					<div class="listimg-age"  onclick="location.href='/admin/adminMovieDetail.yh?movieNo=${movie.movieNo}'">
						<c:if test="${movie.movieAge eq '전체' }">
							<img src="/resources/images/movie/전체.jpg" width="30px" height="30px" />
						</c:if>
						<c:if test="${movie.movieAge eq '만12세' }">
							<img src="/resources/images/movie/12.jpg" width="30px" height="30px" />
						</c:if>
						<c:if test="${movie.movieAge eq '만15세' }">
							<img src="/resources/images/movie/15.jpg" width="30px" height="30px" />
						</c:if>
						<c:if test="${movie.movieAge eq '청불' }">
							<img src="/resources/images/movie/청불.jpg" width="30px" height="30px" />
						</c:if>
					</div>
					<div class="list-status"  onclick="location.href='/admin/adminMovieDetail.yh?movieNo=${movie.movieNo}'">
						<fmt:formatDate var="today" value="${now }" pattern="yyyy-MM-dd"/>
						<c:if test="${movie.movieStartday > today}">
							<p>상영예정</p>
						</c:if>
						<c:if test="${movie.movieStartday <= today && movie.movieEndday > today}">
							<p>상영중</p>
						</c:if>
						<c:if test="${movie.movieStartday < today && movie.movieEndday < today}">
							<p>상영종료</p>
						</c:if>
					</div>
				</div>
				<hr>
			</c:forEach>
		</c:if>
		<!-- 페이징 처리 -->
	   	<div class="page-count-wrap">
	   		<ul class="page-count">
	   			<c:if test="${pageInfo.startPage ne 1 }">
	   				<li class="page-count-left"><a href="/admin/adminMovieList.yh?currentPage=${pageInfo.startPage-1 }">&laquo;</a></li>
	   			</c:if>
	   			<c:forEach var="page" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
	   				<c:if test="${pageInfo.currentPage eq page}">
	   					<li class="page-count-left"><a class="currentP" href="#">${page }</a></li>
	   				</c:if>
	   				<c:if test="${pageInfo.currentPage ne page }">
	   					<li class="page-count-left"><a href="/admin/adminMovieList.yh?currentPage=${page }">${page }</a></li>
	   				</c:if>
	   				<c:if test="${pageInfo.endPage ne pageInfo.pageCount }">
	   					<li class="page-count-left"><a href="/admin/adminMovieList.yh?currentPage=${pageInfo.endPage+1 }">&raquo;</a></li>
	   				</c:if>
	   			</c:forEach>
	   		</ul>
	   	</div>
	</div>
</body>
</html>