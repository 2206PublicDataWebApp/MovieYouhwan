<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<div class="modal-wrapper">
	<div class="modal-movie">
		<h3>영화 등록</h3>
		<p id="modal-movie-text">영화 선택</p>
		<select id="choice-addmovie">
			<c:forEach items="${mList }" var="movie" varStatus="i">
			</c:forEach>
		</select>
	</div>
</div>
