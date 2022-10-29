package kr.co.movieyouhwan.admin.store.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.store.service.AdminStoreService;
import kr.co.movieyouhwan.admin.store.store.AdminStoreStore;
import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;

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

  @Override
  public List<Product> printProductList() {
    List<Product> pList = aStoreStore.selectProductList(session);
    return pList;
  }

  @Override
  public List<ProductType> printProductTypeList() {
    List<ProductType> pTypeList = aStoreStore.selectProductTypeList(session);
    return pTypeList;
  }

}
