package kr.co.movieyouhwan.user.myPage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.movieyouhwan.user.movie.domain.MovieList;
import kr.co.movieyouhwan.user.myPage.domain.Zzim;
import kr.co.movieyouhwan.user.myPage.store.ZzimDao;

@Controller
public class UserMyZzimController {
	@Autowired 
	private ZzimDao zzimDao;
	
	
	/**
	 * 빈하트 클릭 시 하트 저장
	 */
	@ResponseBody
	@RequestMapping(value = "/saveZzim")
	public MovieList saveZzim(
			@RequestParam int movieNo
			, HttpSession session) {
		Zzim zzim = new Zzim();
		// 무비 넘버 세팅
		zzim.setMovieNo(movieNo);
		// 현재 사용자 아이디
		zzim.setMemberId((String)session.getAttribute("memberId"));
		// +1 하트 갯수 담기
		MovieList movieList = zzimDao.saveZzim(zzim);
		return movieList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/removeZzim")
	public MovieList removeZzim(@RequestParam int movieNo, HttpSession session) {
		Zzim zzim = new Zzim();
		
		// 무비 넘버 세팅
		zzim.setMovieNo(movieNo);
		
		// 찜 누른 사람 nick을 userid로 세팅
		zzim.setMemberId((String) session.getAttribute("memberId"));

	    // -1된 하트 갯수를 담아오기위함
		MovieList movieList = zzimDao.revomeZzim(zzim);

	    return movieList;
	}
}
