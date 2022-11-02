package kr.co.movieyouhwan.user.store.service;

import java.util.List;

import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;

public interface UserStoreService {

  // 상품 리스트 불러오기
  List<Product> printProductList();

  // 상품 유형 리스트 불러오기
  List<ProductType> printProductTypeList();

}
