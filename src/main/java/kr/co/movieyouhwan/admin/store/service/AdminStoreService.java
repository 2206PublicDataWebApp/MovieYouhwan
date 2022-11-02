package kr.co.movieyouhwan.admin.store.service;

import java.util.List;

import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;

public interface AdminStoreService {

  int registerProduct(Product product); // 상품 등록

  int deleteProduct(Integer productNo); // 상품 삭제

  int modifyProduct(Product modProduct); // 상품 수정

  int modifyProductOrder(List<Integer> productNoList); // 상품 재배치

  List<Product> printProductList(); // 상품 리스트 불러오기

  List<ProductType> printProductTypeList(); // 상품 유형 리스트 불러오기

  Product printOneProduct(int productNo); // 상품 불러오기
}
