package kr.co.movieyouhwan.user.store.service;

import java.util.List;

import kr.co.movieyouhwan.user.store.domain.Cart;
import kr.co.movieyouhwan.user.store.domain.Cart;
import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;

public interface UserStoreService {

  // 상품 리스트 불러오기
  List<Product> printProductList();

  // 상품 유형 리스트 불러오기
  List<ProductType> printProductTypeList();

  // 장바구니에 같은 상품 있는지 체크
  int checkProductInCart(Cart cart);

  // 장바구니에 새로운 상품 담기
  int addNewProductToCart(Cart cart);

  // 장바구니에 있는 상품을 담으면 해당 상품 수량 변경
  int modifyProductCountInCart(Cart cart);

  // 장바구니 조회
  List<Cart> printCartList(String memberId);

}
