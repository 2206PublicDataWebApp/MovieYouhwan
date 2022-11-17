<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화 등록(관리자)</title>
<link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link href="/resources/css/common.css" rel="stylesheet"/>
<link href="/resources/css/header.css" rel="stylesheet"/>
<link href="/resources/css/movie.css" rel="stylesheet"/>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<script src="/resources/js/movie.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
	<div id="movieinsert-wrapper">
		<br><br><h3>영화 등록</h3><br><br>
		<form action="/admin/adminMovieInsert.yh" method="post" enctype="multipart/form-data">
			<div id="title-wrap">
				<span class="title">영화 제목</span>
				<input type="text" id="title-input" class="input" name="movieTitle" spellcheck="false" autocomplete="off"><br>
			</div>
			<div id="type-wrap">
				<span class="title">영화 장르</span>
				<div class="input">
					<input type="checkbox" class="type-input" name="movieGenre" value="드라마">드라마
					<input type="checkbox" class="type-input" name="movieGenre" value="코미디">코미디
					<input type="checkbox" class="type-input" name="movieGenre" value="로맨스">로맨스
					<input type="checkbox" class="type-input" name="movieGenre" value="액션">액션
					<input type="checkbox" class="type-input" name="movieGenre" value="범죄">범죄
					<input type="checkbox" class="type-input" name="movieGenre" value="공포">공포
					<input type="checkbox" class="type-input" name="movieGenre" value="스릴러">스릴러
					<input type="checkbox" class="type-input" name="movieGenre" value="애니메이션">애니메이션<br>
				</div>
			</div>
			<div id="runtime-wrap">
				<span class="title">상영 시간 (분)</span>
				<input type="text" id="runtime-input" class="input" name="movieRuntime" placeholder=" 숫자만 입력해주세요." spellcheck="false" autocomplete="off"><br>
			</div>
			<div id="director-wrap">
				<span class="title">감독</span>
				<input type="text" id="director-input" class="input" name="movieDirector" spellcheck="false" autocomplete="off"><br>
			</div>
			<div id="actor-wrap">
				<span class="title">배우</span>
				<input type="text" id="actor-input" class="input" name="movieActor" spellcheck="false" autocomplete="off"><br>
			</div>
			<div id="age-wrap">
				<span class="title">관람가능연령</span>
				<div class="input">
					<input type="radio" class="age-input" name="movieAge" value="전체">전체 관람가
					<input type="radio" class="age-input" name="movieAge" value="만12세">만 12세 이상 관람가
					<input type="radio" class="age-input" name="movieAge" value="만15세">만 15세 이상 관람가
					<input type="radio" class="age-input" name="movieAge" value="청불">청소년 관람 불가<br>
				</div>
			</div>
			<div class="date-wrap">
				<span class="title">개봉 예정일</span>
				<input type="date" class="date-register" name="movieStartday"><br>
			</div>
			<div class="date-wrap">
				<span class="title">예매 시작일</span>
				<input type="date" class="date-register" name="movieTicketingday"><br>
			</div>
			<div class="date-wrap">
				<span class="title">상영 종료일</span>
				<input type="date" class="date-register" name="movieEndday"><br>
			</div>
			<div id="story-wrap">
				<p id="story-title" class="title">간편줄거리</p>
				<textarea id="story-input" class="input" name="movieContent" spellcheck="false" autocomplete="off"></textarea><br>
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
			<br><br><br>
			<div id="movieregister-submit">
				<input type="submit" value="등록" id="movieregister-button">
			</div>
		</form>
	</div>
</body>
</html>