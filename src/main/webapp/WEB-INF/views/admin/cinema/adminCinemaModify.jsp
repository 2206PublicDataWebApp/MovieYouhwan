<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화관 수정(관리자)</title>
<link href="/resources/css/common.css" rel="stylesheet">
<link href="/resources/css/header.css" rel="stylesheet"/>
<link href="/resources/css/cinema.css" rel="stylesheet">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/cinema.js" defer></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
	<div class="cinema-wrapper">
		<br><br><h3>영화관 수정</h3><br><br>
		<form action="/admin/adminCinemaUpdate.yh" method="post" enctype="multipart/form-data">
			<input type="hidden" name="cinemaNo" value="${cinema.cinemaNo }">
			<div class="modifycinema-wrap">
				<div class="first">지점명</div>
				<div class="second">
					<input type="text" id="modify-title-input" name="cinemaName" value="${cinema.cinemaName }" spellcheck="false" autocomplete="off">
				</div>
			</div>
			<div class="modifycinema-wrap">
				<div class="first">지역</div>
				<div class="second">
					<input type="radio" id="area-modify" name="cinemaArea" value="서울" <c:if test="${cinema.cinemaArea == '서울'}">checked</c:if>>서울
					<input type="radio" class="area-modify" name="cinemaArea" value="경기" <c:if test="${cinema.cinemaArea == '경기'}">checked</c:if>>경기
					<input type="radio" class="area-modify" name="cinemaArea" value="인천" <c:if test="${cinema.cinemaArea == '인천'}">checked</c:if>>인천<br>
				</div>
			</div>
			<div class="modifyaddress-wrap">
				<div class="first">주소</div>
				<div class="second">
					<input type="text" id="sample4_roadAddress" class="detail-address-input" name="cinemaAddress1" value="${cinema.cinemaAddress1 }" placeholder="도로명주소" autocomplete="off">
					<input type="button" id="address-button" onclick="sample4_execDaumPostcode()" value="검색">
				</div>
			</div>
			<div class="modifyaddress-wrap">
				<div class="first"></div>
				<div class="second">
					<div id="modify-address">
						<input type="text" id="sample4_detailAddress" name="cinemaAddress2" value="${cinema.cinemaAddress2 }" placeholder="상세주소" autocomplete="off">
					</div>
				</div>
			</div>
			<div class="modifycinema-wrap">
				<div class="first">전화번호</div>
				<div class="second">
					<input type="text" id="modify-title-input" name="cinemaTel" value="${cinema.cinemaTel }">
				</div>
			</div>
			<div class="modifycinema-wrap">
				<div class="first">한줄소개</div>
				<div class="second">
					<input type="text" id="modify-title-input" name="cinemaContent" value="${cinema.cinemaContent }">
				</div>
			</div>
			<div class="modifycinema-wrap">
				<div class="first">주차정보</div>
				<div class="second">
					<textarea class="ride-modify" name="cinemaPark" spellcheck="false" autocomplete="off">${cinema.cinemaPark }</textarea>
				</div>
			</div>
			<div class="modifycinema-wrap">
				<div class="first">대중교통</div>
				<div class="second">
					<textarea class="ride-modify" name="cinemaPublic" spellcheck="false" autocomplete="off">${cinema.cinemaPublic }</textarea>
				</div>
			</div>
			<div id="imgmodify-wrap">
				<span class="title">이미지</span>
				<div id='modifyadd-wrap'>
					<div id='file-wrap'>
						<input id='modifyadd-name' value='${cinema.cinemaImgName }'>
						<label for='imgadd-file'>파일찾기</label>
						<input type='file' id='imgadd-file' class='upload-file' name='reloadFile'>
					</div>
				</div><br>
			</div>
			<div id="modify-buttonarea">
				<button id="modify-list" class="cinemadetail-button" onclick="location.href='/admin/adminCinemaList.yh'">목록으로</button>
				<input type="submit" id="modify-done" class="cinemadetail-button" value="수정하기">
			</div>
		</form>
	</div>
</body>
</html>