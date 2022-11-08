package kr.co.movieyouhwan.admin.store.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;

public interface AdminStoreStore {

  int insertProduct(SqlSession session, Product product); // 상품 등록

  int deleteProduct(SqlSession session, Integer productNon); // 상품 삭제

  int updateProduct(SqlSession session, Product product); // 상품 수정

  void updateProductOrder(SqlSession session, List<Integer> productNoList); // 상품 재배치

  List<Product> selectAllProductList(SqlSession session); // 상품 리스트 조회

  List<ProductType> selectAllProductTypeList(SqlSession session); // 상품 유형 리스트 조회

  Product selectOneProduct(SqlSession session, int productNo); // 상품 조회

}
