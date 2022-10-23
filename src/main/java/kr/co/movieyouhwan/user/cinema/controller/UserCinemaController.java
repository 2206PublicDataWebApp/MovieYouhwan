package kr.co.movieyouhwan.user.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.cinema.service.AdminCinemaService;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;

@Controller
public class UserCinemaController {
	@Autowired
	private AdminCinemaService aCinemaService;
	
	/**
	 * 상영관 리스트(사용자)
	 * @param mv
	 * @param cinema
	 * @return
	 */
	@RequestMapping(value="/user/userCinemaList.yh", method=RequestMethod.GET)
	public ModelAndView userCinemaListView(
			ModelAndView mv,
			@ModelAttribute Cinema cinema) {
		List<Cinema> cList = aCinemaService.printAllCinema();
		mv.addObject("cList", cList);
		mv.setViewName("user/cinema/userCinemaList");
		return mv;
	}
}
