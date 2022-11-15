<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>무비유환 : 영화 리뷰</title>
    <link href="/resources/css/common.css" rel="stylesheet" />
    <link href="/resources/css/header.css" rel="stylesheet" />
    <link href="/resources/css/footer.css" rel="stylesheet" />
    <link href="/resources/css/movie.css" rel="stylesheet" />
    <script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
    <script src="/resources/js/user/movieZzim.js" defer></script>
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
  </head>
  <body>
    <jsp:useBean id="now" class="java.util.Date" />
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div class="movie-wrapper">
		<div class="movie-product">
			<!-- 영화 메인 이미지 영역 -->
			<div id="movie-imgwrap">
				<img src="/resources/images/movieLodeImg/${miList[0].movieImgRename }" width="220px">
			</div>
			<!-- 상영 상태 표시 -->
			<div id="movie-textwrap">
				<h3 id="detail-movietitle">${movie.movieTitle }</h3>
				<fmt:formatDate var="today" value="${now }" pattern="yyyy-MM-dd"/>
				<c:if test="${movie.movieStartday > today}">
					<button id="movie-next">상영예정</button>
				</c:if>
				<c:if test="${movie.movieStartday <= today && movie.movieEndday > today}">
					<button id="movie-start">상영중</button>
				</c:if>
				<c:if test="${movie.movieStartday < today && movie.movieEndday < today}">
					<button id="movie-end">상영종료</button>
				</c:if>
				<img src="/resources/images/movie/15.jpg" width="30px" >
			</div>
  </body>
</html>
