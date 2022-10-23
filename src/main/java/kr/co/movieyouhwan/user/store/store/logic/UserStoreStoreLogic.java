package kr.co.movieyouhwan.user.store.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.store.UserStoreStore;

@Repository
public class UserStoreStoreLogic implements UserStoreStore {

  @Override
  public List<Product> selectProductList(SqlSessionTemplate session) {
    List<Product> productList = session.selectList("StoreMapper.selectProductList");
    return productList;
  }

}
