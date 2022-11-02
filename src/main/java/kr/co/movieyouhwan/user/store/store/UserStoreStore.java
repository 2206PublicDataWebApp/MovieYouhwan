package kr.co.movieyouhwan.user.store.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;

public interface UserStoreStore {

  // 상품 리스트 불러오기
  List<Product> selectProductList(SqlSession session);

  // 상품 유형 리스트 불러오기
  List<ProductType> selectProductTypeList(SqlSession session);

}
