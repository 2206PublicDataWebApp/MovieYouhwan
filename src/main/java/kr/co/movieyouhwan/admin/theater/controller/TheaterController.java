package kr.co.movieyouhwan.admin.theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.theater.service.TheaterService;

@Controller
public class TheaterController {
	@Autowired
	private TheaterService tService;
	
	/**
	 * 상영관 등록 화면(관리자)
	 * @return
	 */
	@RequestMapping(value="/admin/adminTheaterRegister.yh", method=RequestMethod.GET)
	public ModelAndView TheaterRegisterView(
			ModelAndView mv) {
		mv.setViewName("/admin/theater/adminTheaterRegister");
		return mv;
	}
}
