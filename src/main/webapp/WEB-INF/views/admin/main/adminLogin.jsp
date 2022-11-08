<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/adminLogin.css" />
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/header.css" />

<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<script src="/resources/js/header.js.js" defer></script>
    <title>관리자 - 로그인</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
    <div id="user-wrapper"></div>
        <div id="login-form">
            <div id="container">
                <h1 id="login-title">ADMIN LOGIN</h1>
                <c:if test="${sessionScope.loginAdmin eq null }">
	                <form action="/admin/login.yh" method="POST">
		                <div class="login-input">
		                    <div class="login-input-wrap">
		                        <input type="text" class="input-box" name="memberId" value="movieyouhwan">
		                    </div>
		                    <div class="login-input-wrap">
		                        <input type="password" class="input-box" name="memberPwd" placeholder="youhwan">
		                    </div>
		                    <button type="submit" id="longin-btn">Sign Up</button>
		                </div>
		            </form>
		         </c:if>
            </div>
        </div>
    

</body>
</html>