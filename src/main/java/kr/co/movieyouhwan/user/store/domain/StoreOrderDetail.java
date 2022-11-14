package kr.co.movieyouhwan.user.store.domain;

public class StoreOrderDetail {
	private String orderNo; // 주문번호
	private String productName; // 상품명
	private int productCount; // 상품수량

	public StoreOrderDetail() {
		
	}
	
	public StoreOrderDetail(String orderNo, String productName, Integer productCount) {
		this.orderNo = orderNo;
		this.productName = productName;
		this.productCount = productCount;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	@Override
	public String toString() {
		return "StoreOrderDetail [orderNo=" + orderNo + ", productName=" + productName + ", productCount="
				+ productCount + "]";
	}

}
