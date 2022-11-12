package kr.co.movieyouhwan.user.store.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.user.store.domain.Cart;
import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;
import kr.co.movieyouhwan.user.store.service.UserStoreService;
import kr.co.movieyouhwan.user.store.store.UserStoreStore;

@Service
public class UserStoreServiceImpl implements UserStoreService {

	@Autowired
	SqlSessionTemplate session;
	@Autowired
	UserStoreStore uStoreStore;

	// 장바구니에 같은 상품 있는지 체크
	@Override
	public int checkProductInCart(Cart cart) {
		int count = uStoreStore.selectCountProductInCart(session, cart);
		return count;
	}

	// 장바구니에 새로운 상품 담기
	@Override
	public int addNewProductToCart(Cart cart) {
		int result = uStoreStore.insertProductToCart(session, cart);
		return result;
	}

	// 장바구니에 있는 상품을 담으면 해당 상품 수량 증가
	@Override
	public int increaseProductCountUp(Cart cart) {
		int result = uStoreStore.updateProductCountUp(session, cart);
		return result;
	}

	// 장바구니에서 상품 수량 변경
	@Override
	public int modifyProductCountInCart(Cart cart) {
		int result = uStoreStore.updateProductCountInCart(session, cart);
		return result;
	}

	// 장바구니에서 상품 삭제
	@Override
	public int deleteProductsInCart(List<Integer> cartNoList) {
		int result = uStoreStore.deleteProductsInCart(session, cartNoList);
		return result;
	}

	// 상품 목록 불러오기
	@Override
	public List<Product> printAllProductList() {
		List<Product> pList = uStoreStore.selectAllProductList(session);
		return pList;
	}

	// 상품 유형 리스트 불러오기
	@Override
	public List<ProductType> printAllProductTypeList() {
		List<ProductType> pTypeList = uStoreStore.selectAllProductTypeList(session);
		return pTypeList;
	}

	// 상품 불러오기
	@Override
	public Product printOneProduct(int productNo) {
		Product product = uStoreStore.selectOneProduct(session, productNo);
		return product;
	}

	// 장바구니 리스트 불러오기
	@Override
	public List<Cart> printMyCartList(String memberId) {
		List<Cart> cartList = uStoreStore.selectMyCartList(session, memberId);
		return cartList;
	}

	// 장바구니에 선택한 상품 리스트 불러오기
	@Override
	public List<Cart> printCheckedCartList(int[] cartNoArray) {
		List<Cart> cartList = uStoreStore.selectCheckedCartList(session, cartNoArray);
		return cartList;
	}

	// 장바구니 상품 수량 체크
	@Override
	public int checkProductCount(int cartNo) {
		int productCount = uStoreStore.selectProductCount(session, cartNo);
		return productCount;
	}

}
