package kr.co.movieyouhwan.user.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.movieyouhwan.user.member.service.MemberService;
@Controller
public class MemberController {
	@Autowired
	private MemberService mService;

	@RequestMapping(value="/member/joinView.yh", method=RequestMethod.GET)
	public String memberJoinView() {
		return "/user/member/memberJoin";
	}
	
//	@RequestMapping(value = "/member/register.yh", method = RequestMethod.POST)
//	public ModelAndView
	
	@RequestMapping(value="/member/login.yh", method=RequestMethod.GET)	// POST로 변경할거임
	public String memberLogin() {
		return "/user/member/memberLogin";
	}
}
