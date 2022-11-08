package kr.co.movieyouhwan.user.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.store.domain.Cart;
import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;
import kr.co.movieyouhwan.user.store.service.UserStoreService;

@Controller
public class UserStoreController {

  @Autowired
  UserStoreService uStoreService;

  /**
   * 상품 목록 페이지
   * 
   * @param request
   * @param mv
   * @return
   */
  @RequestMapping(value = "/store/list.yh")
  public ModelAndView storeList(HttpServletRequest request, ModelAndView mv) {
    try {
      List<Product> productList = uStoreService.printAllProductList();
      List<ProductType> productTypeList = uStoreService.printAllProductTypeList();
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

  /**
   * 장바구니에 상품 담기
   * 
   * @param request
   * @param cart
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/store/addToCart.yh", method = RequestMethod.POST)
  public String storeAddToCart(HttpServletRequest request, @ModelAttribute Cart cart) {
    try {
      HttpSession session = request.getSession();
      Member member = (Member) session.getAttribute("loginUser");
      cart.setMemberId(member.getMemberId());
      if (member != null) {
        int count = uStoreService.checkProductInCart(cart); // 장바구니에 같은 상품 있는지 체크
        if (count == 0) {
          int result = uStoreService.addNewProductToCart(cart); // 장바구니에 새로운 상품 담기
        } else {
          int result = uStoreService.modifyProductCountInCart(cart); // 장바구니에 있는 상품을 담으면 해당 상품 수량 변경
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }

  /**
   * 상품 상세 페이지
   * 
   * @param productNo
   * @param mv
   * @return
   */
  @RequestMapping(value = "/store/detail.yh")
  public ModelAndView storeDetail(int productNo, ModelAndView mv) {
    try {
      Product product = uStoreService.printOneProduct(productNo);
      product.toString(); // vc
      mv.addObject("product", product);
      mv.setViewName("user/store/storeDetail");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mv;
  }

  /**
   * 장바구니 페이지
   * 
   * @param request
   * @param mv
   * @return
   */
  @RequestMapping(value = "/store/cart.yh")
  public ModelAndView storeCartView(HttpServletRequest request, ModelAndView mv) {
    try {
      HttpSession session = request.getSession();
      Member member = (Member) session.getAttribute("loginUser");
      if (member != null) {
        List<Cart> cartList = uStoreService.printMyCartList(member.getMemberId());
        cartList.get(0).toString();
        mv.addObject("cartList", cartList);
        mv.setViewName("user/store/storeCart");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mv;
  }

  // 스토어 결제 완료 View
  @RequestMapping(value = "/store/complete.yh")
  public ModelAndView storeComplete(ModelAndView mv) {
    mv.setViewName("user/store/storeComplete");
    return mv;
  }

}
