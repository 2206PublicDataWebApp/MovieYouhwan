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
<link href="/resources/css/cinema.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
<script src="/resources/js/header.js" defer></script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<img src="../resources/images/cinema/user_movieList.png" id="userCinema-img">
	<div class="usercinema-wrapper">
		<h3>서 울</h3><br><br>
		<!-- 서울 영화관 리스트 -->
		<div class="ucinemalist-outside">
			<c:forEach items="${cList }" var="cinema" varStatus="i">
				<c:if test="${cinema.cinemaArea eq '서울'}">
					<div class="ucinemalist-inside">
						<div class="one-cinema" onclick="location.href='/user/cinemaDetail.yh?cinemaNo=${cinema.cinemaNo}'">
							<!-- 즐겨찾기 추가 영역 -->
							<!-- 아래 i 태그 코드 지우고 작성하셔도 됩니다 언니! 코드 완성하시고나서 주석 지워주세용 -->
							<!-- one-cinema 크기 30 30으로 해놨어요. css는 cinema.css 사용하시면 됩니다. -->
							<div class="favorite-cinema">
								<i class="fa-regular fa-star"></i>
							</div>
							<div>
								${cinema.cinemaName }
							</div>
							<div class="cinema-fontwrap">
								<p class="cinema-font">${cinema.cinemaContent }</p>
							</div>
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
						<div class="one-cinema" onclick="location.href='/user/cinemaDetail.yh?cinemaNo=${cinema.cinemaNo}'">
							<!-- 즐겨찾기 추가 영역 -->
							<!-- 아래 i 태그 코드 지우고 작성하셔도 됩니다 언니! 코드 완성하시고나서 주석 지워주세용 -->
							<!-- one-cinema 크기 30 30으로 해놨어요. css는 cinema.css 사용하시면 됩니다. -->
							<div class="favorite-cinema">
								<i class="fa-regular fa-star"></i>
							</div>
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
						<div class="one-cinema" onclick="location.href='/user/cinemaDetail.yh?cinemaNo=${cinema.cinemaNo}'">
							<!-- 즐겨찾기 추가 영역 -->
							<!-- 아래 i 태그 코드 지우고 작성하셔도 됩니다 언니! 코드 완성하시고나서 주석 지워주세용 -->
							<!-- one-cinema 크기 30 30으로 해놨어요. css는 cinema.css 사용하시면 됩니다. -->
							<div class="favorite-cinema">
								<i class="fa-regular fa-star"></i>
							</div>
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