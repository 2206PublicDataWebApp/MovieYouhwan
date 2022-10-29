package kr.co.movieyouhwan.admin.store.service;

import java.util.List;

import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;

public interface AdminStoreService {

  int registerProduct(Product product); // 상품 등록

  List<Product> printProductList(); // 상품 리스트 불러오기

  List<ProductType> printProductTypeList(); // 상품 유형 리스트 불러오기 

}
