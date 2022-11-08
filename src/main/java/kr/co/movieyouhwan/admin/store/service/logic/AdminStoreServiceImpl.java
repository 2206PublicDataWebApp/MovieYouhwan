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

  // 상품 등록
  @Override
  public int registerProduct(Product product) {
    int result = aStoreStore.insertProduct(session, product);
    return result;
  }

  // 상품 삭제
  @Override
  public int deleteProduct(Integer productNo) {
    int result = aStoreStore.deleteProduct(session, productNo);
    return result;
  }

  // 상품 수정
  @Override
  public int modifyProduct(Product product) {
    int result = aStoreStore.updateProduct(session, product);
    return result;
  }

  // 상품 재배치
  @Override
  public void modifyProductOrder(List<Integer> productNoList) {
    aStoreStore.updateProductOrder(session, productNoList);
  }

  // 상품 리스트 불러오기
  @Override
  public List<Product> printAllProductList() {
    List<Product> productList = aStoreStore.selectAllProductList(session);
    return productList;
  }

  // 상품 유형 리스트 불러오기
  @Override
  public List<ProductType> printAllProductTypeList() {
    List<ProductType> productTypeList = aStoreStore.selectAllProductTypeList(session);
    return productTypeList;
  }

  // 상품 불러오기
  @Override
  public Product printOneProduct(int productNo) {
    Product product = aStoreStore.selectOneProduct(session, productNo);
    return product;
  }

}
