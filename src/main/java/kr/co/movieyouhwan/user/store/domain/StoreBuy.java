package kr.co.movieyouhwan.user.store.domain;

public class StoreBuy {

  private int storeBuyNo; // 구매번호
  private int storePayNo; // 결제번호 == 주문번호 - 1주문번호당 n구매번호
  private int productNo; // 상품번호
  private String productOption; // 상품옵션
  private int productCount; // 상품수량
  private int buyPrice; // 구매금액 = 상품가격 * 상품수량

}
