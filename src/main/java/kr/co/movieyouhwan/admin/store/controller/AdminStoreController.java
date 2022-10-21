package kr.co.movieyouhwan.admin.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminStoreController {

  @RequestMapping(value = "/admin/store/list.yh")
  public String adminStoreList() {
    return "admin/store/adminStoreList";
  }
}