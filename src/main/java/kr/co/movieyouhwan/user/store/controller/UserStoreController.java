package kr.co.movieyouhwan.user.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;
import kr.co.movieyouhwan.user.store.service.UserStoreService;

@Controller
public class UserStoreController {
  
  @Autowired
  UserStoreService uStoreService;

  /**
   * 상품 목록 페이지
   * @param request
   * @param mv
   * @return
   */
  @RequestMapping(value = "/store/list.yh")
  public ModelAndView storeList(HttpServletRequest request, ModelAndView mv) {
    try {
      List<Product> productList = uStoreService.printProductList();
      List<ProductType> productTypeList = uStoreService.printProductTypeList();
      if (!productList.isEmpty() && !productTypeList.isEmpty()) {
        mv.addObject("productList", productList);
        mv.addObject("productTypeList", productTypeList);
        mv.setViewName("user/store/storeList");
      } else {
        System.out.println("상품 불러오기 실패");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mv;
  }
  
  // 스토어 상품 상세 View
  @RequestMapping(value="/store/detail.yh")
  public ModelAndView storeDetail(ModelAndView mv) {
    mv.setViewName("user/store/storeDetail");
    return mv;
  }
  
  // 스토어 장바구니 View
  @RequestMapping(value="/store/cart.yh")
  public ModelAndView storeCartView(ModelAndView mv) {
    mv.setViewName("user/store/storeCart");
    return mv;
  }
  
  // 스토어 결제 완료 View
  @RequestMapping(value="/store/complete.yh")
  public ModelAndView storeComplete(ModelAndView mv) {
    mv.setViewName("user/store/storeComplete");
    return mv;
  }

}
