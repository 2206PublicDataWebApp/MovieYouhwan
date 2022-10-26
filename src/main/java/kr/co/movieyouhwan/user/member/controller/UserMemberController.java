package kr.co.movieyouhwan.user.member.controller;

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
	 * 기능 구현 전
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
		return mv;
	}
	
	/**
	 * 로그인 페이지 
	 * 기능 구현 전
	 * method=RequestMethod.POST로 변경할 것
	 * @return
	 */
	@RequestMapping(value="/member/login.yh", method=RequestMethod.GET)
	public String memberLogin() {
		return "/user/member/memberLogin";
	}
}

