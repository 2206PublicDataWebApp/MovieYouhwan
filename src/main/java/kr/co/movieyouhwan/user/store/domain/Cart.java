package kr.co.movieyouhwan.user.store.domain;

public class Cart {
  private int cartNo; // 카트 번호
  private String memberId; // 회원 아이디
  private int productNo; // 상품 번호
  private String productName; // 상품명
  private int productTypeNo; // 상품 유형 번호
  private String productType; // 상품 유형명
  private int productPrice; // 상품 가격
  private int productCount; // 상품 개수
  private String productImgRename; // 상품 사진
  private String productStatus; // 장바구니 상태
  public int getCartNo() {
    return cartNo;
  }
  public void setCartNo(int cartNo) {
    this.cartNo = cartNo;
  }
  public String getMemberId() {
    return memberId;
  }
  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }
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
  public int getProductCount() {
    return productCount;
  }
  public void setProductCount(int productCount) {
    this.productCount = productCount;
  }
  public String getProductImgRename() {
    return productImgRename;
  }
  public void setProductImgRename(String productImgRename) {
    this.productImgRename = productImgRename;
  }
  public String getProductStatus() {
    return productStatus;
  }
  public void setProductStatus(String productStatus) {
    this.productStatus = productStatus;
  }
  @Override
  public String toString() {
    return "Cart [cartNo=" + cartNo + ", memberId=" + memberId + ", productNo=" + productNo + ", productName="
        + productName + ", productTypeNo=" + productTypeNo + ", productType=" + productType + ", productPrice="
        + productPrice + ", productCount=" + productCount + ", productImgRename=" + productImgRename
        + ", productStatus=" + productStatus + "]";
  }
  
}