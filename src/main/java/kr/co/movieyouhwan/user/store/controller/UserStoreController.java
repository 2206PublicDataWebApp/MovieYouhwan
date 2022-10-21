package kr.co.movieyouhwan.user.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserStoreController {
  
  @RequestMapping(value = "/store/list.yh")
  public String adminStoreList() {
    return "user/store/storeList";
  }

}
