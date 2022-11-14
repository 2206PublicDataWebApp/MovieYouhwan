package kr.co.movieyouhwan.user.store.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.store.domain.Cart;
import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;
import kr.co.movieyouhwan.user.store.domain.StoreOrder;
import kr.co.movieyouhwan.user.store.domain.StoreOrderDetail;
import kr.co.movieyouhwan.user.store.store.UserStoreStore;

@Repository
public class UserStoreStoreLogic implements UserStoreStore {

	// 장바구니에 같은 상품 있는지 체크
	@Override
	public int selectCountProductInCart(SqlSession session, Cart cart) {
		int count = session.selectOne("StoreMapper.selectCountProductInCart", cart);
		return count;
	}

	// 장바구니에 새로운 상품 담기
	@Override
	public int insertProductToCart(SqlSession session, Cart cart) {
		int result = session.insert("StoreMapper.insertProductToCart", cart);
		return result;
	}

	// 주문 정보 저장
	@Override
	public int insertStoreOrder(SqlSession session, StoreOrder storeOrder) {
		int result = session.insert("StoreMapper.insertStoreOrder", storeOrder);
		return result;
	}

	// 주문 상세 정보 등록 (상품 목록, 상품 상세)
	@Override
	public int insertStoreOrderDetail(SqlSession session, StoreOrderDetail orderDetail) {
		int result = session.insert("StoreMapper.insertStoreOrderDetail", orderDetail);
		return result;
	}

	// 주문 상세 정보 등록 (장바구니)
	@Override
	public int registerStoreOrderDetailFromCart(SqlSession session, List<StoreOrderDetail> productsWithCount) {
		int result = session.insert("StoreMapper.insertStoreOrderDetail", productsWithCount);
		return result;
	}

	// 장바구니에 있는 상품을 담으면 해당 상품 수량 증가
	@Override
	public int updateProductCountUp(SqlSession session, Cart cart) {
		int result = session.update("StoreMapper.updateProductCountUp", cart);
		return result;
	}

	// 장바구니에서 상품 수량 변경
	@Override
	public int updateProductCountInCart(SqlSession session, Cart cart) {
		int result = session.update("StoreMapper.updateProductCountInCart", cart);
		return result;
	}

	// 장바구니에서 상품 삭제
	@Override
	public int deleteProductsInCart(SqlSession session, List<Integer> cartNoList) {
		int result = session.delete("StoreMapper.deleteProductsInCart", cartNoList);
		return result;
	}

	// 상품 리스트 불러오기
	@Override
	public List<Product> selectAllProductList(SqlSession session) {
		List<Product> pList = session.selectList("StoreMapper.selectProductList");
		return pList;
	}

	// 상품 유형 리스트 불러오기
	@Override
	public List<ProductType> selectAllProductTypeList(SqlSession session) {
		List<ProductType> pTypeList = session.selectList("StoreMapper.selectProductTypeList");
		return pTypeList;
	}

	// 상품 불러오기
	@Override
	public Product selectOneProduct(SqlSession session, int productNo) {
		Product product = session.selectOne("StoreMapper.selectOneProduct", productNo);
		return product;
	}

	// 장바구니 리스트 불러오기
	@Override
	public List<Cart> selectMyCartList(SqlSession session, String memberId) {
		List<Cart> cartList = session.selectList("StoreMapper.selectMyCartList", memberId);
		return cartList;
	}

	// 장바구니에서 선택한 상품 불러오기
	@Override
	public List<Cart> selectCheckedCartList(SqlSession session, int[] cartNoArray) {
		List<Cart> cartList = session.selectList("StoreMapper.selectCheckedCartList", cartNoArray);
		return cartList;
	}

	// 장바구니 상품 수량 체크
	@Override
	public int selectProductCount(SqlSession session, int cartNo) {
		int productCount = session.selectOne("StoreMapper.selectProductCount", cartNo);
		return productCount;
	}

	// 결제를 위한 회원 이름, 휴대폰 번호, 이메일 불러오기
	@Override
	public Member selectBuyerInfo(SqlSession session, String memberId) {
		Member buyerInfo = session.selectOne("MemberMapper.selectBuyerInfo", memberId);
		return buyerInfo;
	}

}
