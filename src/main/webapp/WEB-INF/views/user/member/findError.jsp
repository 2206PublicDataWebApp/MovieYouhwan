<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/user/member/joinSuccess.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
<title>무비유환 - 회원정보 조회 실패</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div id="joinSucceseForm">
        <div id="succeseMessage">
            <h2>MovieYouHwan</h2>
		        존재하지 않는 회원정보입니다.<br>
                입력 정보를 확인해주세요
        </div>
        <div id="j-btn-group">
            <a class="main-btn-main" href="/home.yh">
                메인페이지로 이동
            </a>
            <a class="main-btn-login" href="/member/loginView.yh">
                로그인
            </a>
        </div>
    </div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>