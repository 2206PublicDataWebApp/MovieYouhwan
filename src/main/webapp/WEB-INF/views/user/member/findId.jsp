<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/memberFindId.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
	<script src="/resources/js/userMember.js" defer></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<title>무비유환 - 아이디 찾기</title>

</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
 <div id="findIdForm">
        <div id="container">
            <h1 id="findIdTitle">아이디 찾기</h1>
            <div class="findId-input">
                <div class="input-wrap">
                    <input type="text" class="input-box" name="memberName" placeholder="이름">
                </div>
                <div class="input-wrap">
                    <input type="password" class="input-box" name="memberBirth" placeholder="생년월일 ex)20221004 ">
                </div>
                <div class="input-wrap">
                    <input type="text" class="input-box" name="memberPhone" placeholder="휴대폰 번호 (- 제외)">
                </div>
                <button type="submit" id="find-btn" name="find-btn">아이디찾기</button>
            </div>
            
        </div>
    </div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>