package kr.co.movieyouhwan.user.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.user.store.service.UserStoreService;

@Controller
public class UserStoreController {
  
  @Autowired
  UserStoreService uStoreService;

  // 스토어 상품 목록 View
  @RequestMapping(value = "/store/list.yh")
  public ModelAndView storeList(ModelAndView mv) {
//    List<Product> productList = uStoreService.printProductList();
//    if (!productList.isEmpty()) {
//      mv.addObject("productList", productList);
//    }
    mv.setViewName("user/store/storeList");
    return mv;
  }
  
  // 스토어 장바구니 View
  @RequestMapping(value="/store/cartView.yh")
  public ModelAndView storeCartView(ModelAndView mv) {
    mv.setViewName("user/store/cartView");
    return mv;
  }
  
  // 스토어 결제 완료 View
  @RequestMapping(value="/store/complete.yh")
  public ModelAndView storeComplete(ModelAndView mv) {
    mv.setViewName("user/store/storeComplete");
    return mv;
  }

}
