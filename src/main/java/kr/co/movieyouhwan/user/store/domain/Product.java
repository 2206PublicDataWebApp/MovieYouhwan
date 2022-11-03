package kr.co.movieyouhwan.user.store.domain;

public class Product {
  private int productNo; // 상품 번호
  private String productName; // 상품명
  private String productType; // 상품 유형
  private int productPrice; // 상품 가격
  private String productDesc; // 상품 구성
  private int productOrder; // 상품 배치 순서
  private String productImgName; // 상품 사진명
  private String productImgRename; // 상품 사진 저장명
  private String productImgPath; // 상품 사진 저장경로

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

  public String getProductDesc() {
    return productDesc;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }

  public int getProductOrder() {
    return productOrder;
  }

  public void setProductOrder(int productOrder) {
    this.productOrder = productOrder;
  }

  public String getProductImgName() {
    return productImgName;
  }

  public void setProductImgName(String productImgName) {
    this.productImgName = productImgName;
  }

  public String getProductImgRename() {
    return productImgRename;
  }

  public void setProductImgRename(String productImgRename) {
    this.productImgRename = productImgRename;
  }

  public String getProductImgPath() {
    return productImgPath;
  }

  public void setProductImgPath(String productImgPath) {
    this.productImgPath = productImgPath;
  }

  @Override
  public String toString() {
    return "Product [productNo=" + productNo + ", productName=" + productName + ", productType=" + productType
        + ", productPrice=" + productPrice + ", productDesc=" + productDesc + ", productOrder=" + productOrder
        + ", productImgName=" + productImgName + ", productImgRename=" + productImgRename + ", productImgPath="
        + productImgPath + "]";
  }

}
