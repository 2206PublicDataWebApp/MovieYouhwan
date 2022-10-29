package kr.co.movieyouhwan.admin.store.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.store.service.AdminStoreService;
import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;

@Controller
public class AdminStoreController {

  @Autowired
  AdminStoreService aStoreService;

  @RequestMapping(value = "/admin/store/manage.yh")
  public ModelAndView adminStoreList(HttpServletRequest request, ModelAndView mv) {
    List<Product> productList = aStoreService.printProductList();
    List<ProductType> productTypeList = aStoreService.printProductTypeList();
    System.out.println(productList.toString()); // vc
    System.out.println(productTypeList.toString()); // vc
    mv.addObject("productList", productList);
    mv.addObject("productTypeList", productTypeList);
    mv.setViewName("admin/store/adminStoreList");
    return mv;
  }

  @RequestMapping(value = "/admin/store/reorderView.yh")
  public String adminStoreReorder() {
    return "admin/store/adminStoreReorder";
  }

  @RequestMapping(value = "/admin/store/register.yh", method = RequestMethod.POST)
  public ModelAndView adminStoreRegister(HttpServletRequest request, @ModelAttribute Product product,
      @RequestParam("productImg") MultipartFile productImg, ModelAndView mv) {
    try {
      String productImgName = productImg.getOriginalFilename();
      if (!productImgName.equals("")) {
        String root = request.getSession().getServletContext().getRealPath("resources");
        String savePath = root + "/images/storeProduct";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String productImgRename = sdf.format(new Date(System.currentTimeMillis()))
            + productImgName.substring(productImgName.lastIndexOf("."));
        File file = new File(savePath);
        if (!file.exists()) {
          file.mkdir();
        }
        String productImgPath = savePath + "/" + productImgRename;
        productImg.transferTo(new File(productImgPath));
        product.setProductImgName(productImgName);
        product.setProductImgRename(productImgRename);
        product.setProductImgPath(productImgPath);
      }
      int result = aStoreService.registerProduct(product);
      if (result > 0) {
        mv.setViewName("redirect:/admin/store/manage.yh");
      }

    } catch (

    Exception e) {
      e.printStackTrace();
    }
    return mv;
  }
}