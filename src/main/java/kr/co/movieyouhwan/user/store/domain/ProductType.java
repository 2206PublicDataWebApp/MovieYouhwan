package kr.co.movieyouhwan.user.store.domain;

public class ProductType {
  private String productType;

  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  @Override
  public String toString() {
    return "ProductType [productType=" + productType + "]";
  }

}
