package kr.co.movieyouhwan.user.store.domain;

import java.sql.Date;

public class StorePay {

  private int storePayNo; // 결제번호 == 주문번호
  private String memberId; // 회원 아이디
  private Date payDate; // 결제일자
  private Date availability; // 주문상태 - 사용가능, 사용완료, 기간만료
  private Date expiryDate; // 만료일자 - 결제일로부터 6개월 뒤
  private String impUid; // 아임포트
  private String payMethod; // 결제수단 - 신용카드, 카카오페이, 네이버페이, 계좌이체, 무통장입금
  private int payPrice; // 결제금액

}
