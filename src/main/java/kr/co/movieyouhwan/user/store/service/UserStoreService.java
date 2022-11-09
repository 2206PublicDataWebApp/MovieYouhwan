package kr.co.movieyouhwan.user.store.service;

import java.util.List;

import kr.co.movieyouhwan.user.store.domain.Cart;
import kr.co.movieyouhwan.user.store.domain.Cart;
import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;

public interface UserStoreService {

  // 장바구니에 같은 상품 있는지 체크
  int checkProductInCart(Cart cart);

  // 장바구니에 새로운 상품 담기
  int addNewProductToCart(Cart cart);

  // 장바구니에 있는 상품을 담으면 해당 상품 수량 증가
  int increaseProductCountUp(Cart cart);

  // 장바구니에서 상품 수량 변경
  int modifyProductCountInCart(Cart cart);

  // 장바구니에서 상품 삭제
  int deleteProductsInCart(List<Integer> cartNoList);

  // 상품 리스트 불러오기
  List<Product> printAllProductList();

  // 상품 유형 리스트 불러오기
  List<ProductType> printAllProductTypeList();

  // 상품 불러오기
  Product printOneProduct(int productNo);

  // 장바구니 리스트 불러오기
  List<Cart> printMyCartList(String memberId);

  // 장바구니에서 선택한 상품 불러오기
  List<Cart> printCheckedCartList(List<Integer> cartNoList);

}
