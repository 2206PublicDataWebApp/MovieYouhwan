<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/user/member/memberLogin.css" />
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<title>무비유환 - 로그인</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div id="user-wrapper">
        <div id="login-form">
            <div id="container">
                <h1 id="login-title">로 그 인</h1>
                <c:if test="${sessionScope.loginUser eq null }">
	                <form action="/member/login.yh" method="POST">
		                <div class="login-input">
		                    <div class="login-input-wrap">
		                        <input type="text" class="input-box" name="memberId" placeholder="아이디를 입력해주세요" maxlength="12" autocomplete="off" required>
		                    </div>
		                    <div class="login-input-wrap">
		                        <input type="password" class="input-box" name="memberPwd" placeholder="비밀번호를 입력해주세요" maxlength="20" required>
		                    </div>
		                    <button type="submit" id="longin-btn">로그인</button>
		                </div>
		        	</form>
                </c:if>
		                <div id="social_login">
		                    <div id="social-info">SNS 계정으로 로그인하기</div>
		                    <div id="snsLogo">
		                        <i class="fa-brands fa-github" id="sns-kakao"></i>
		                        <i class="fa-brands fa-github" id="sns-never"></i>
		                    </div>
		                </div>
		                <div class="member-navi">
		                    <a href="/member/findIdForm.yh"><div class="member-navi-btn">아이디 찾기</div></a>
		                    <div class="member-navi-btn">｜</div>
		                    <a href="/member/findPassForm.yh"><div class="member-navi-btn">비밀번호 찾기</div></a>
		                    <div class="member-navi-btn">｜</div>
		                    <a href="/member/joinView.yh"><div class="member-navi-btn">회원가입</div></a>
		                </div>
	                
            </div>
        </div>
    </div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>