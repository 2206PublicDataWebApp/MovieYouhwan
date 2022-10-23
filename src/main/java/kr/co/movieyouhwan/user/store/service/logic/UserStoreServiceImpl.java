package kr.co.movieyouhwan.user.store.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.service.UserStoreService;
import kr.co.movieyouhwan.user.store.store.UserStoreStore;

@Service
public class UserStoreServiceImpl implements UserStoreService {
  
  @Autowired
  SqlSessionTemplate session;
  @Autowired
  UserStoreStore uStoreStore;

  @Override
  public List<Product> printProductList() {
    List<Product> productList = uStoreStore.selectProductList(session);
    return productList;
  }

}
