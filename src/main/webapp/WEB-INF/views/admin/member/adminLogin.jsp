<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/adminLogin.css" />
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<script src="/resources/js/header.js.js" defer></script>
    <title>관리자 - 로그인</title>
</head>
<body>
    <div id="user-wrapper">
        <div id="login-form">
            <div id="container">
                <h1 id="login-title">ADMIN LOGIN</h1>
                <div class="login-input">
                    <div class="login-input-wrap">
                        <input type="text" class="input-box" name="id" placeholder="youhwan">
                    </div>
                    <div class="login-input-wrap">
                        <input type="password" class="input-box" name="password" placeholder="비밀번호">
                    </div>
                    <button type="submit" id="longin-btn" name="longin-btn">Sign Up</button>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>