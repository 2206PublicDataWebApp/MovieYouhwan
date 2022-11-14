//아이디 정규식
var idJ = /^[a-z]+[a-z0-9]{5,19}$/;
// 이메일 검사 정규식
var mailJ = /^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/;

$("#memberId").keydown(function () {
    if ($('#memberId').val() == '') {
       $('#id_check').text('아이디를 입력하세요.');
       $('#id_check').css('color', 'red');
    } else if (idJ.test($('#memberId').val()) != true) {
       $('#id_check').text('6~12자의 영소문자, 숫자만 사용 가능합니다.');
       $('#id_check').css('color', 'red');
    }
}); 

$('form').on('submit', function () {
    var inval_Arr = new Array(8).fill(false);
    if (idJ.test($('#memberId').val())) {
       inval_Arr[0] = true;
    } else {
       inval_Arr[0] = false;
       alert('아이디를 확인하세요');
       return false;
    }


// email 인증 ajax
$('#email-confirm-btn').click(function() {
    const email = $('#memberEmail').val(); // 이메일 주소값 얻어오기
    console.log('입력받은 이메일 : ' + email); // 이메일 오는지 확인
    const checkInput = $('.mail-check-input') // 인증번호 입력하는곳 
    alert('인증번호가 전송되었습니다.');
    $.ajax({
       type : 'get',
       url : '/member/emailAuth.yh',
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

   //인증번호 체크
   if (($('#emailAuthNo').val() === code)){
    inval_Arr[6] = true;
    console.log('true');
 }else{
    inval_Arr[1] = false;
    alert('인증번호가 불일치합니다. 확인해주세요');   
    console.log('false');
    return false;
    }
   // 이메일 정규식
   if (mailJ.test($('#memberEmail').val())) {
    console.log("mail : " + mailJ.test($('#memberEmail').val()));
    inval_Arr[4] = true;
 } else {
    inval_Arr[4] = false;
    alert('이메일을 확인하세요.');
    return false;
 }
});

 $("#memberEmail").keydown(function () {
    if (mailJ.test($(this).val())) {
       $("#email_check").text('');
    } else {
       $('#email_check').text('이메일 양식을 확인해주세요.');
       $('#email_check').css('color', 'red');
    }
 });

 $('.mail-check-input').keydown(function () {
    const inputCode = $(this).val();
    const $resultMsg = $('#email_check2');
    
    if(inputCode === code){
       $resultMsg.html('인증번호가 일치합니다.');
       $resultMsg.css('color','green');
       $('#email-confirm-btn').attr('disabled',true);
       $('#memberEmail').attr('readonly',true);
    }else{
       $resultMsg.html('인증번호 불일치. 다시 확인해주세요!');
       $resultMsg.css('color','red');
    }
 });
 
// 유효성 체크


