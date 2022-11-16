package kr.co.movieyouhwan.user.store.store;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.store.domain.BestProduct;
import kr.co.movieyouhwan.user.store.domain.Cart;
import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;
import kr.co.movieyouhwan.user.store.domain.StoreOrder;
import kr.co.movieyouhwan.user.store.domain.StoreOrderDetail;

public interface UserStoreStore {

	/**
	 * 장바구니에 새로운 상품 담기
	 * @param session
	 * @param cart
	 * @return
	 */
	int insertProductToCart(SqlSession session, Cart cart);

	/**
	 * 주문 정보 저장
	 * @param session
	 * @param storeOrder
	 * @return
	 */
	int insertStoreOrder(SqlSession session, StoreOrder storeOrder);

	/**
	 * 주문 상세 정보 등록 (1건)
	 * @param session
	 * @param orderDetail
	 * @return
	 */
	int insertOneStoreOrderDetail(SqlSession session, StoreOrderDetail orderDetail);

	/**
	 * 주문 상세 정보 등록 (N건)
	 * @param session
	 * @param orderDetailList
	 * @return
	 */
	int insertManyStoreOrderDetail(SqlSession session, List<StoreOrderDetail> orderDetailList);

	/**
	 * 장바구니에 있는 상품을 담으면 해당 상품 수량 증가
	 * @param session
	 * @param cart
	 * @return
	 */
	int updateProductCountUp(SqlSession session, Cart cart);

	/**
	 * 장바구니에서 상품 수량 변경
	 * @param session
	 * @param cart
	 * @return
	 */
	int updateProductCountInCart(SqlSession session, Cart cart);

	/**
	 * 장바구니에서 상품 삭제
	 * @param session
	 * @param cartNoList
	 * @return
	 */
	int deleteProductsInCart(SqlSession session, List<Integer> cartNoList);

	/**
	 * 장바구니에 같은 상품 있는지 체크
	 * @param session
	 * @param cart
	 * @return
	 */
	int selectCountProductInCart(SqlSession session, Cart cart);

	/**
	 * 장바구니 번호 불러오기
	 * @param session
	 * @param cart
	 * @return
	 */
	int selectCartNo(SqlSession session, Cart cart);

	/**
	 * 장바구니 상품 수량 체크
	 * @param session
	 * @param cartNo
	 * @return
	 */
	int selectProductCountByCartNo(SqlSession session, int cartNo);

	/**
	 * 상품 리스트 불러오기
	 * @param session
	 * @return
	 */
	List<Product> selectAllProductList(SqlSession session);

	/**
	 * 상품 유형 리스트 불러오기
	 * @param session
	 * @return
	 */
	List<ProductType> selectAllProductTypeList(SqlSession session);

	/**
	 * 상품 불러오기
	 * @param session
	 * @param productNo
	 * @return
	 */
	Product selectOneProduct(SqlSession session, int productNo);

	/**
	 * 장바구니 리스트 불러오기
	 * @param session
	 * @param memberId
	 * @return
	 */
	List<Cart> selectMyCartList(SqlSession session, String memberId);

	/**
	 * 장바구니에서 선택한 상품 리스트 불러오기
	 * @param session
	 * @param cartNoArray
	 * @return
	 */
	List<Cart> selectCheckedCartList(SqlSession session, int[] cartNoArray);

	/**
	 * 결제를 위한 회원 이름, 휴대폰 번호, 이메일 불러오기
	 * @param session
	 * @param memberId
	 * @return
	 */
	Member selectBuyerInfo(SqlSession session, String memberId);

	/**
	 * 스토어 주문번호 불러오기
	 * @param session
	 * @param order
	 * @return
	 */
	String selectStoreOrderNo(SqlSession session, StoreOrder order);

	/**
	 * 스토어 구매내역 불러오기
	 * @param session
	 * @param orderNo
	 * @return
	 */
	StoreOrder selectStoreOrder(SqlSession session, String orderNo);

	/**
	 * 스토어 구매내역 리스트 불러오기 (조회 필터 미사용)
	 * @param session
	 * @param memberId
	 * @return
	 */
	List<StoreOrder> selectStoreOrderList(SqlSession session, String memberId);

	/**
	 * 스토어 구매내역 리스트 불러오기 (조회 필터 사용)
	 * @param session
	 * @param searchMap
	 * @return
	 */
	List<StoreOrder> selectStoreOrderListBySearch(SqlSession session, HashMap<String, String> searchMap);

	/**
	 * 스토어 구매내역 상세 리스트 불러오기
	 * @param session
	 * @param orderNo
	 * @return
	 */
	List<StoreOrderDetail> selectStoreOrderDetailList(SqlSession session, String orderNo);

	/**
	 * 인기 상품 리스트 불러오기
	 * @param session
	 * @param top
	 * @return
	 */
	List<BestProduct> selectBestProductList(SqlSession session, int top);

}
