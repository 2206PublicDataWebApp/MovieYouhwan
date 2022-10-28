package kr.co.movieyouhwan.admin.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.member.service.AdminMemberService;
import kr.co.movieyouhwan.user.member.domain.Member;

@Controller
public class AdminMemberController {
	@Autowired
	private AdminMemberService aMemberService;
	/**
	 * 로그인 화면
	 * @return
	 */
	@RequestMapping(value = "/admin/adminLoginView.yh", method = RequestMethod.GET)
	public String adminLoginView() {
		
		return "/admin/main/adminLogin";
	}
	/**
	 * 로그인 기능
	 * ********************redirect 주소 메인이 될 페이지로 변경해야함.*************************
	 * method=RequestMethod.POST로 변경할 것
	 * @return
	 */
	@RequestMapping(value="/admin/login.yh", method=RequestMethod.POST)
	public ModelAndView adminLogin(
			@ModelAttribute Member member
			,ModelAndView mv
			,HttpServletRequest request) {
		try {
			// 회원구분 설정하기
			member.setMemberType("2");
			//member.setMemberYn("Y");
			Member loginAdmin = aMemberService.loginManager(member);
			if(loginAdmin != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginAdmin", loginAdmin);
				mv.setViewName("redirect:/admin/adminCinemaList.yh");
				
			}else {
				mv.addObject("msg", "관리자로 등록되지 않은 회원정보입니다");
				mv.setViewName("common/errorPage");
			}
			
		} catch (Exception e) {
			mv.addObject("msg",e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
}
