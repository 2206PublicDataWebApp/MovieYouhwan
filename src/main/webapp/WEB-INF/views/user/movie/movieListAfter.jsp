<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 상영예정작</title>
<link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link href="/resources/css/common.css" rel="stylesheet" />
<link href="/resources/css/header.css" rel="stylesheet" />
<link href="/resources/css/footer.css" rel="stylesheet" />
<link href="/resources/css/movie.css" rel="stylesheet" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
<script src="/resources/js/header.js" defer></script>
<script src="/resources/js/footer.js" defer></script>
<script src="/resources/js/movie.js" defer></script>
<script src="/resources/js/user/movieZzim.js" defer></script>
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:useBean id="now" class="java.util.Date" />
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div class="midmovie-wrapper">
    	<!-- top3 영화 부분 (추후 개발 예정) -->
    	<div></div>
        <!-- 검색 창 -->
    	<form action="/movieListSearch.yh" method="post">
	    	<div id="movielist-searchwrap">
	    		<input type="search" id="movielist-search" placeholder="영화 제목으로 검색해보세요." name="searchName" value="${searchName }">
	    		<button type="submit" id="movielist-search-button">검색</button>
	    	</div>
    	</form>
    	<!-- 영화 분류 -->
    	<div class="movielist-tab">
			<div class="movielist-tab-off" onclick="location.href='/movieList.yh?currentPage=${pageInfo.currentPage}'">현재 상영 영화</div>
			<div class="movielist-tab-on" onclick="location.href='/movieListAfter.yh?currentPage=${pageInfo.currentPage}'">상영 예정 영화</div>
			<div class="movielist-tab-off" onclick="location.href='/movieListBefore.yh?currentPage=${pageInfo.currentPage}'">상영 종료 영화</div>
    	</div>
    	<!-- 영화 리스트 -->
	    <div class="movieList-out">
	    	<c:forEach items="${mlList }" var="movieList">
	   			<div class="movieList-outside">
	   				<div class="movie-img-area" onclick="location.href='/movieDetail.yh?movieNo=${movieList.movieNo}'">
	   					<img src="/resources/images/movieLodeImg/${movieList.movieImgRename }" width="240px">
	   				</div>
	   				<div class="movie-information-area">
	   					<!-- 영화 제목 표시 -->
	   					<p class="movie-information-name">${movieList.movieTitle }<p>
	   					<!-- 관람가능 연령 이미지 표시 -->
	   					<div class="movie-information-age">
							<c:if test="${movieList.movieAge eq '전체' }">
								<img src="/resources/images/movie/전체.jpg" width="25px" height="25px" />
							</c:if>
							<c:if test="${movieList.movieAge eq '만12세' }">
								<img src="/resources/images/movie/12.jpg" width="25px" height="25px" />
							</c:if>
							<c:if test="${movieList.movieAge eq '만15세' }">
								<img src="/resources/images/movie/15.jpg" width="25px" height="25px" />
							</c:if>
							<c:if test="${movieList.movieAge eq '청불' }">
								<img src="/resources/images/movie/청불.jpg" width="25px" height="25px" />
							</c:if>
						</div>
						<!-- 영화 개봉 일자 -->
						<div class="movie-information-start">
							<p class="movie-start-day">${movieList.movieStartday } 상영예정&nbsp; | <p>
						</div>
						<!-- 관람객 수 (추후 구현 예정) -->
						<div class="movie-information-see">
							<p class="movie-see-count">&nbsp;&nbsp;관람객 : 명</p>						
						</div>
						<div id="ticketBtn-zzim">
							<!-- 예매하기 버튼 -->
							<div class="ticket-button-area">
								<button type="button" class="ticket-button">예매하기</button>
							</div>
							<!-- 옆에 ♡ 아이콘으로 찜하기 만들어주시면 됩니다~ -->
							<!-- 찜하기 버튼 -->
							<form action="/saveZzim" method="post">
							<div id="heartWrap">
							<c:choose>
							<c:when test="${not empty loginUser.memberId}">
								<c:choose>
									<c:when test="${empty movieList.zzimNo}">
										<a idx="${movieList.movieNo }" href="javascript:" class="emptyHeart heart-click heart_icon${movieList.movieNo}">
											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="20" fill="currentColor" class="bi bi-suit-heart" viewBox="0 0 16 16">
												<path d="M8 6.236l-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" />
											</svg>
										</a>		
									</c:when>
									<c:otherwise>
										
										<a idx="${movieList.movieNo }" href="javascript:" class="fullHeart heart-click heart_icon${movieList.movieNo}">
											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="20" fill="currentColor" class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
												<path d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z" />
										  	</svg>
										</a>		
									</c:otherwise>
								</c:choose>
							</c:when>
							
							<c:otherwise>
								
								<a idx="${movieList.movieNo}" href="javascript:" class="heart-notlogin">
									<svg class="heart3" xmlns="http://www.w3.org/2000/svg" width="16" height="20" fill="currentColor" class="bi bi-suit-heart" viewBox="0 0 16 16">
										<path d="M8 6.236l-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" />
									</svg>
								</a>
								
							</c:otherwise>
							</c:choose>
							
							<div class="heartCount" id="heart${movieList.movieNo}">${movieList.movieZzim }</div>
							</div>
							</form>
						</div>
	   				</div>
	   			</div>
	    	</c:forEach>
	   	</div>
	   	<!-- 페이징 처리 -->
	   	<div class="page-count-wrap">
	   		<ul class="page-count">
	   			<c:if test="${pageInfo.startPage ne 1 }">
	   				<li><a href="/movieList.yh?currentPage=${pageInfo.startPage-1 }">&laquo;</a></li>
	   			</c:if>
	   			<c:forEach var="page" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
	   				<c:if test="${pageInfo.currentPage eq page}">
	   					<li><a class="currentP" href="#">${page }</a></li>
	   				</c:if>
	   				<c:if test="${pageInfo.currentPage ne page }">
	   					<li><a href="movieList.yh?currentPage=${page }">${page }</a></li>
	   				</c:if>
	   				<c:if test="${pageInfo.endPage ne pageInfo.pageCount }">
	   					<li><a href="movieList.yh?currentPage=${pageInfo.endPage+1 }">&raquo;</a></li>
	   				</c:if>
	   			</c:forEach>
	   		</ul>
	   	</div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>