<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화</title>
<link href="/resources/css/common.css" rel="stylesheet" />
<link href="/resources/css/header.css" rel="stylesheet" />
<link href="/resources/css/movie.css" rel="stylesheet" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
<script src="/resources/js/header.js" defer></script>
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div class="widemovie-wrapper">
    	<!-- top3 영화 부분 (추후 개발 예정) -->
    	<div></div>
    	<!-- 검색 창 -->
    	<div id="movielist-searchwrap">
    		<input type="text" id="movielist-search">
    		<button id="movielist-search-button">검색</button>
    	</div>
    	<!-- 영화 분류 -->
    	<div class="movielist-tab">
			<div class="movielist-tab-on">전체보기</div>
			<div class="movielist-tab-off">현재 상영 영화</div>
			<div class="movielist-tab-off">상영 예정 영화</div>
			<div class="movielist-tab-off">상영 종료 영화</div>
    	</div>
    	<!-- 영화 리스트 -->
    	<c:forEach items="${mList }" var="movie">
    		<c:forEach items="${miList }" var="movieImg">
    			<c:if test="${movie.movieNo eq movieImg.movieNo }">
		    		<div class="movie-outside">
		    			${movieImg.movieImgName }
		    		</div>
	    		</c:if>
    		</c:forEach>
    	</c:forEach>
    </div>
</body>
</html>