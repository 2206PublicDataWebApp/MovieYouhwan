package kr.co.movieyouhwan.admin.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminMovieController {
	/**
	 * 영화 등록 화면(관리자)
	 * @return
	 */
	@RequestMapping(value="/admin/adminMovieRegister.yh")
	public String movieRegisterView() {
		return "/admin/movie/adminMovieRegister";
	}
}
