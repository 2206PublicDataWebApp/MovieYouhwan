//아이디 정규식
var idJ = /^[a-z]+[a-z0-9]{5,19}$/;
// 이메일 검사 정규식
var mailJ = /^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/;





// email 인증 ajax
$('#email-confirm-btn').click(function() {
    const email = $('#memberEmail').val(); // 이메일 주소값 얻어오기
    console.log('입력받은 이메일 : ' + email); // 이메일 오는지 확인
    const checkInput = $('.mail-check-input') // 인증번호 입력하는곳 
    alert('인증번호가 전송되었습니다.');
    $.ajax({
       type : 'get',
       url : '/member/passEmailAuth.yh',
       data : { "email" : email },
       success : function (data) {
          console.log("data : " +  data);
          checkInput.attr('disabled',false);
          code = data;
       },
       error : function(data){
          alert('메일 발송을 실패했습니다.')
       }
    }); // end ajax
 }); // end send eamil

 $("#memberId").keyup(function () {
   if ($('#memberId').val() == '') {
      $('#check').text('아이디를 입력하세요.');
      $('#check').css('color', 'red');
   } else if (idJ.test($('#memberId').val()) != true) {
      $('#check').text('6~12자의 영소문자, 숫자만 사용 가능합니다.');
      $('#check').css('color', 'red');
   }
}); 
   // 유효성 검사
 $("#memberEmail").keyup(function () {
    if (mailJ.test($(this).val())) {
       $("#check").text('');
    } else {
       $('#check').text('이메일 양식을 확인해주세요.');
       $('#check').css('color', 'red');
    }
 });


 $('.mail-check-input').keyup(function () {
    const inputCode = $(this).val();
    const $resultMsg = $('#check');
    
    if(inputCode === code){
       $resultMsg.html('인증번호가 일치합니다.');
       $resultMsg.css('color','#3EA155');
       $('#email-confirm-btn').attr('disabled',true);
       $('#memberEmail').attr('readonly',true);
    }else{
       $resultMsg.html('인증번호 불일치. 다시 확인해주세요!');
       $resultMsg.css('color','red');
    }
 });
 
// 유효성 체크

//1~2 패스워드 일치 확인
$('#memberPwd-chk').keyup(function () {
   if ($('#memberPwd').val() != $(this).val()) {
      $('#pw_check').text('비밀번호가 일치하지 않습니다.');
      $('#pw_check').css('color', 'red');
   } else {
      $('#pw_check').text('');
   }
});
