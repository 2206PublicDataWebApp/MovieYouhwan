package kr.co.movieyouhwan.user.store.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;
import kr.co.movieyouhwan.user.store.service.UserStoreService;
import kr.co.movieyouhwan.user.store.store.UserStoreStore;

@Service
public class UserStoreServiceImpl implements UserStoreService {
  
  @Autowired
  SqlSessionTemplate session;
  @Autowired
  UserStoreStore uStoreStore;

  // 상품 목록 불러오기
  @Override
  public List<Product> printProductList() {
    List<Product> pList = uStoreStore.selectProductList(session);
    return pList;
  }

  // 상품 유형 리스트 불러오기
  @Override
  public List<ProductType> printProductTypeList() {
    List<ProductType> pTypeList = uStoreStore.selectProductTypeList(session);
    return pTypeList;
  }

}
