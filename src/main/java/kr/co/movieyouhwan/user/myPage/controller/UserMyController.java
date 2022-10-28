package kr.co.movieyouhwan.user.myPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserMyController {
	/**
	 * 마이페이지 상단
	 * 기능 구현 전
	 * @return
	 */
	@RequestMapping(value="/my/myPageMain.yh", method=RequestMethod.GET)
	public String myPage() {
		return"/user/mypage/myPageMain";
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
}
