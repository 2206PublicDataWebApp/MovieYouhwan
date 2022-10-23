package kr.co.movieyouhwan.user.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.service.UserStoreService;

@Controller
public class UserStoreController {
  
  @Autowired
  UserStoreService uStoreService;

  // 스토어 상품 목록
  @RequestMapping(value = "/store/list.yh")
  public ModelAndView adminStoreList(ModelAndView mv) {
//    List<Product> productList = uStoreService.printProductList();
//    if (!productList.isEmpty()) {
//      mv.addObject("productList", productList);
//    }
    mv.setViewName("user/store/storeList");
    return mv;
  }

}
