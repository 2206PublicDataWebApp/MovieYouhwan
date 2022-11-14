package kr.co.movieyouhwan.user.store.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.store.domain.Cart;
import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;
import kr.co.movieyouhwan.user.store.domain.StoreOrder;
import kr.co.movieyouhwan.user.store.domain.StoreOrderDetail;

public interface UserStoreStore {

	// 장바구니에 같은 상품 있는지 체크
	int selectCountProductInCart(SqlSession session, Cart cart);

	// 장바구니에 새로운 상품 담기
	int insertProductToCart(SqlSession session, Cart cart);
	
	// 주문 정보 저장
	int insertStoreOrder(SqlSession session, StoreOrder storeOrder);

	// 주문 상세 정보 등록 (상품 목록, 상품 상세)
	int insertStoreOrderDetail(SqlSession session, StoreOrderDetail orderDetail);

	// 주문 상세 정보 등록 (장바구니)
	int registerStoreOrderDetailFromCart(SqlSession session, List<StoreOrderDetail> productsWithCount);

	// 장바구니에 있는 상품을 담으면 해당 상품 수량 증가
	int updateProductCountUp(SqlSession session, Cart cart);

	// 장바구니에서 상품 수량 변경
	int updateProductCountInCart(SqlSession session, Cart cart);

	// 장바구니에서 상품 삭제
	int deleteProductsInCart(SqlSession session, List<Integer> cartNoList);

	// 상품 리스트 불러오기
	List<Product> selectAllProductList(SqlSession session);

	// 상품 유형 리스트 불러오기
	List<ProductType> selectAllProductTypeList(SqlSession session);

	// 상품 불러오기
	Product selectOneProduct(SqlSession session, int productNo);

	// 장바구니 리스트 불러오기
	List<Cart> selectMyCartList(SqlSession session, String memberId);

	// 장바구니에서 선택한 상품 리스트 불러오기
	List<Cart> selectCheckedCartList(SqlSession session, int[] cartNoArray);

	// 장바구니 상품 수량 체크
	int selectProductCount(SqlSession session, int cartNo);

	// 결제를 위한 회원 이름, 휴대폰 번호, 이메일 불러오기
	Member selectBuyerInfo(SqlSession session, String memberId);



}
