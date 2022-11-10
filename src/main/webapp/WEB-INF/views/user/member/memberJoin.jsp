<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/user/member/memberJoin.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
	<script src="/resources/js/user/userMember.js" defer></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<title>무비유환 - 회원가입</title>

</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<div id="user-wrapper">
    <div id="wrap">
        <div id="join_form">
            <div id="container">
                <div class="membership-form">
                    <h1 id="join_header">회 원 가 입</h1>
                        <form action="/member/join.yh" method="post" id="usercheck" enctype="multipart/form-data">
                        <div id="join_content">
                            <div class="login-input">
                                <div class="input-name-wrap">
                                    <div class="check-wrap">
                                        <div class="input-name">
                                    	         아이디
                                            <span class="required-input">&nbsp;⦁ </span>
                                        </div>
                                        <div class="id-check-wrap">
                                            <span class="validation id_check" id="id_check"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="login-input_wrap">
                                    <input type="text" id="memberId" name="memberId" placeholder="영소문자, 숫자 6 ~ 12자리" maxlength="12" class="login-input_input" required>
                                </div>
                            </div>
                            <div class="login-input">
                                <div class="input-name-wrap">
                                    <div class="check-wrap">
                                        <div class="input-name">
                                           		 비밀번호
                                            <span class="required-input">&nbsp;⦁</span>
                                        </div>
                                        <div class="validation" id="pw-check"></div>
                                    </div>
                                </div>
                                <div class="login-input_wrap">
                                    <input type="password" id="memberPwd" name="memberPwd" placeholder="비밀번호" maxlength="20" class="login-input_input" required>
                                    <div id="pwd-guide">영문 대 소문자, 숫자, 특수기호(!,@,#,$)중 2가지 이상 조합하여 사용</div>
                                </div>
                                <!-- 비밀번호 확인 체크 -->
                                <div class="input-name-wrap">
                                    <div class="check-wrap">
                                        <div class="input-name">
                                            	비밀번호확인
                                            <span class="required-input">&nbsp;⦁</span>
                                        </div>
                                        <div class="validation" id="pw2_check"></div>
                                        <!-- <div id="pwd-error">비밀번호가 일치하지 않습니다</div> -->
                                    </div>
                                </div>
                                <div class="login-input_wrap">
                                    <input type="password" id="memberPwd-chk" name="memberPwd-chk" placeholder="비밀번호 재입력" maxlength="20" class="login-input_input" required>
                                </div>
                            </div>
                            <div class="login-input">
                                <div class="input-name-wrap">
                                    <div class="check-wrap">
                                        <div class="input-name">
                                            	이름
                                            <span class="required-input">&nbsp;⦁ </span>
                                        </div>
                                        <div class="validation" id="name_check"></div>
                                    </div>
                                </div>
                                <div class="login-input_wrap">
                                    <input type="text" id="memberName" name="memberName" placeholder="실명을 입력해주세요" maxlength="6" class="login-input_input" required>
                                </div>
                            </div>
                            <div class="login-input">
                                <div class="input-name-wrap">
                                    <div class="check-wrap">
                                        <div class="input-name">
                                            닉네임
                                            <span class="required-input">&nbsp;⦁ </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="login-input_wrap">
                                    <input type="text" id="memberNick" name="memberNick" placeholder="최대6글자" maxlength="6" class="login-input_input" >
                                </div>
                            </div>
                            <div class="login-input">
                                <div class="input-name-wrap">
                                    <div class="check-wrap">
                                        <div class="input-name">
                   				            생년월일
                                            <span class="required-input">&nbsp;⦁ </span>
                                        </div>
                                        <div class="validation" id="birth_check"></div>
                                    </div>
                                </div>
                                <div class="login-input_wrap">
                                    <input type="number" id="memberBirth" name="memberBirth" placeholder="생년월일 ex) 20120101" maxlength="8" class="login-input_input" required>
                                </div>
                            </div>
                            <div class="login-input">
                                <div class="input-name-wrap">
                                    <div class="check-wrap">
                                        <div class="input-name">
                                           	성별
                                            <span class="required-input">&nbsp;⦁ </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="login-input_wrap">
                                    <div id="input-gender-wrap">
                                        <label for="female"><input type="radio" name="memberGender" value="여" checked/>&nbsp;여</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <label for="male"><input type="radio" name="memberGender" value="남"/>&nbsp;남</label><br>  
                                    </div>
                                </div>
                            </div>

                            <div class="login-input">
                                <div class="input-name-wrap">
                                    <div class="check-wrap">
                                        <div class="input-name">
                                  	          휴대폰 번호
                                            <span class="required-input">&nbsp;⦁ </span>
                                        </div>
                                        <div class="validation" id="phone_check"></div>
                                    </div>
                                </div>
                                <div class="login-input_wrap">
                                    <div class="input-button">
                                        <input type="text" id="memberPhone" name="memberPhone" placeholder="- 없이 입력 11자리 (01020221020)" maxlength="11" class="login-input_input" required>
                                        <!-- <input type="button" class="phone-confirm" name="phone-confirm" onclick="" value="인증하기" required>  -->
                                    </div>
                                </div>
                            </div> 
                            <div class="login-input">
                                <div class="input-name-wrap">
                                    <div class="check-wrap">
                                        <div class="input-name">
                                 	          이메일
                                            <span class="required-input">&nbsp;⦁ </span>
                                        </div>
                                        <div class="validation" id="email_check"></div>
                                    </div>
                                </div>
                                <div class="login-input_wrap">
                                    <div class="input-button">
                                        <input type="text" id="memberEmail" name="memberEmail" placeholder="movieyoohwan@mail.com" maxlength="30" class="login-input_input" required>
                                        <input type="button" id="email-confirm-btn" class="email-confirm" name="email-confirm" value="인증하기"> 
                                    </div>
                                    
                                    <input type="text" id="emailAuthNo" placeholder="인증번호 6자리" maxlength="6" class="login-input_input mail-check-input" required>
                                    <div class="validation" id="email_check2"></div>
                                </div>
                            </div>
                            <div class="login-input">
                                <div class="input-name-wrap">
                                    <div id="profile-form">
                                        <div id="profile-title">
                                            <div class="input-name">
                               		                 프로필사진
                                            </div>
                                            <div id="profile-info">회원님을 알릴 수 있는 사진을 등록해주세요<br>등록된 사진은 회원님의 게시물이나 댓글들에 사용됩니다
                                            </div>
                                        </div>
                                        <div id="profile-img-form">
                                            
                                            <!-- <i class="fa-solid fa-user fa-2x" id="profile-icon"></i> -->
                                            <img class="profile-img-preview">
                                            <label for="profile-img" id="img-update-btn">사진등록</label>
                                            <input type="file" id="profile-img" name="uploadFile" accept="image/png, image/jpeg">
                                        </div>
                                    </div>
                                </div>
                                <div id="membershipAgreement">
                                    <div id="agreeAllCheck">
                                        <input type="checkbox" name="Allcheck" id="Allcheck" class="checkAll"  required>
                                        <div id="allAgreeTerms">약관 전체 동의하기</div>
                                    </div>
                                    <div class="agreecheck">
                                        <input type="checkbox" name="check" class="check" required>
                                        <div Id="checkTerms">[필수] 개인정보 수집 및 이용 동의</div>
                                    </div>
                                    <div class="agreecheck">
                                        <input type="checkbox" name="check" class="check" required>
                                        <div Id="checkTerms">[필수] 무비유환 이용 약관</div>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" id="join-btn" name="join-btn">가입하기</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div> 
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>