package kr.co.movieyouhwan.admin.store.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;

public interface AdminStoreStore {

  int insertProduct(SqlSession session, Product product); // 상품 등록

  List<Product> selectProductList(SqlSession session); // 상품 리스트 조회
  
  List<ProductType> selectProductTypeList(SqlSession session); // 상품 유형 리스트 조회

}
