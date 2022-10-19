package kr.co.movieyouhwan.admin.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CinemaController {
	/**
	 * 영화관 등록 화면(관리자)
	 * @return
	 */
	@RequestMapping(value="/admin/adminCinemaRegister.yh")
	public String CinemaRegisterView() {
		return "/admin/cinema/adminCinemaRegister";
	}
}
