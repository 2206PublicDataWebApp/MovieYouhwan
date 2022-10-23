package kr.co.movieyouhwan.user.store.domain;

import java.sql.Date;

public class StoreCancel {
  private int storeCancelNo; // 스토어 결제취소번호
  private String impUid; // 아임포트
  private String refundHolder; // 환불계좌 소유주
  private String refundBank; // 환불계좌 은행코드
  private String refundAccount; // 환불계좌번호
  private String refundTel; // 환불계좌 소유주 연락처
  private int storePayNo; // 스토어 결제번호
}
