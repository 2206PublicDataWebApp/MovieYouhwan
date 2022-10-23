package kr.co.movieyouhwan.admin.theater.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.cinema.service.AdminCinemaService;
import kr.co.movieyouhwan.admin.theater.domain.Theater;
import kr.co.movieyouhwan.admin.theater.service.AdminTheaterService;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;

@Controller
public class AdminTheaterController {
	@Autowired
	private AdminCinemaService aCinemaService;
	@Autowired
	private AdminTheaterService aTheaterService;
	
	/**
	 * 상영관 등록 화면
	 * @return
	 */
	@RequestMapping(value="/admin/adminTheaterRegister.yh", method=RequestMethod.GET)
	public ModelAndView TheaterRegisterView(
			ModelAndView mv,
			@ModelAttribute Cinema cinema) {
		List<Cinema> cList = aCinemaService.printAllCinema();
		mv.addObject("cList", cList);
		mv.setViewName("/admin/theater/adminTheaterRegister");
		return mv;
	}
	
	/**
	 * 상영관 등록
	 * @param mv
	 * @param theater
	 * @param cinemaNo
	 * @return
	 */
	@RequestMapping(value="/admin/adminTheaterInsert.yh", method=RequestMethod.POST)
	public ModelAndView TheaterRegister(
			ModelAndView mv,
			@ModelAttribute Theater theater) {
		int result = aTheaterService.registerTheater(theater);
		mv.setViewName("redirect:/admin/adminCinemaList.yh");
		return mv;
	}
	
	/**
	 * 상영관 상세
	 * @param mv
	 * @param theaterNo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/admin/adminTheaterDetail.yh", method=RequestMethod.GET)
	public ModelAndView adminTheaterDetailView(
			ModelAndView mv,
			@RequestParam("theaterNo") Integer theaterNo,
			HttpSession session) {
		Theater theater = aTheaterService.printOneTheater(theaterNo);
		session.setAttribute("theaterNo", theater.getTheaterNo());
		mv.addObject("theater", theater);
		mv.setViewName("/admin/theater/adminTheaterDetail");
		return mv;
	}
	
	/**
	 * 상영관 삭제
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/admin/adminTheaterRemove.yh", method=RequestMethod.GET)
	public String theaterDataRemove(
			Model model,
			HttpSession session) {
		int theaterNo = (Integer)session.getAttribute("theaterNo");
		int result = aTheaterService.removeOneTheater(theaterNo);
		if(result > 0) {
			session.removeAttribute("theaterNo");
		}
		return "redirect:/admin/adminCinemaList.yh";
	}
}
