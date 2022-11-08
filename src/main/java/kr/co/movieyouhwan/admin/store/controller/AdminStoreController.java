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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.store.service.AdminStoreService;
import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;

@Controller
public class AdminStoreController {

  @Autowired
  AdminStoreService aStoreService;

  /**
   * 상품 목록 페이지
   * 
   * @param request
   * @param mv
   * @return
   */
  @RequestMapping(value = "/admin/store/manage.yh")
  public ModelAndView adminStoreList(HttpServletRequest request, ModelAndView mv) {
    try {
      List<Product> productList = aStoreService.printAllProductList();
      List<ProductType> productTypeList = aStoreService.printAllProductTypeList();
      if (!productList.isEmpty() && !productTypeList.isEmpty()) {
        mv.addObject("productList", productList);
        mv.addObject("productTypeList", productTypeList);
        mv.setViewName("admin/store/adminStoreList");
      } else {
        System.out.println("상품 불러오기 실패");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mv;
  }

  /**
   * 상품 재배치 페이지
   * 
   * @param request
   * @param mv
   * @return
   */
  @RequestMapping(value = "/admin/store/reorder.yh")
  public ModelAndView adminStoreReorder(HttpServletRequest request, ModelAndView mv) {
    try {
      List<Product> productList = aStoreService.printAllProductList();
      List<ProductType> productTypeList = aStoreService.printAllProductTypeList();
      if (!productList.isEmpty() && !productTypeList.isEmpty()) {
        mv.addObject("productList", productList);
        mv.addObject("productTypeList", productTypeList);
        mv.setViewName("admin/store/adminStoreReorder");
      } else {
        System.out.println("상품 불러오기 실패");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mv;
  }

  /**
   * 상품 재배치 저장
   * 
   * @param request
   * @param productNoList
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/admin/store/sort.yh", method = RequestMethod.POST)
  public void adminStoreSort(HttpServletRequest request,
      @RequestParam("productNoList[]") List<Integer> productNoList, ModelAndView mv) {
    try {
      aStoreService.modifyProductOrder(productNoList);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 상품 등록
   * 
   * @param request
   * @param product
   * @param productImg
   * @param mv
   * @return
   */
  @RequestMapping(value = "/admin/store/register.yh", method = RequestMethod.POST)
  public ModelAndView adminStoreRegister(HttpServletRequest request, @ModelAttribute Product product,
      @RequestParam("productImg") MultipartFile productImg, ModelAndView mv) {
    try {
      String productImgName = productImg.getOriginalFilename();
      if (!productImgName.equals("")) {
        String root = request.getSession().getServletContext().getRealPath("resources");
        String savePath = root + "/images/storeProduct";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String productImgRename = sdf.format(new Date(System.currentTimeMillis())) + "."
            + productImgName.substring(productImgName.lastIndexOf(".") + 1);
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
      } else {
        System.out.println("상품 등록 실패");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mv;
  }

  /**
   * 상품 수정
   * 
   * @param request
   * @param modProduct
   * @param productImg
   * @param mv
   * @return
   */
  @RequestMapping(value = "/admin/store/modify.yh", method = RequestMethod.POST)
  public ModelAndView adminStoreModify(HttpServletRequest request, @ModelAttribute Product modProduct,
      @RequestParam(value = "productImg", required = false) MultipartFile productImg, ModelAndView mv) {
    try {
      String productImgName = productImg.getOriginalFilename();
      if (productImg != null && !productImgName.equals("")) { // 파일을 새로 등록했으면
        String root = request.getSession().getServletContext().getRealPath("resources");
        String savePath = root + "/images/storeProduct";
        File file = new File(savePath + "/" + modProduct.getProductImgRename()); // 원래 있던 파일의 경로를 가져와서
        if (file.exists()) { // 원래 파일이 존재하면
          file.delete(); // 원래 파일을 삭제
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String productImgRename = sdf.format(new Date(System.currentTimeMillis())) + "."
            + productImgName.substring(productImgName.lastIndexOf(".") + 1);
        String productImgPath = savePath + "/" + productImgRename;
        productImg.transferTo(new File(productImgPath));
        modProduct.setProductImgName(productImgName);
        modProduct.setProductImgRename(productImgRename);
        modProduct.setProductImgPath(productImgPath);
      } else { // 파일을 새로 등록하지 않았으면
        Product orgProduct = aStoreService.printOneProduct(modProduct.getProductNo());
        modProduct.setProductImgName(orgProduct.getProductImgName());
        modProduct.setProductImgRename(orgProduct.getProductImgRename());
        modProduct.setProductImgPath(orgProduct.getProductImgPath());
      }
      int result = aStoreService.modifyProduct(modProduct);
      if (result > 0) {
        mv.setViewName("redirect:/admin/store/manage.yh");
      } else {
        System.out.println("상품 수정 실패");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mv;
  }

  /**
   * 상품 삭제
   * 
   * @param request
   * @param productNo
   * @param mv
   * @return
   */
  @RequestMapping(value = "/admin/store/delete.yh", method = RequestMethod.POST)
  public ModelAndView adminStoreDelete(HttpServletRequest request, @RequestParam("productNo") Integer productNo,
      ModelAndView mv) {
    try {
      if (productNo != null) {
        int result = aStoreService.deleteProduct(productNo);
        if (result > 0) {
          mv.setViewName("redirect:/admin/store/manage.yh");
        } else {
          System.out.println("상품 삭제 실패");
        }
      } else {
        System.out.println("존재하지 않는 상품");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mv;
  }
}