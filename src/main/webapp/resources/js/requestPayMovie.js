// 영화 예매 - 아임포트 가맹점 번호
const IMP_ID = 'imp53374831';

IMP.init(IMP_ID);

// 영화 예매 - 결제하기
$('#btn-movie-pay').click(function() {
	const payMethod = $('.pay-method').filter(':checked').val();
	if(payMethod) {
		const pg = payMethod === 'kakaopay' ? 'kakaopay' : 'html5_inicis';
		let movieName = $('#hidden-movie-name').val();
		const totalAmount = $('#final-money').text();
		// 예매자 정보(이름, 휴대폰번호, 이메일) 가져오기
		$.ajax({
			url : '/movie/pay/buyer.yh',
			type : 'POST',
			success : function(memberInfo) {
				requestPay(pg, payMethod, movieName, totalAmount, memberInfo);
			},
			error : function(error) {
				alert(JSON.stringify(error));
			}, 
		});
	}else {
		alert('결제수단을 선택해주세요.');
	}
});

// 영화 결제 - 이전 단계로 이동
$('#change-seat').click(function() {
	history.back();
});

// 상품 결제 (일반결제, 카카오페이결제)
function requestPay(pg, payMethod, movieName, totalAmount, memberInfo) {
	IMP.request_pay(
		{
			pg : pg,
			pay_method : payMethod,
			merchant_uid: 'movie_' + new Date().getTime(),
			name : movieName,
			amount : totalAmount,
			buyer_name : memberInfo.memberName,
			buyer_tel: memberInfo.memberPhone,
			buyer_email: memberInfo.memberEmail,
		},
		function(rsp) {
			// 결제 승인 또는 가상계좌 발급 성공
			if(rsp.success) {
				$.ajax({
					url : '/pay/verify.yh',
					method : 'POST',
					data : {
						imp_uid : rsp.imp_uid, // 아임포트 고유 결제번호
					},
				})
				// 결제 검증 성공
				.done(function(result) {
					// 결제 금액 비교
					if(rsp.paid_amount === result.response.amount) {
						alert('[결제완료] 결제 완료 페이지로 이동합니다.');
						$.ajax({
							url : '/movie/pay.yh',
							method : 'POST',
							data : {
								orderNo: rsp.merchant_uid, // 가맹점에서 생성/관리하는 고유 주문번호
								movieName : rsp.name,
								payAmount : rsp.paid_amount,
								paid_at : rsp.paid_at,
								status : rsp.status,
							},
						})
						// 결제 데이터 삽입 성공
						.done(function(msg) {
							$.ajax({
								url : '/movieTicketComplete.yh',
								mehtod : 'GET',
								data : {
									movieName : result.response.name,
									payAmount : result.response.amount,
									payDate : rsp.paid_at,
								},
							})
							.done(function() {
								$(location).attr('href', '/movieTicketComplete.yh');
								
							})
							.fail(function(error) {
								alert(JSON.stringify(error));
								alert('[페이지 이동 실패] 결제 완료 페이지로 이동할 수 없습니다.');
							});
						})
						.fail(function(error) {
							alert(JSON.stringify(error));
						})
					}else {
						alert('[결제이상] 결제 금액이 일치하지 않습니다.');
					}
				});
			}else {
				alert(rsp.error_msg);
			}
		}
	);
}