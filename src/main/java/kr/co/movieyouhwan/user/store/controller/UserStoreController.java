package kr.co.movieyouhwan.user.store.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import kr.co.movieyouhwan.user.store.domain.StoreOrderDetail;
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

	/**
	 * 결제 정보 DB 저장
	 * @param request
	 * @param order
	 * @param paid_at
	 * @param cartNoList
	 * @param productNameList
	 * @param productCountList
	 * @param status
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/store/pay.yh", method = RequestMethod.POST)
	public String storePay(HttpServletRequest request,
			@ModelAttribute StoreOrder order,
			@RequestParam("paid_at") long paid_at,
			@RequestParam(value = "cartNoList[]", required = false) List<Integer> cartNoList,
			@RequestParam(value = "productNameList[]", required = false) List<String> productNameList,
			@RequestParam("productCountList[]") List<Integer> productCountList,
			@RequestParam("status") String status) {
		String orderNo = null;
		try {
			// 주문자 아이디 세팅
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser");
			order.setMemberId(member.getMemberId());

			// 결제일시 세팅 ( UNIX Timestamp (long) -> DateTime (String) )
			SimpleDateFormat pSdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			order.setPayDate(pSdf.format(new Date(paid_at * 1000)));

			// 만료일자 세팅 ( 결제일시 + 6개월 )
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date(paid_at * 1000L));
			cal.add(Calendar.MONTH, 6);
			SimpleDateFormat eSdf = new SimpleDateFormat("yyyy-MM-dd");
			order.setExpiryDate(eSdf.format(cal.getTime()));
			
			switch (status) {
			case "paid":
				order.setAvailability("사용가능");
				int result = uStoreService.registerStoreOrder(order); // INSERT INTO STORE_ORDER_TBL
				orderNo = uStoreService.printOrderNo(order);
				if (result > 0) {
					// TODO: @RequestParam으로 가져온 cartNoList가 비어 있을 경우 null인지 empty인지 궁금
					if (cartNoList == null) {
						// NOTE: 상품 목록/상세 -> 구매 (품목 1개)
						StoreOrderDetail orderDetail = new StoreOrderDetail(orderNo, order.getProductName(), productCountList.get(0));
						uStoreService.registerOneStoreOrderDetail(orderDetail); // INSERT INTO STORE_ORDER_DETAIL_TBL
					} else {
						// NOTE: 장바구니 -> 구매 (품목 1개 또는 N개)
						if (cartNoList.size() == 1) {
							// NOTE: 장바구니 -> 구매 (품목 1개)
							StoreOrderDetail orderDetail = new StoreOrderDetail(orderNo, order.getProductName(), productCountList.get(0));
							uStoreService.registerOneStoreOrderDetail(orderDetail); // INSERT INTO STORE_ORDER_DETAIL_TBL
						} else {
							// NOTE: 장바구니 -> 구매 (품목 N개)
							List<StoreOrderDetail> orderDetailList = new ArrayList<>();
							for (int i = 0; i < cartNoList.size(); i++) {
								orderDetailList.add(new StoreOrderDetail(orderNo, productNameList.get(i), productCountList.get(i)));
							}
							uStoreService.registerManyStoreOrderDetail(orderDetailList); // INSERT INTO STORE_ORDER_DETAIL_TBL
						}
						uStoreService.deleteProductsInCart(cartNoList);
					}
				}
				break;
			case "ready":
				// TODO: 가상 계좌 입금 대기
				break;
			case "failed":
				// 결제 실패
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderNo;
	}

	/**
	 * 결제 완료 페이지
	 * @param request
	 * @param orderNo
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/store/pay/complete.yh")
	public ModelAndView storeComplete(HttpServletRequest request, @RequestParam("orderNo") String orderNo, ModelAndView mv) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser");
			if (member != null) {
				StoreOrder order = uStoreService.printStoreOrder(orderNo);
				if (order != null) {
					mv.addObject("order", order);
				}
			}
			mv.setViewName("user/store/storeComplete");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	/**
	 * 마이페이지 - 스토어 구매내역
	 * @param request
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/mypage/store/history.yh")
	public ModelAndView mypageStoreHistory(HttpServletRequest request, ModelAndView mv) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser");
			if (member != null) {
				List<StoreOrder> orderList = uStoreService.printStoreOrderList(member.getMemberId());
				if (!orderList.isEmpty()) {
					mv.addObject("orderList", orderList);
				}
				mv.setViewName("user/mypage/storeHistory");
			} else {
				mv.setViewName("redirect:/member/loginView.yh");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 마이페이지 - 스토어 구매내역 상세
	 * @param request
	 * @param orderNo
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/mypage/store/detail.yh")
	public ModelAndView mypageStoreDetail(HttpServletRequest request, @RequestParam("orderNo") String orderNo, ModelAndView mv) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser");
			if (member != null) {
				StoreOrder order = uStoreService.printStoreOrder(orderNo);
				List<StoreOrderDetail> orderDetailList = uStoreService.printStoreOrderDetailList(orderNo);
				if (order != null) {
					mv.addObject("order", order);
				}
				if (!orderDetailList.isEmpty()) {
					mv.addObject("orderDetailList", orderDetailList);
				}
				mv.setViewName("user/mypage/storeHistoryDetail");
			} else {
				mv.setViewName("redirect:/member/loginView.yh");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
}
