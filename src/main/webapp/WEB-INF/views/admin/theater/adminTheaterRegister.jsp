<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 상영관 등록(관리자)</title>
<link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link href="/resources/css/common.css" rel="stylesheet">
<link href="/resources/css/header.css" rel="stylesheet">
<link href="/resources/css/theater.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
	<div class="theater-wrapper">
		<br><br><h3>상영관 등록</h3><br><br>
		<form action="/admin/adminTheaterInsert.yh" method="post" enctype="multipart/form-data">
			<div id="theater-wrap">
				<span class="title">지점명</span>
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
			</div>
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
			<div id="theater-register-button">
				<input type="button" id="gotheater-list" value="목록" onclick="location.href='/admin/adminCinemaList.yh'"/>
				<input type="submit" id="theater-button" value="등록"/>
			</div>
		</form>
	</div>
</body>
</html>