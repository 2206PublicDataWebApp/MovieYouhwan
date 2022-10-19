<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화관 등록(관리자)</title>
<link href="../resources/css/cinema.css" rel="stylesheet">
</head>
<body>
	<div id="cinemainsert-wrapper">
		<br><br><br>
		<h3>영화관 등록</h3><br><br>
		<div id="title-wrap">
			<span class="title">지점명</span>
			<input type="text" id="title-input" class="input"><br>
		</div>
		<div id="area-wrap">
			<span class="title">지역</span>
			<div class="input">
				<input type="radio" class="area-input">서울
				<input type="radio">경기
				<input type="radio">인천<br>
			</div>
		</div>
		<div id="plus-address">
			<p class="title">주소</p>
			<input type="text" id="sample4_roadAddress" name="roomAddress1" placeholder="도로명주소"><br>
			<input type="button" onclick="sample4_execDaumPostcode()" value="검색">
			<input type="text" id="sample4_detailAddress" name="roomAddress2" placeholder="상세주소">
		</div>
		<span>전화번호</span>
		<input type="text"><br>
		<span>한줄소개</span>
		<input type="text"><br>
		<span>주차정보</span>
		<textarea></textarea><br>
		<span>대중교통</span>
		<textarea></textarea><br>
		<div id="imgfile-wrap">
			<span class="title">사진 등록</span>
			<div class="file-wrap">
				<input id="imgload-name" value="첨부파일" placeholder="첨부파일">
				<label for="img-file">파일찾기</label>
				<input type="file" id="img-file" class="upload-file">
			</div>
			<input type="button" value="추가" id="img-add" class="add-button">
		</div>
		<br><br><br>
		<input type="button" value="등록" id="movieregister-button">
	</div>
	<jsp:include page="../../common/footer.jsp"></jsp:include>
</body>
</html>