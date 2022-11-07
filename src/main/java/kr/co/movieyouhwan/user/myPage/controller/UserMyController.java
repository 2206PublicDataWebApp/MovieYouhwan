package kr.co.movieyouhwan.user.myPage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.myPage.service.UserMyService;

@Controller
public class UserMyController {
	@Autowired 
	private UserMyService uMyService;
	
	/**
	 * 마이페이지 
	 * ----- 탑 메뉴(포인트, 메이트)
	 * ----- 메뉴 탭
	 * @param request
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/my/myPageMain.yh", method = RequestMethod.GET)
	public ModelAndView showMyPage(HttpServletRequest request, ModelAndView mv) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member)session.getAttribute("loginUser");
			String memberId = member.getMemberId();
			Member uMyOne = uMyService.printOneById(memberId);
			mv.addObject("member", uMyOne);
			mv.setViewName("user/mypage/myPageMain");
			System.out.println("ddd");
			System.out.println(uMyOne.getMemberId());
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;
	}
		
	/**
	 * 마이페이지 상단
	 * 기능 구현 전
	 * @return
	 */
	@RequestMapping(value="/my/myPage.yh", method=RequestMethod.GET)
	public String myPageView() {
		return"/user/mypage/myPage";
	}
	/**
	 * 관람내역 
	 * 기능 구현 전
	 * @return
	 */
	@RequestMapping(value="/my/moviewHistory.yh", method=RequestMethod.GET)
	public String movieHistory() {
		return"/user/mypage/movieHistory";
	}
	/**
	 * 찜한 영화
	 * @return
	 */
	@RequestMapping(value="/my/zzim.yh", method=RequestMethod.GET)
	public String movieZzim() {
		return"/user/mypage/zzim";
	}
	/**
	 * 포인트 조회
	 * @return
	 */
	@RequestMapping(value="/my/point.yh", method=RequestMethod.GET)
	public String point() {
		return"/user/mypage/point";
	}
	/**
	 * 회원정보 수정 화면
	 * @param request
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/my/editMemberInfo.yh", method = RequestMethod.GET)
	public ModelAndView showMyEditPage(
			HttpServletRequest request
			, ModelAndView mv) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member)session.getAttribute("loginUser");
			String memberId = member.getMemberId();
			Member uMyOne = uMyService.printOneByDetailId(memberId);
			mv.addObject("member", uMyOne);
			mv.setViewName("user/mypage/memberModify");
		}catch (Exception e) {
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;
	}
	/**
	 * 회원정보 수정
	 * @param member
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/my/modify.yh", method = RequestMethod.POST)
	public ModelAndView modifyMember(
			@ModelAttribute Member member
			,ModelAndView mv) {
		try {
			int result = uMyService.modifyMember(member);
			if(result > 0) {
				mv.setViewName("/my/editMemeberSuccess.yh");
			}else {
				mv.addObject("msg", "회원정보 수정을 실패했습니다.");
				mv.setViewName("common/errorPage");
					// 에러페이지 어떻게 하지 
			}
		}catch (Exception e) {
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 회원정보 수정 후 화면
	 * @return
	 */
	@RequestMapping(value = "/my/editMemeberSuccess.yh", method = RequestMethod.GET)
	public String editSuccess() {
		return "/user/mypage/editMemberInfoSuccess";
	}
	
}
