<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화관 상세(관리자)</title>
<link href="../../../resources/css/common.css" rel="stylesheet">
<link href="../resources/css/cinema.css" rel="stylesheet">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<script src="/resources/js/cinema.js"></script>
</head>
<body>
	<div id="admin-wrapper">
		<br><br><br>
		<h3>영화관 상세</h3><br><br>
		<table>
			<tr>
				<td class="cinema-detailtitle">지점명</td>
				<td>${cinema.cinemaName }</td>
			</tr>
			<tr>
				<td class="cinema-detailtitle">지역</td>
				<td>${cinema.cinemaArea }</td>
			</tr>
			<tr>
				<td class="cinema-detailtitle">주소</td>
				<td>${cinema.cinemaAddress }</td>
			</tr>
			<tr>
				<td class="cinema-detailtitle">전화번호</td>
				<td>${cinema.cinemaTel }</td>
			</tr>
			<tr>
				<td class="cinema-detailtitle">한줄 소개</td>
				<td>${cinema.cinemaContent }</td>
			</tr>
			<tr>
				<td class="cinema-detailtitle">주차정보</td>
				<td><pre>${cinema.cinemaPark }</pre></td>
			</tr>
			<tr>
				<td class="cinema-detailtitle">대중교통</td>
				<td><pre>${cinema.cinemaPublic }</pre></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><img src="../resources/images/cinemaLodeImg/${cinema.cinemaImgRename }" width="500px" height="250px"></td>
			</tr>
		</table>
		<div id="cinemadetail-buttonwrap">
			<button id="cdupdate-button" class="cinemadetail-button" onclick="location.href='/admin/adminCinemaModify.yh'">수정하기</button>
			<button id="cddelete-button" class="cinemadetail-button" onclick="cinemaDataRemove();">삭제하기</button>
			<button id="cdlist-button" class="cinemadetail-button" onclick="location.href='/admin/adminCinemaList.yh'">목록으로</button>
		</div>
	</div>
</body>
</html>