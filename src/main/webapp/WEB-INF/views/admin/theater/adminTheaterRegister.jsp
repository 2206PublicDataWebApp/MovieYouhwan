<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 상영관 등록(관리자)</title>
<link href="../../../resources/css/common.css" rel="stylesheet">
<link href="../resources/css/theater.css" rel="stylesheet">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<div id="admin-wrapper">
		<br><br><br>
		<h3>상영관 등록</h3><br><br>
		<form action="/admin/adminTheaterInsert.yh" method="post" enctype="multipart/form-data">
			<div id="cinema-wrap">
				<span class="title">영화관 선택</span>
				<c:if test="${!empty cList}">
					<select id="cinema-input" class="input" name="tCinemaNo">
						<c:forEach items="${cList}" var="cinema" varStatus="i">
							<option value="${cinema.cinemaNo }">${cinema.cinemaName }</option>
						</c:forEach>
					</select>
				</c:if>
			</div>
			<div id="name-wrap">
				<span class="title">상영관 이름</span>
				<input type="text" id="name-input" class="input" name="theaterName" placeholder=" ex) 1관, 2관, 3관" spellcheck="false" autocomplete="off"><br>
			</div>
			<div id="seat-wrap">
				<span class="title">좌석 생성</span>
				<input type="button" id="seat-button" class="input" value="미리보기"><br>
			</div>
			<!-- option value값이 저장이 안됩니다.. -->
			<div class="seat-choice">
				<span class="title">첫번째</span>
				<select class="seat-input" name="theaterSeatoneRow">
					<option value="0">없음</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
				</select>
				<span class="seat-text">x</span>
				<select class="seat-input" name="theaterSeatoneColumn">
					<option value="0">없음</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
				</select>
			</div>
			<div class="seat-choice">
				<span class="title">두번째</span>
				<select class="seat-input" name="theaterSeattwoRow">
					<option value="0">없음</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
				</select>
				<span class="seat-text">x</span>
				<select class="seat-input" name="theaterSeattwoColumn">
					<option value="0">없음</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
				</select>
			</div>
			<div class="seat-choice">
				<span class="title">세번째</span>
				<select class="seat-input" name="theaterSeatthreeRow">
					<option value="0">없음</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
				</select>
				<span class="seat-text">x</span>
				<select class="seat-input" name="theaterSeatthreeColumn">
					<option value="0">없음</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
				</select>
			</div>
			<input type="submit" id="theater-button" value="상영관 등록">
		</form>
	</div>
</body>
</html>