package kr.co.movieyouhwan.user.store.service;

import java.util.HashMap;
import java.util.List;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.store.domain.BestProduct;
import kr.co.movieyouhwan.user.store.domain.Cart;
import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;
import kr.co.movieyouhwan.user.store.domain.StoreOrder;
import kr.co.movieyouhwan.user.store.domain.StoreOrderDetail;

public interface UserStoreService {

	/**
	 * 장바구니에 새로운 상품 담기
	 * @param cart
	 * @return
	 */
	int addNewProductToCart(Cart cart);

	/**
	 * 주문 정보 등록
	 * @param storeOrder
	 * @return
	 */
	int registerStoreOrder(StoreOrder storeOrder);

	/**
	 * 주문 상세 정보 등록 (1건)
	 * @param orderDetail
	 * @return
	 */
	int registerOneStoreOrderDetail(StoreOrderDetail orderDetail);

	/**
	 * 주문 상세 정보 등록 (N건)
	 * @param orderDetailList
	 * @return
	 */
	int registerManyStoreOrderDetail(List<StoreOrderDetail> orderDetailList);

	/**
	 * 장바구니에 있는 상품을 담으면 해당 상품 수량 증가
	 * @param cart
	 * @return
	 */
	int increaseProductCountUp(Cart cart);

	/**
	 * 장바구니에서 상품 수량 변경
	 * @param cart
	 * @return
	 */
	int modifyProductCountInCart(Cart cart);

	/**
	 * 장바구니에서 상품 삭제
	 * @param cartNoList
	 * @return
	 */
	int deleteProductsInCart(List<Integer> cartNoList);

	/**
	 * 장바구니에 담기 전 같은 상품 있는지 체크
	 * @param cart
	 * @return
	 */
	int checkProductInCart(Cart cart);

	/**
	 * 장바구니 번호 불러오기
	 * @param cart
	 * @return
	 */
	int printCartNo(Cart cart);

	/**
	 * 장바구니 상품 수량 체크
	 * @param cartNo
	 * @return
	 */
	int printProductCountByCartNo(int cartNo);

	/**
	 * 상품 리스트 불러오기
	 * @return
	 */
	List<Product> printAllProductList();

	/**
	 * 상품 유형 리스트 불러오기
	 * @return
	 */
	List<ProductType> printAllProductTypeList();

	/**
	 * 상품 불러오기
	 * @param productNo
	 * @return
	 */
	Product printOneProduct(int productNo);

	/**
	 * 장바구니 리스트 불러오기
	 * @param memberId
	 * @return
	 */
	List<Cart> printMyCartList(String memberId);

	/**
	 * 장바구니에서 선택한 상품 리스트 불러오기
	 * @param cartNoArray
	 * @return
	 */
	List<Cart> printCheckedCartList(int[] cartNoArray);

	/**
	 * 상품 결제 시 회원 이름, 휴대폰 번호, 이메일 불러오기
	 * @param memberId
	 * @return
	 */
	Member printBuyerInfo(String memberId);

	/**
	 * 주문번호 불러오기
	 * @param order
	 * @return
	 */
	String printOrderNo(StoreOrder order);

	/**
	 * 스토어 구매내역 불러오기
	 * @param orderNo
	 * @return
	 */
	StoreOrder printStoreOrder(String orderNo);

	/**
	 * 스토어 구매내역 리스트 불러오기 (조회 필터 미사용)
	 * @param memberId
	 * @return
	 */
	List<StoreOrder> printStoreOrderList(String memberId);

	/**
	 * 스토어 구매내역 리스트 불러오기 (조회 필터 사용)
	 * @param searchMap
	 * @return
	 */
	List<StoreOrder> printStoreOrderListBySearch(HashMap<String, String> searchMap);

	/**
	 * 스토어 구매내역 상세 리스트 불러오기
	 * @param orderNo
	 * @return
	 */
	List<StoreOrderDetail> printStoreOrderDetailList(String orderNo);

	/**
	 * 인기 상품 리스트 불러오기
	 * @param top
	 * @return
	 */
	List<BestProduct> printBestProductList(int top);

}
