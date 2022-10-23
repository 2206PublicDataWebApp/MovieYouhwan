package kr.co.movieyouhwan.user.store.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.user.store.domain.Product;

public interface UserStoreStore {

  // 스토어 상품 목록
  List<Product> selectProductList(SqlSessionTemplate session);

}
