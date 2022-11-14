package kr.co.movieyouhwan.user.store.domain;

import java.util.HashMap;

public class StoreOrder {
	private String orderNo; // 주문번호
	private String memberId; // 주문자 아이디
	private String productName; // 주문명
	private int payAmount; // 결제승인금액
	private String payDate; // 결제일자
	private String expiryDate; // 만료일자
	private String availability; // 사용상태 (사용가능/기간만료/취소완료)
	private HashMap<String, Integer> productsWithCount; // 실제 결제한 상품과 수량 -> ORDER_DETAIL_TBL

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public HashMap<String, Integer> getProductsWithCount() {
		return productsWithCount;
	}

	public void setProductsWithCount(HashMap<String, Integer> productsWithCount) {
		this.productsWithCount = productsWithCount;
	}

	@Override
	public String toString() {
		return "StoreOrderHistory [orderNo=" + orderNo + ", memberId=" + memberId + ", productName=" + productName
				+ ", productsWithCount=" + productsWithCount + ", payAmount=" + payAmount + ", payDate=" + payDate
				+ ", expiryDate=" + expiryDate + ", availability=" + availability + "]";
	}

}
