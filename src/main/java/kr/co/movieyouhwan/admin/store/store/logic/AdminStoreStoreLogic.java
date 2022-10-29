package kr.co.movieyouhwan.admin.store.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.store.store.AdminStoreStore;
import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;

@Repository
public class AdminStoreStoreLogic implements AdminStoreStore {

  /**
   * 상품 등록
   */
  @Override
  public int insertProduct(SqlSession session, Product product) {
    int result = session.insert("StoreMapper.insertProduct", product);
    return result;
  }

  /**
   * 상품 리스트 조회
   */
  @Override
  public List<Product> selectProductList(SqlSession session) {
    List<Product> pList = session.selectList("StoreMapper.selectProductList");
    return pList;
  }

  /**
   * 상품 유형 리스트 조회
   */
  @Override
  public List<ProductType> selectProductTypeList(SqlSession session) {
    List<ProductType> pTypeList = session.selectList("StoreMapper.selectProductTypeList");
    return pTypeList;
  }

}
