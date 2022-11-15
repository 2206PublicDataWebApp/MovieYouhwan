<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화관</title>
<link href="/resources/css/common.css" rel="stylesheet" />
<link href="/resources/css/header.css" rel="stylesheet" />
<link href="/resources/css/footer.css" rel="stylesheet" />
<link href="/resources/css/cinema.css" rel="stylesheet">
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
<script src="/resources/js/header.js" defer></script>
<script src="/resources/js/footer.js" defer></script>
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<img src="../resources/images/cinema/user_movieList.png" id="userCinema-img">
	<div class="usercinema-wrapper">
		<!-- 서울 영화관 리스트 -->
		<h3>서 울</h3><br><br>
		<div class="ucinemalist-outside">
			<c:forEach items="${cList }" var="cinema" varStatus="i">
				<!-- 지역이름이 '서울'인 영화관만 선택 -->
				<c:if test="${cinema.cinemaArea eq '서울'}">
					<div class="ucinemalist-inside">
						<!-- div 선택 시 영화관 상세 페이지(userCinemaInformation.jsp)로 이동 -->
						<div class="one-cinema" onclick="location.href='/user/cinemaInformation.yh?cinemaNo=${cinema.cinemaNo}'">
							<!-- 영화관 이름 -->
							<div>
								${cinema.cinemaName }
							</div>
							<!-- 영화관 한줄 소개 -->
							<div class="cinema-fontwrap">
								<p class="cinema-font">${cinema.cinemaContent }</p>
							</div>
							<!-- 상세 보기 버튼 (div 눌러도 상세페이지 이동됨) -->
							<div class="cinema-buttonwrap">
								<button type="button" class="cinema-button">상세보기</button>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
		<h3>경 기</h3><br><br>
		<!-- 경기 영화관 리스트 -->
		<div class="ucinemalist-outside">
			<c:forEach items="${cList }" var="cinema" varStatus="i">
				<c:if test="${cinema.cinemaArea eq '경기'}">
					<div class="ucinemalist-inside">
						<div class="one-cinema" onclick="location.href='/user/cinemaInformation.yh?cinemaNo=${cinema.cinemaNo}'">
							<div>
								${cinema.cinemaName }
							</div>
							<div class="cinema-fontwrap">
								<p class="cinema-font">${cinema.cinemaContent }</p>
							</div>
							<div class="cinema-buttonwrap">
								<button class="cinema-button">상세보기</button>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
		<h3>인 천</h3><br><br>
		<!-- 인천 영화관 리스트 -->
		<div class="ucinemalist-outside">
			<c:forEach items="${cList }" var="cinema" varStatus="i">
				<c:if test="${cinema.cinemaArea eq '인천'}">
					<div class="ucinemalist-inside">
						<div class="one-cinema" onclick="location.href='/user/cinemaInformation.yh?cinemaNo=${cinema.cinemaNo}'">
							<div>
								${cinema.cinemaName }
							</div>
							<div class="cinema-fontwrap">
								<p class="cinema-font">${cinema.cinemaContent }</p>
							</div>
							<div class="cinema-buttonwrap">
								<button class="cinema-button">상세보기</button>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>