package kr.co.movieyouhwan.user.store.domain;

public class BestProduct {

	private int productNo; // 상품번호
	private String productName; // 상품명
	private int productTypeNo; // 상품유형번호
	private String productType; // 상품유형명
	private int productPrice; // 상품가격
	private String productImgRename; // 상품사진 저장명
	private int totalCount; // 상품별 총 판매량
	private int rank; // 판매량 순위

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductTypeNo() {
		return productTypeNo;
	}

	public void setProductTypeNo(int productTypeNo) {
		this.productTypeNo = productTypeNo;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImgRename() {
		return productImgRename;
	}

	public void setProductImgRename(String productImgRename) {
		this.productImgRename = productImgRename;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "BestProduct [productNo=" + productNo + ", productName=" + productName + ", productTypeNo="
				+ productTypeNo + ", productType=" + productType + ", productPrice=" + productPrice
				+ ", productImgRename=" + productImgRename + ", totalCount=" + totalCount + ", rank=" + rank + "]";
	}

}