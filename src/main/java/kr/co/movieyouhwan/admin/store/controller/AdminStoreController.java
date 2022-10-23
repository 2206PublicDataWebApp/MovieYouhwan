package kr.co.movieyouhwan.admin.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.movieyouhwan.admin.store.service.AdminStoreService;

@Controller
public class AdminStoreController {
  
  @Autowired
  AdminStoreService aStoreService;

  @RequestMapping(value = "/admin/store/list.yh")
  public String adminStoreList() {
    return "admin/store/adminStoreList";
  }
  
  @RequestMapping(value = "/admin/store/reorderList.yh")
  public String adminStoreReorder() {
    return "admin/store/adminStoreReorder";
  }
}