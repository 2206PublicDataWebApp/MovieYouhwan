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
	 * 로그인 페이지 
	 * 기능 구현 전
	 * method=RequestMethod.POST로 변경할 것
	 * @return
	 */
	@RequestMapping(value="/member/login.yh", method=RequestMethod.GET)
	public String memberLogin() {
		return "/user/member/memberLogin";
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
}
