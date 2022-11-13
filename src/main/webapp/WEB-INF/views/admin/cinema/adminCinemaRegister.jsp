<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화관 등록(관리자)</title>
<link href="/resources/css/common.css" rel="stylesheet">
<link href="/resources/css/header.css" rel="stylesheet"/>
<link href="/resources/css/cinema.css" rel="stylesheet">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/cinema.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
	<div class="cinema-wrapper">
		<br><br><h3>영화관 등록</h3><br><br>
		<form action="/admin/adminCinemaInsert.yh" method="post" enctype="multipart/form-data">
			<div id="title-wrap">
				<span class="title">지점명</span>
				<input type="text" id="title-input" class="input" name="cinemaName" spellcheck="false" autocomplete="off"><br>
			</div>
			<div id="area-wrap">
				<span class="title">지역</span>
				<div class="input">
					<input type="radio" class="area-input" name="cinemaArea" value="서울">서울
					<input type="radio" class="area-input" name="cinemaArea" value="경기">경기
					<input type="radio" class="area-input" name="cinemaArea" value="인천">인천<br>
				</div>
			</div>
			<div id="plus-address">
				<p id="address-title" class="title">주소</p>
				<input type="button" id="address-rbutton" class="input" onclick="sample4_execDaumPostcode()" value="검색">
				<input type="text" id="sample4_roadAddress" class="input" name="cinemaAddress1" placeholder="도로명주소" autocomplete="off"><br>
			</div>
			<div id="detail-address">
				<input type="text" id="sample4_detailAddress" class="input" name="cinemaAddress2" placeholder="상세주소" autocomplete="off">
			</div>
			<div id="tel-wrap">
				<span class="title">전화번호</span>
				<input type="text" id="tel-input" class="input" name="cinemaTel" spellcheck="false" autocomplete="off"><br>
			</div>
			<div id="one-wrap">
				<span class="title">한줄소개</span>
				<input type="text" id="one-input" class="input" name="cinemaContent" spellcheck="false" autocomplete="off"><br>
			</div>
			<div class="ride-wrap">
				<span class="title">주차정보</span>
				<textarea class="ride-input" name="cinemaPark" spellcheck="false" autocomplete="off"></textarea><br>
			</div>
			<div class="ride-wrap">
				<span class="title">대중교통</span>
				<textarea class="ride-input" name="cinemaPublic" spellcheck="false" autocomplete="off"></textarea><br>
			</div>
			<div id="imgfile-wrap">
				<span class="title">사진 등록</span>
				<div class="file-wrap">
					<input id="imgload-name" value="첨부파일" placeholder="첨부파일">
					<label for="img-file">파일찾기</label>
					<input type="file" id="img-file" class="upload-file" name="uploadFile">
				</div>
			</div>
			<br><br><br>
			<div class="button-list">
				<button type="button" class="go-list" onclick="location.href='/admin/adminCinemaList.yh'">목록</button>
				<input type="submit" value="등록" id="cinemaregister-button">
			</div>
		</form>
	</div>
</body>
</html>