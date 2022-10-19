<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화 등록(관리자)</title>
<link href="../resources/css/movie.css" rel="stylesheet">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<script src="/resources/js/movie.js"></script>
</head>
<body>
	<div id="movieinsert-wrapper">
		<br><br><br>
		<h3>영화 등록</h3><br><br>
		<div id="title-wrap">
			<span class="title">영화 제목</span>
			<input type="text" id="title-input" class="input"><br>
		</div>
		<div id="type-wrap">
			<span class="title">영화 장르</span>
			<div class="input">
				<input type="checkbox" class="type-input">드라마
				<input type="checkbox" class="type-input">코미디
				<input type="checkbox" class="type-input">액션
				<input type="checkbox" class="type-input">공포
				<input type="checkbox" class="type-input">스릴러<br>
			</div>
		</div>
		<div id="runtime-wrap">
			<span class="title">상영 시간</span>
			<input type="text" id="runtime-input" class="input"><br>
		</div>
		<div id="director-wrap">
			<span class="title">감독</span>
			<input type="text" id="director-input" class="input"><br>
		</div>
		<div id="actor-wrap">
			<span class="title">배우</span>
			<input type="text" id="actor-input" class="input"><br>
		</div>
		<div id="age-wrap">
			<span class="title">관람가능연령</span>
			<div class="input">
				<input type="radio" class="age-input">전체 관람가
				<input type="radio" class="age-input">만 12세 이상 관람가
				<input type="radio" class="age-input">만 15세 이상 관람가
				<input type="radio" class="age-input">청소년 관람 불가<br>
			</div>
		</div>
		<div class="date-wrap">
			<span class="title">개봉 예정일</span>
			<input type="date" class="date-input"><br>
		</div>
		<div class="date-wrap">
			<span class="title">예매 시작일</span>
			<input type="date" class="date-input"><br>
		</div>
		<div class="date-wrap">
			<span class="title">상영 종료일</span>
			<input type="date" class="date-input"><br>
		</div>
		<div id="story-wrap">
			<p id="story-title" class="title">간편줄거리</p>
			<textarea id="story-input" class="input"></textarea><br>
		</div>
		<div id="imgfile-wrap">
			<span class="title">사진 등록</span>
			<div class="file-wrap">
				<input id="imgload-name" value="첨부파일" placeholder="첨부파일">
				<label for="img-file">파일찾기</label>
				<input type="file" id="img-file" class="upload-file">
			</div>
			<input type="button" value="추가" id="img-add" class="add-button">
		</div>
		<div id="videofile-wrap">
			<span class="title">영상 등록</span>
			<div class="file-wrap">
				<input id="videoload-name" value="첨부파일" placeholder="첨부파일">
				<label for="video-file">파일찾기</label>
				<input type="file" id="video-file" class="upload-file">
				<input type="button" id="video-remove" value="삭제" onclick="removefile();">
			</div>
			<input type="button" value="추가" id="video-add" class="add-button" onclick="addfile();">
		</div>
		<br><br><br>
		<input type="button" value="등록" id="movieregister-button">
	</div>
</body>
</html>