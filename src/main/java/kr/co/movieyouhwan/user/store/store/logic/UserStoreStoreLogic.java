package kr.co.movieyouhwan.user.store.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.user.store.domain.Cart;
import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;
import kr.co.movieyouhwan.user.store.store.UserStoreStore;

@Repository
public class UserStoreStoreLogic implements UserStoreStore {

  // 상품 리스트 불러오기
  @Override
  public List<Product> selectProductList(SqlSession session) {
    List<Product> pList = session.selectList("StoreMapper.selectProductList");
    return pList;
  }

  // 상품 유형 리스트 불러오기
  @Override
  public List<ProductType> selectProductTypeList(SqlSession session) {
    List<ProductType> pTypeList = session.selectList("StoreMapper.selectProductTypeList");
    return pTypeList;
  }

  // 장바구니에 같은 상품 있는지 체크
  @Override
  public int selectCountProductInCart(SqlSessionTemplate session, Cart cart) {
    int count = session.selectOne("StoreMapper.selectCountProductInCart", cart);
    return count;
  }

  // 장바구니에 새로운 상품 담기
  @Override
  public int insertProductToCart(SqlSession session, Cart cart) {
    int result = session.insert("StoreMapper.insertProductToCart", cart);
    return result;
  }

  // 장바구니에 있는 상품을 담으면 해당 상품 수량 변경
  @Override
  public int updateProductCountInCart(SqlSessionTemplate session, Cart cart) {
    int result = session.update("StoreMapper.updateProductCountInCart", cart);
    return result;
  }

}
