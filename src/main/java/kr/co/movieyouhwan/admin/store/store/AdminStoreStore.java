package kr.co.movieyouhwan.admin.store.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.movieyouhwan.user.store.domain.Product;

public interface AdminStoreStore {

  int insertProduct(SqlSession session, Product product); // 상품 등

}
