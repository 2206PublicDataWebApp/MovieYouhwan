package kr.co.movieyouhwan.user.store.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

}
