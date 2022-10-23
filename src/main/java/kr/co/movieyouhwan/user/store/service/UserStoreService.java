package kr.co.movieyouhwan.user.store.service;

import java.util.List;

import kr.co.movieyouhwan.user.store.domain.Product;

public interface UserStoreService {

  // 스토어 상품 목록
  List<Product> printProductList();

}
