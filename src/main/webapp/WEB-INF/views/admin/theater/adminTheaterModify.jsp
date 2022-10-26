<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 상영관 수정(관리자)</title>
<link href="/resources/css/common.css" rel="stylesheet">
<link href="/resources/css/header.css" rel="stylesheet"/>
<link href="/resources/css/theater.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
	<div class="theater-wrapper">
		<br><br><h3>상영관 수정</h3><br><br>
		<form action="/admin/adminTheaterUpdate.yh" method="post">
			<input type="hidden" name="theaterNo" value="${theater.theaterNo }" />
			<input type="hidden" name="cinemaName" value="${cinemaName }">
			<div id="cinema-wrap">
				<span class="title">지점명</span>
				<span class="input">${cinemaName }</span>
			</div>
			<div id="name-wrap">
				<span class="title">상영관 이름</span>
				<input type="text" id="name-input" class="input" name="theaterName" value="${theater.theaterName }" placeholder=" ex) 1관, 2관, 3관" spellcheck="false" autocomplete="off"><br>
			</div>
			<div id="seat-wrap">
				<span class="title">좌석 생성</span>
			</div>
			<div class="seat-choice">
				<span class="title">첫번째</span>
				<select class="seat-input" name="theaterSeatoneRow">
					<option value="0" <c:if test="${theater.theaterSeatoneRow == '0'}">selected</c:if>>없음</option>
					<option value="3" <c:if test="${theater.theaterSeatoneRow == '3'}">selected</c:if>>3</option>
					<option value="4" <c:if test="${theater.theaterSeatoneRow == '4'}">selected</c:if>>4</option>
					<option value="5" <c:if test="${theater.theaterSeatoneRow == '5'}">selected</c:if>>5</option>
					<option value="6" <c:if test="${theater.theaterSeatoneRow == '6'}">selected</c:if>>6</option>
					<option value="7" <c:if test="${theater.theaterSeatoneRow == '7'}">selected</c:if>>7</option>
					<option value="8" <c:if test="${theater.theaterSeatoneRow == '8'}">selected</c:if>>8</option>
					<option value="9" <c:if test="${theater.theaterSeatoneRow == '9'}">selected</c:if>>9</option>
					<option value="10" <c:if test="${theater.theaterSeatoneRow == '10'}">selected</c:if>>10</option>
					<option value="11" <c:if test="${theater.theaterSeatoneRow == '11'}">selected</c:if>>11</option>
					<option value="12" <c:if test="${theater.theaterSeatoneRow == '12'}">selected</c:if>>12</option>
					<option value="13" <c:if test="${theater.theaterSeatoneRow == '13'}">selected</c:if>>13</option>
					<option value="14" <c:if test="${theater.theaterSeatoneRow == '14'}">selected</c:if>>14</option>
					<option value="15" <c:if test="${theater.theaterSeatoneRow == '15'}">selected</c:if>>15</option>
					<option value="15">15</option>
				</select>
				<span class="seat-text">x</span>
				<select class="seat-input" name="theaterSeatoneColumn">
					<option value="0" <c:if test="${theater.theaterSeatoneColumn == '0'}">selected</c:if>>없음</option>
					<option value="3" <c:if test="${theater.theaterSeatoneColumn == '3'}">selected</c:if>>3</option>
					<option value="4" <c:if test="${theater.theaterSeatoneColumn == '4'}">selected</c:if>>4</option>
					<option value="5" <c:if test="${theater.theaterSeatoneColumn == '5'}">selected</c:if>>5</option>
					<option value="6" <c:if test="${theater.theaterSeatoneColumn == '6'}">selected</c:if>>6</option>
					<option value="7" <c:if test="${theater.theaterSeatoneColumn == '7'}">selected</c:if>>7</option>
					<option value="8" <c:if test="${theater.theaterSeatoneColumn == '8'}">selected</c:if>>8</option>
					<option value="9" <c:if test="${theater.theaterSeatoneColumn == '9'}">selected</c:if>>9</option>
					<option value="10" <c:if test="${theater.theaterSeatoneColumn == '10'}">selected</c:if>>10</option>
					<option value="11" <c:if test="${theater.theaterSeatoneColumn == '11'}">selected</c:if>>11</option>
					<option value="12" <c:if test="${theater.theaterSeatoneColumn == '12'}">selected</c:if>>12</option>
					<option value="13" <c:if test="${theater.theaterSeatoneColumn == '13'}">selected</c:if>>13</option>
					<option value="14" <c:if test="${theater.theaterSeatoneColumn == '14'}">selected</c:if>>14</option>
					<option value="15" <c:if test="${theater.theaterSeatoneColumn == '15'}">selected</c:if>>15</option>
				</select>
			</div>
			<div class="seat-choice">
				<span class="title">두번째</span>
				<select class="seat-input" name="theaterSeattwoRow">
					<option value="0" <c:if test="${theater.theaterSeattwoRow == '0'}">selected</c:if>>없음</option>
					<option value="3" <c:if test="${theater.theaterSeattwoRow == '3'}">selected</c:if>>3</option>
					<option value="4" <c:if test="${theater.theaterSeattwoRow == '4'}">selected</c:if>>4</option>
					<option value="5" <c:if test="${theater.theaterSeattwoRow == '5'}">selected</c:if>>5</option>
					<option value="6" <c:if test="${theater.theaterSeattwoRow == '6'}">selected</c:if>>6</option>
					<option value="7" <c:if test="${theater.theaterSeattwoRow == '7'}">selected</c:if>>7</option>
					<option value="8" <c:if test="${theater.theaterSeattwoRow == '8'}">selected</c:if>>8</option>
					<option value="9" <c:if test="${theater.theaterSeattwoRow == '9'}">selected</c:if>>9</option>
					<option value="10" <c:if test="${theater.theaterSeattwoRow == '10'}">selected</c:if>>10</option>
					<option value="11" <c:if test="${theater.theaterSeattwoRow == '11'}">selected</c:if>>11</option>
					<option value="12" <c:if test="${theater.theaterSeattwoRow == '12'}">selected</c:if>>12</option>
					<option value="13" <c:if test="${theater.theaterSeattwoRow == '13'}">selected</c:if>>13</option>
					<option value="14" <c:if test="${theater.theaterSeattwoRow == '14'}">selected</c:if>>14</option>
					<option value="15" <c:if test="${theater.theaterSeattwoRow == '15'}">selected</c:if>>15</option>
				</select>
				<span class="seat-text">x</span>
				<select class="seat-input" name="theaterSeattwoColumn">
					<option value="0" <c:if test="${theater.theaterSeattwoColumn == '0'}">selected</c:if>>없음</option>
					<option value="3" <c:if test="${theater.theaterSeattwoColumn == '3'}">selected</c:if>>3</option>
					<option value="4" <c:if test="${theater.theaterSeattwoColumn == '4'}">selected</c:if>>4</option>
					<option value="5" <c:if test="${theater.theaterSeattwoColumn == '5'}">selected</c:if>>5</option>
					<option value="6" <c:if test="${theater.theaterSeattwoColumn == '6'}">selected</c:if>>6</option>
					<option value="7" <c:if test="${theater.theaterSeattwoColumn == '7'}">selected</c:if>>7</option>
					<option value="8" <c:if test="${theater.theaterSeattwoColumn == '8'}">selected</c:if>>8</option>
					<option value="9" <c:if test="${theater.theaterSeattwoColumn == '9'}">selected</c:if>>9</option>
					<option value="10" <c:if test="${theater.theaterSeattwoColumn == '10'}">selected</c:if>>10</option>
					<option value="11" <c:if test="${theater.theaterSeattwoColumn == '11'}">selected</c:if>>11</option>
					<option value="12" <c:if test="${theater.theaterSeattwoColumn == '12'}">selected</c:if>>12</option>
					<option value="13" <c:if test="${theater.theaterSeattwoColumn == '13'}">selected</c:if>>13</option>
					<option value="14" <c:if test="${theater.theaterSeattwoColumn == '14'}">selected</c:if>>14</option>
					<option value="15" <c:if test="${theater.theaterSeattwoColumn == '15'}">selected</c:if>>15</option>
				</select>
			</div>
			<div class="seat-choice">
				<span class="title">세번째</span>
				<select class="seat-input" name="theaterSeatthreeRow">
					<option value="0" <c:if test="${theater.theaterSeatthreeRow == '0'}">selected</c:if>>없음</option>
					<option value="3" <c:if test="${theater.theaterSeatthreeRow == '3'}">selected</c:if>>3</option>
					<option value="4" <c:if test="${theater.theaterSeatthreeRow == '4'}">selected</c:if>>4</option>
					<option value="5" <c:if test="${theater.theaterSeatthreeRow == '5'}">selected</c:if>>5</option>
					<option value="6" <c:if test="${theater.theaterSeatthreeRow == '6'}">selected</c:if>>6</option>
					<option value="7" <c:if test="${theater.theaterSeatthreeRow == '7'}">selected</c:if>>7</option>
					<option value="8" <c:if test="${theater.theaterSeatthreeRow == '8'}">selected</c:if>>8</option>
					<option value="9" <c:if test="${theater.theaterSeatthreeRow == '9'}">selected</c:if>>9</option>
					<option value="10" <c:if test="${theater.theaterSeatthreeRow == '10'}">selected</c:if>>10</option>
					<option value="11" <c:if test="${theater.theaterSeatthreeRow == '11'}">selected</c:if>>11</option>
					<option value="12" <c:if test="${theater.theaterSeatthreeRow == '12'}">selected</c:if>>12</option>
					<option value="13" <c:if test="${theater.theaterSeatthreeRow == '13'}">selected</c:if>>13</option>
					<option value="14" <c:if test="${theater.theaterSeatthreeRow == '14'}">selected</c:if>>14</option>
					<option value="15" <c:if test="${theater.theaterSeatthreeRow == '15'}">selected</c:if>>15</option>
				</select>
				<span class="seat-text">x</span>
				<select class="seat-input" name="theaterSeatthreeColumn">
					<option value="0" <c:if test="${theater.theaterSeatthreeColumn == '0'}">selected</c:if>>없음</option>
					<option value="3" <c:if test="${theater.theaterSeatthreeColumn == '3'}">selected</c:if>>3</option>
					<option value="4" <c:if test="${theater.theaterSeatthreeColumn == '4'}">selected</c:if>>4</option>
					<option value="5" <c:if test="${theater.theaterSeatthreeColumn == '5'}">selected</c:if>>5</option>
					<option value="6" <c:if test="${theater.theaterSeatthreeColumn == '6'}">selected</c:if>>6</option>
					<option value="7" <c:if test="${theater.theaterSeatthreeColumn == '7'}">selected</c:if>>7</option>
					<option value="8" <c:if test="${theater.theaterSeatthreeColumn == '8'}">selected</c:if>>8</option>
					<option value="9" <c:if test="${theater.theaterSeatthreeColumn == '9'}">selected</c:if>>9</option>
					<option value="10" <c:if test="${theater.theaterSeatthreeColumn == '10'}">selected</c:if>>10</option>
					<option value="11" <c:if test="${theater.theaterSeatthreeColumn == '11'}">selected</c:if>>11</option>
					<option value="12" <c:if test="${theater.theaterSeatthreeColumn == '12'}">selected</c:if>>12</option>
					<option value="13" <c:if test="${theater.theaterSeatthreeColumn == '13'}">selected</c:if>>13</option>
					<option value="14" <c:if test="${theater.theaterSeatthreeColumn == '14'}">selected</c:if>>14</option>
					<option value="15" <c:if test="${theater.theaterSeatthreeColumn == '15'}">selected</c:if>>15</option>
				</select>
			</div>
			<div id="modify-buttonarea">
				<button id="modify-list" onclick="location.href='/admin/adminCinemaList.yh'">목록</button>
				<input type="submit" id="modify-done" value="수정">
			</div>
		</form>
	</div>
</body>
</html>