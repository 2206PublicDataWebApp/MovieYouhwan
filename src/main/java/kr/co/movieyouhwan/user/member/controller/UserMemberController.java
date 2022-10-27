package kr.co.movieyouhwan.user.member.controller;

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
import kr.co.movieyouhwan.user.member.service.UserMemberService;
@Controller
public class UserMemberController {
	@Autowired
	private UserMemberService uMemberService;
	/**
	 * 회원가입 화면
	 * 구현 중
	 * @return
	 */
	@RequestMapping(value="/member/joinView.yh", method=RequestMethod.GET)
	public String memberJoinView() {
		return "/user/member/memberJoin";
	}
	/**
	 * 
	 * @param member
	 * @param mv
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/member/join.yh",method = RequestMethod.POST)
	public ModelAndView memberJoin(
			@ModelAttribute Member member,
			ModelAndView mv) {
		uMemberService.registerMember(member);
		mv.setViewName("redirect:/member/loginSuccess.yh");
		return mv;
	}
	
	/**
	 * 로그인
	 * 구현 중
	 * method=RequestMethod.POST로 변경할 것
	 * @return
	 */
	@RequestMapping(value="/member/login.yh", method=RequestMethod.POST)
	public ModelAndView memberLogin(
			@ModelAttribute Member member
			,ModelAndView mv
			,HttpServletRequest request) {
		try {
			Member loginUser = uMemberService.loginMember(member);
			if(loginUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				mv.setViewName("redirect:/home.yh");
				
			}else {
				mv.addObject("msg", "잘못된 입력입니다.");
				mv.setViewName("common/errorPage");
			}
			
		} catch (Exception e) {
			mv.addObject("msg",e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	/**
	 * 로그인 후 이동할 페이지
	 * 안됨 아직.
	 * 
	 */
	@RequestMapping(value = "/member/loginSuccess.yh", method = RequestMethod.GET)
	public String memberJoinSuccess() {
		return "/user/member/joinSuccess";
	}
}

