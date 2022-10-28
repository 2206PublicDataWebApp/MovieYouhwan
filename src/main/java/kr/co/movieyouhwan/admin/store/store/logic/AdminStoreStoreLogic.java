package kr.co.movieyouhwan.admin.store.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.store.store.AdminStoreStore;
import kr.co.movieyouhwan.user.store.domain.Product;

@Repository
public class AdminStoreStoreLogic implements AdminStoreStore {

  @Override
  public int insertProduct(SqlSession session, Product product) {
//    result = session.insert("StoreMapper.insertProductType", product.getProductType());
    int result = session.insert("StoreMapper.insertProduct", product);
    return result;
  }

}
