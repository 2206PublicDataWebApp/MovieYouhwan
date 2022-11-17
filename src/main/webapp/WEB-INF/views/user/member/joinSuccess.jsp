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
<link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>

<title>무비유환 - 회원가입완료</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div id="joinSucceseForm">
        <div id="succeseMessage">
            <h2>MovieYouHwan</h2>
		            회원가입이 완료되었습니다!
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