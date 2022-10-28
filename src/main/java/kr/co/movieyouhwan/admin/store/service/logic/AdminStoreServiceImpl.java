package kr.co.movieyouhwan.admin.store.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.store.service.AdminStoreService;
import kr.co.movieyouhwan.admin.store.store.AdminStoreStore;
import kr.co.movieyouhwan.user.store.domain.Product;

@Service
public class AdminStoreServiceImpl implements AdminStoreService {

  @Autowired
  SqlSessionTemplate session;
  
  @Autowired
  AdminStoreStore aStoreStore;
  
  /**
   * 상품 등록
   */
  @Override
  public int registerProduct(Product product) {
    int result = aStoreStore.insertProduct(session, product);
    return result;
  }

}
