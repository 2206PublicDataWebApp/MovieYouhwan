package kr.co.movieyouhwan.user.store.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.store.domain.Cart;
import kr.co.movieyouhwan.user.store.domain.Product;
import kr.co.movieyouhwan.user.store.domain.ProductType;
import kr.co.movieyouhwan.user.store.domain.StoreOrder;
import kr.co.movieyouhwan.user.store.service.UserStoreService;

@Controller
public class UserStoreController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserStoreController.class);

	@Autowired
	UserStoreService uStoreService;

	/**
	 * 장바구니에 상품 담기
	 * 
	 * @param request
	 * @param cart
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/store/cart/addProduct.yh", method = RequestMethod.POST)
	public String cartAddProduct(HttpServletRequest request, @ModelAttribute Cart cart) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser");
			if (member != null) {
				cart.setMemberId(member.getMemberId());
				int count = uStoreService.checkProductInCart(cart); // 장바구니에 같은 상품 있는지 체크
				if (count == 0) {
					int result = uStoreService.addNewProductToCart(cart); // 장바구니에 새로운 상품 담기
					if (result < 1) {
						LOGGER.info("장바구니에 새로운 상품 담기 실패");
					}
				} else {
					int productCount = uStoreService.checkProductCount(cart.getCartNo());
					cart.setProductCount(productCount + cart.getProductCount() > 10 ? 10 : cart.getProductCount());
					int result = uStoreService.increaseProductCountUp(cart); // 장바구니에 있는 상품을 담으면 해당 상품 수량 증가
					if (result < 1) {
						LOGGER.info("장바구니에 있는 상품 수량 변경 실패");
					}
				}
			} else {
				return "/member/loginView.yh";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 장바구니에서 상품 수량 변경
	 * 
	 * @param request
	 * @param cart
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/store/cart/modifyProductCount.yh", method = RequestMethod.POST)
	public String cartModifyProductCount(HttpServletRequest request, @ModelAttribute Cart cart) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser");
			if (member != null) {
				cart.setMemberId(member.getMemberId());
				int result = uStoreService.modifyProductCountInCart(cart);
				if (result < 1) {
					LOGGER.info("장바구니에 있는 상품 수량 변경 실패");
				}
			} else {
				return "/member/loginView.yh";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 장바구니에서 상품 삭제
	 * 
	 * @param request
	 * @param cartNoList
	 * @param mv
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/store/cart/deleteProducts.yh", method = RequestMethod.POST)
	public String cartDeleteProducts(HttpServletRequest request,
			@RequestParam("cartNoList[]") List<Integer> cartNoList) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser");
			if (member != null) {
				int result = uStoreService.deleteProductsInCart(cartNoList);
				if (result < 1) {
					return "";
				}
			} else {
				return "/member/loginView.yh";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/store/cart.yh";
	}

	/**
	 * 스토어 페이지
	 * 
	 * @param request
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/store.yh")
	public ModelAndView storeList(HttpServletRequest request, ModelAndView mv) {
		try {
			List<Product> productList = uStoreService.printAllProductList();
			List<ProductType> productTypeList = uStoreService.printAllProductTypeList();
			if (!productList.isEmpty() && !productTypeList.isEmpty()) {
				mv.addObject("productList", productList);
				mv.addObject("productTypeList", productTypeList);
				mv.setViewName("user/store/storeList");
			} else {
				LOGGER.info("상품 리스트 불러오기 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	/**
	 * 상품 상세 페이지
	 * 
	 * @param productNo
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/store/detail.yh")
	public ModelAndView storeDetail(int productTypeNo, int productNo, ModelAndView mv) {
		try {
			Product product = uStoreService.printOneProduct(productNo);
			mv.addObject("productTypeNo", productTypeNo);
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
	public ModelAndView storeCart(HttpServletRequest request, ModelAndView mv) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser");
			if (member != null) {
				List<Cart> cartList = uStoreService.printMyCartList(member.getMemberId());
				if (!cartList.isEmpty()) {
					mv.addObject("cartList", cartList);
				}
				mv.setViewName("user/store/storeCart");
			} else {
				mv.setViewName("redirect:/member/loginView.yh");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	/**
	 * 상품 목록/상세에서 상품 구매
	 * 
	 * @param request
	 * @param productNo
	 * @param cartNoList
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/store/buy.yh", method = RequestMethod.POST)
	public ModelAndView storeBuyOne(HttpServletRequest request, @RequestParam("productNo") Integer productNo,
			@RequestParam(value = "productCount", required = false) Integer productCount, ModelAndView mv) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser");
			if (member != null) {
				Product product = uStoreService.printOneProduct(productNo);
				if (product != null) {
					mv.addObject("product", product);
					if (productCount != null) {
						mv.addObject("productCount", productCount);
					} else {
						mv.addObject("productCount", 1);
					}
				} else {
					LOGGER.info("상품 불러오기 실패");
				}
				mv.setViewName("user/store/storeBuyOne");
			} else {
				mv.setViewName("redirect:/member/loginView.yh");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	/**
	 * 장바구니에서 상품 구매
	 * 
	 * @param request
	 * @param cartNoList
	 * @return
	 */
	@RequestMapping(value = "/store/cart/buy.yh", method = RequestMethod.POST)
	public ModelAndView storeBuyMany(HttpServletRequest request, @RequestParam("cartNo") int[] cartNoArray,
			ModelAndView mv) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser");
			if (member != null) {
				List<Cart> cartList = uStoreService.printCheckedCartList(cartNoArray);
				if (!cartList.isEmpty()) {
					mv.addObject("cartList", cartList);
					mv.setViewName("/user/store/storeBuyMany");
				} else {
					LOGGER.info("장바구니 불러오기 실패");
				}
			} else {
				mv.setViewName("redirect:/member/loginView.yh");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	/**
	 * 스토어 구매자 정보 가져오기
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/store/pay/buyer.yh", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	public String storePayBuyer(HttpServletRequest request) {
		JSONObject jsonObj = new JSONObject(); // JSON 객체 생성 == { } 생성 완료
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser");
			Member buyerInfo = uStoreService.printBuyerInfo(member.getMemberId());
			LOGGER.info(buyerInfo.toString());
			jsonObj.put("memberName", buyerInfo.getMemberName());
			jsonObj.put("memberPhone", buyerInfo.getMemberPhone());
			jsonObj.put("memberEmail", buyerInfo.getMemberEmail());
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObj.toString();
	}

	// 스토어 결제
	@ResponseBody
	@RequestMapping(value = "/store/pay.yh", method = RequestMethod.POST)
	public String storePay(HttpServletRequest request,
			@ModelAttribute StoreOrder storeOrder,
			@RequestParam("paid_at") long paid_at,
			@RequestParam("productNameList[]") List<String> productNameList,
			@RequestParam("productCountList[]") List<Integer> productCountList,
			@RequestParam("status") String status) {
		try {
			storeOrder.setPayDate(new Date(paid_at));
			
			// UNIX Timestamp + 6개월 => expiryDate
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(paid_at);
//			cal.setTime(storeOrder.getPayDate());
			cal.add(Calendar.MONTH, 6);
			storeOrder.setExpiryDate(new Date(cal.getTime().getTime()));
			
			System.out.println(storeOrder.getPayDate() + " ~ " + storeOrder.getExpiryDate());
			
//			long timeStamp = Long.parseLong(paid_at);
//			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
//			Date date = new Date();
//			date.setTime(timeStamp);
//			storeOrder.setPayDate(sdf.format(date));
			
//			LOGGER.info(storeOrder.toString());
			System.out.println(paid_at);
//			LOGGER.info(productNameList.toString());
//			LOGGER.info(productCountList.toString());
//			LOGGER.info(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/store/pay.yh에서 왔다";
	}

	// TODO: 스토어 구매/결제 DB 저장 후
	// 스토어 결제 완료 페이지
	@RequestMapping(value = "/store/pay/complete.yh")
	public ModelAndView storeComplete(ModelAndView mv) {
		mv.setViewName("user/store/storeComplete");
		return mv;
	}

	// 스토어 구매내역 페이지
	@RequestMapping(value = "/mypage/store/history.yh")
	public ModelAndView mypageStoreHistory(HttpServletRequest request, ModelAndView mv) {
		mv.setViewName("user/mypage/storeHistory");
		return mv;
	}

}
