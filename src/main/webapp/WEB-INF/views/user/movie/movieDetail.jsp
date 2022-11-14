<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화 상세페이지</title>
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
			<!-- 영화 리뷰 작성 후 영화 평균 평점 추가해주시면 됩니다 ~ (to.은혜) -->
			<!-- 영화 평점 영역 -->
			<div class="grade-see-wrapper">
				<div class="grade-wrap">
					<p>관람객 평점 : </p>
				</div>
				<!-- 누적 관객수 (추후 구현 예정)  -->
				<div>
					<p>누적 관객수 : 명</p>
				</div>
			</div>
			<hr>
			<div id="movie-information">
				<p class="detail-text">장르 : ${movie.movieGenre }</p>
				<p class="detail-text">상영시간 : ${movie.movieRuntime }</p>
			</div>
			<div id="movie-actor">
				<p class="detail-actor">감독 : ${movie.movieDirector }</p>
				<p class="detail-actor">배우 : ${movie.movieActor }</p>
			</div>
			<div id="detail-button">
				<button class="go-movieList" onclick="location.href='/movieTicketTime.yh'">예매하기</button>
				<button class="go-movieList" onclick="javascript:history.go(-1);">목록으로</button>
				<!-- 영화 찜하기 기능 추가해주시면됩니다. (to.은선언니) -->
				<div id="ticketBtn-zzim">
					<!-- 찜하기 버튼 -->
					<form action="/saveZzim" method="post">
					<div id="heartWrap">
					<c:choose>
					<c:when test="${not empty loginUser.memberId}">
						<c:choose>
							<c:when test="${empty movieList.zzimNo}">
								<a idx="${movieList.movieNo }" href="javascript:" class="detail-heart-empty emptyHeart heart-click heart_icon${movieList.movieNo}">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="20" fill="currentColor" class="bi bi-suit-heart" viewBox="0 0 16 16">
										<path d="M8 6.236l-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" />
									</svg>
								</a>		
							</c:when>
							<c:otherwise>
								
								<a idx="${movieList.movieNo }" href="javascript:" class="detail-heart-full fullHeart heart-click heart_icon${movieList.movieNo}">
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
		<!-- 정보, 리뷰 구분 탭 -->
		<div class="movie-tab-wrapper">
			<button class="movie-tab-on" onclick="/movieDetail.yh?movieNo=${movieNo}">영화 정보</button>
			<button class="movie-tab-off">영화 리뷰</button>
		</div>
		<!-- 하단 영역 시작 -->
		<!-- 줄거리 영역 -->
		<div class="detail-moviecontent">
			<h4 id="content-text">간편 줄거리</h4>
			<p id="content-detail">${movie.movieContent }</p>
		</div>
		<!-- 통계(도표) 기능 추가 -->
		
		<!-- 영화 영상 영역 -->
		<div class="detail-moviecontent">
			<h4 id="video-text">영화 영상</h4>
			<c:forEach items="${mvList }" var="movieVideo" varStatus="i">
				<video class="detail-video" src="/resources/images/movieLodeVideo/${movieVideo.movieVideoRename }" controls></video>
			</c:forEach>
		</div>
		<div class="detail-movieimg">
			<h4 id="video-text">영화 사진</h4>
			<c:forEach items="${miList }" var="movieImg" varStatus="i">
				<img src="/resources/images/movieLodeImg/${movieImg.movieImgRename }" width="490px">
			</c:forEach>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>