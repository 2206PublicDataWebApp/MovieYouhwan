package kr.co.movieyouhwan.user.store.service;

import java.util.List;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.store.domain.Cart;
import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;
import kr.co.movieyouhwan.user.store.domain.StoreOrder;
import kr.co.movieyouhwan.user.store.domain.StoreOrderDetail;

public interface UserStoreService {

	// 장바구니에 같은 상품 있는지 체크
	int checkProductInCart(Cart cart);

	// 장바구니에 새로운 상품 담기
	int addNewProductToCart(Cart cart);

	// 주문 정보 등록
	int registerStoreOrder(StoreOrder storeOrder);

	// 주문 상세 정보 등록 (1건)
	int registerOneStoreOrderDetail(StoreOrderDetail orderDetail);

	// 주문 상세 정보 등록 (N건)
	int registerManyStoreOrderDetail(List<StoreOrderDetail> orderDetailList);

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

	// 장바구니에서 선택한 상품 리스트 불러오기
	List<Cart> printCheckedCartList(int[] cartNoArray);

	// 장바구니 상품 수량 체크
	int checkProductCount(int cartNo);

	// 결제를 위한 회원 이름, 휴대폰 번호, 이메일 불러오기
	Member printBuyerInfo(String memberId);

	// 스토어 주문번호 불러오기
	String printOrderNo(StoreOrder order);

	// 스토어 구매내역 불러오기
	StoreOrder printStoreOrder(String orderNo);

	// 스토어 구매내역 리스트 불러오기
	List<StoreOrder> printStoreOrderList(String memberId);

	// 스토어 구매내역 상세 리스트 불러오기
	List<StoreOrderDetail> printStoreOrderDetailList(String orderNo);

}
