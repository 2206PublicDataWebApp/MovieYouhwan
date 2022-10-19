<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/join.css" />
<title>무비유환 회원가입</title>
</head>
<body>
<div id="user-wrapper">
    <div id="wrap">
        <div id="join_form">
            <div id="container">
                <div class="membership-form">
                    <h1 id="join_header">회 원 가 입</h1>
                    <div id="join_content">
                        <div class="login-input">
                            <div class="input-name-wrap">
                                <div class="check-wrap">
                                    <div class="input-name">아이디
                                        <span class="required-input">&nbsp;⦁ </span>
                                    </div>
                                        <div class="id-error">사용 불가능한 ID입니다</div>
                                        <!-- <div class="id-ok">사용 가능한 ID입니다</span> -->
                                </div>
                            </div>
                            <div class="login-input_wrap">
                                <input type="text" id="memberId" name="memberId" placeholder="영소문자, 숫자 6 ~ 12자리" maxlength="12" class="login-input_input">
                            </div>
                        </div>
                        <div class="login-input">
                            <div class="input-name-wrap">
                                <div class="check-wrap">
                                    <div class="input-name">비밀번호
                                        <span class="required-input">&nbsp;⦁</span>
                                    </div>
                                    <div id="pwd-error">사용조건에 맞는 비밀번호를 입력해주세요</div>
                                </div>
                            </div>
                            <div class="login-input_wrap">
                                <input type="password" id="memberPwd" name="memberPwd" placeholder="영문, 숫자, 특수문자 조합 8~20자리" maxlength="20" class="login-input_input"/>
                                <div id="pwd-guide">영문 대 소문자, 숫자, 특수기호(!,@,#,$)중 2가지 이상 조합하여 사용</div>
                            </div>
                            <!-- 비밀번호 확인 체크 -->
                            <div class="input-name-wrap">
                                <div class="check-wrap">
                                    <div class="input-name"> 비밀번호 확인
                                        <span class="required-input">&nbsp;⦁</span>
                                    </div>
                                    <div id="pwd-error">비밀번호가 일치하지 않습니다</div>
                                </div>
                            </div>
                            <div class="login-input_wrap">
                                <input type="password" id="memberPwd2" name="memberPwd2" placeholder="비밀번호 재입력" maxlength="20" class="login-input_input"/>
                            </div>
                        </div>
                        <div class="login-input">
                            <div class="input-name-wrap">
                                <div class="check-wrap">
                                    <div class="input-name">이름
                                        <span class="required-input">&nbsp;⦁ </span>
                                    </div>
                                </div>
                            </div>
                            <div class="login-input_wrap">
                                <input type="text" id="memberName" name="memberName" placeholder="실명을 입력해주세요" maxlength="13" class="login-input_input">
                            </div>
                        </div>
                        <div class="login-input">
                            <div class="input-name-wrap">
                                <div class="check-wrap">
                                    <div class="input-name">닉네임
                                        <span class="required-input">&nbsp;⦁ </span>
                                    </div>
                                </div>
                            </div>
                            <div class="login-input_wrap">
                                <input type="text" id="memberNick" name="memberNick" placeholder="닉네임을 입력해주세요" maxlength="10" class="login-input_input">
                            </div>
                        </div>
                        <div class="login-input">
                            <div class="input-name-wrap">
                                <div class="check-wrap">
                                    <div class="input-name"> 생년월일
                                        <span class="required-input">&nbsp;⦁ </span>
                                    </div>
                                </div>
                            </div>
                            <div class="login-input_wrap">
                                <input type="text" id="memberBirth" name="memberBirth" placeholder="생년월일 ex)19910116" maxlength="8" class="login-input_input">
                            </div>
                        </div>
                        <div class="login-input">
                            <div class="input-name-wrap">
                                <div class="check-wrap">
                                    <div class="input-name">성별
                                        <span class="required-input">&nbsp;⦁ </span>
                                    </div>
                                </div>
                            </div>
                            <div class="login-input_wrap">
                                <div id="input-gender-wrap">
                                    <!-- css 추가해야함 -->
                                    <input type="radio" id="memberGender" name="memberGender" value="woman" checked/> 여   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" id="memberGender" name="memberGender" value="man"/> 남
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> 
</div>
</body>
</html>