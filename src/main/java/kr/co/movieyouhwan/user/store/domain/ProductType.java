package kr.co.movieyouhwan.user.store.domain;

public class ProductType {

  private int productTypeNo; // 상품 유형 번호
  private String productType; // 상품 유형

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

  @Override
  public String toString() {
    return "ProductType [productTypeNo=" + productTypeNo + ", productType=" + productType + "]";
  }

}
