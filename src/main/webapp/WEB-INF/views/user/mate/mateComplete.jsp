<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>무비유환 : 매칭 완료</title>
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/mate.css" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<script src="/resources/js/header.js" defer></script>
<script src="/resources/js/mate.js" defer></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div class="mate-option-wrapper">
		<h3>매칭 완료!</h3>
		<!-- 매칭 완료 상단 영역 -->
		<div id="mate-text">
			<div class="matecomplete-profile">메이트 프로필</div>
			<div class="matecomplete-grade">메이트 평가</div>
		</div>
		<!-- 매칭 완료 데이터 로드 영역 -->
		<div id="mate-data">
			<div class="matecomplete-profile">
				<!-- 사진 div : matecomplete-userimage -->
				<div class="matecomplete-userimage"></div>
				철수 *(20대, 남성)
			</div>
			<div class="matecomplete-grade">3.6</div>
			<div class="matecomplete-chatting">
				<button class="go-chatting">채팅하기</button>
			</div>
		</div>
		<!-- 버튼 영역 -->
		<div id="matecomplete-button">
			<button class="matecomplete-button">다시매칭</button>
			<button class="matecomplete-button">매칭목록</button>
		</div>
	</div>
</body>
</html>