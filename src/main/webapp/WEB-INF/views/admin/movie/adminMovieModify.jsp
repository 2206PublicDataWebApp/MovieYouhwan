<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화 수정(관리자)</title>
<link href="/resources/css/common.css" rel="stylesheet"/>
<link href="/resources/css/header.css" rel="stylesheet"/>
<link href="/resources/css/movie.css" rel="stylesheet"/>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
	<div id="movieinsert-wrapper">
		<br><br><h3>영화 수정</h3><br><br>
		<div id="title-wrap">
			<span class="title">영화 제목</span>
			<input type="text" id="title-input" class="input" name="movieTitle" value="${movie.movieTitle }" spellcheck="false" autocomplete="off"><br>
		</div>
		<div id="type-wrap">
			<span class="title">영화 장르</span>
			<div class="input">
				<input type="checkbox" class="type-input" name="movieGenre" value="드라마" <c:if test="${movie.movieGenre == '드라마' }">checked</c:if>>드라마
				<input type="checkbox" class="type-input" name="movieGenre" value="코미디" <c:if test="${movie.movieGenre == '코미디' }">checked</c:if>>코미디
				<input type="checkbox" class="type-input" name="movieGenre" value="액션" <c:if test="${movie.movieGenre == '액션' }">checked</c:if>>액션
				<input type="checkbox" class="type-input" name="movieGenre" value="범죄" <c:if test="${movie.movieGenre == '범죄' }">checked</c:if>>범죄
				<input type="checkbox" class="type-input" name="movieGenre" value="공포" <c:if test="${movie.movieGenre == '공포' }">checked</c:if>>공포
				<input type="checkbox" class="type-input" name="movieGenre" value="스릴러" <c:if test="${movie.movieGenre == '스릴러' }">checked</c:if>>스릴러<br>
			</div>
		</div>
		<div id="runtime-wrap">
			<span class="title">상영 시간 (분)</span>
			<input type="text" id="runtime-input" class="input" name="movieRuntime" value="${movie.movieRuntime }" spellcheck="false" autocomplete="off"><br>
		</div>
		<div id="director-wrap">
			<span class="title">감독</span>
			<input type="text" id="director-input" class="input" name="movieDirector" value="${movie.movieDirector }" spellcheck="false" autocomplete="off"><br>
		</div>
		<div id="actor-wrap">
			<span class="title">배우</span>
			<input type="text" id="actor-input" class="input" name="movieActor" value="${movie.movieActor }" spellcheck="false" autocomplete="off"><br>
		</div>
		<div id="age-wrap">
			<span class="title">관람가능연령</span>
			<div class="input">
				<input type="radio" class="age-input" name="movieAge" value="전체" <c:if test="${movie.movieAge == '전체' }">checked</c:if>>전체 관람가
				<input type="radio" class="age-input" name="movieAge" value="만12세" <c:if test="${movie.movieAge == '만12세' }">checked</c:if>>만 12세 이상 관람가
				<input type="radio" class="age-input" name="movieAge" value="만15세" <c:if test="${movie.movieAge == '만15세' }">checked</c:if>>만 15세 이상 관람가
				<input type="radio" class="age-input" name="movieAge" value="청불" <c:if test="${movie.movieAge == '청불' }">checked</c:if>>청소년 관람 불가<br>
			</div>
		</div>
		<div class="date-wrap">
			<span class="title">개봉 예정일</span>
			<input type="date" class="date-input" name="movieStartday" value="${movie.movieStartday }"><br>
		</div>
		<div class="date-wrap">
			<span class="title">예매 시작일</span>
			<input type="date" class="date-input" name="movieTicketingday" value="${movie.movieTicketingday }"><br>
		</div>
		<div class="date-wrap">
			<span class="title">상영 종료일</span>
			<input type="date" class="date-input" name="movieEndday" value="${movie.movieEndday }"><br>
		</div>
		<div id="story-wrap">
			<p id="story-title" class="title">간편줄거리</p>
			<textarea id="story-input" class="input" name="movieContent" spellcheck="false" autocomplete="off">${movie.movieContent }</textarea><br>
		</div>
		<div id="imgfile-wrap">
			<span class="title">사진 등록</span>
			<div class="img-wrap">
				<input id="imgload-name" value="첨부파일" placeholder="첨부파일">
				<label for="img-file">파일찾기</label>
				<input type="file" id="img-file" class="upload-file" name="uploadImgFile">
			</div>
			<input type="button" value="추가" id="img-add" class="add-button" onclick="addimgfile()">
		</div>
		<div id="videofile-wrap">
			<span class="title">영상 등록</span>
			<div class="video-wrap">
				<input id="videoload-name" value="첨부파일" placeholder="첨부파일">
				<label for="video-file">파일찾기</label>
				<input type="file" id="video-file" class="upload-file" name="uploadVideoFile">
			</div>
			<input type="button" value="추가" id="video-add" class="add-button" onclick="addvideofile()">
		</div>
	</div>
</body>
</html>