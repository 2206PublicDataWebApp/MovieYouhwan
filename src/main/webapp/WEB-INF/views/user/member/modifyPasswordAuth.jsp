<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/user/member/find.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
    <script src="/resources/js/user/find.js" defer></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<title>무비유환 - 비밀번호 변경</title>

</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
 <div id="findIdForm">
        <div id="container">
        <form action="/member/updatePwd.yh" method="post">
            <input type="hidden" name="memberId" value="${memberId }"/>
            <h1 id="findIdTitle">비밀번호 변경</h1>
            <div id="guide-wrap">
                <div id="pwd-guide">영문 대 소문자, 숫자, 특수기호(!,@,#,$)중 2가지 이상 조합하여 사용</div>
                <div class="validation" id="pw_check"></div>
            </div>
            <div class="findId-input">
                <div class="input-wrap">
                    <input type="password" class="input-box" name="memberPwd" id="memberPwd" placeholder="새 비밀번호" required>
                </div>
                <div class="input-wrap">
                    <input type="password" class="input-box" id="memberPwd-chk" name="memberPwd-chk" placeholder="비밀번호 재입력" required>
                </div>

                <button type="submit" id="find-btn" name="find-btn">비밀번호 변경</button>
            </div>
        </form>
        </div>
    </div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>