package kr.co.movieyouhwan.user.mate.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.cinema.service.AdminCinemaService;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;

@Controller
public class MateController {
	@Autowired
	private AdminCinemaService aCinemaService;
	
	@RequestMapping(value="/mate/startMate.yh")
	public String startMate() {
		return "user/mate/mateAgree";
	}
	
	@RequestMapping(value="/mate/main.yh")
	public ModelAndView mateListView(ModelAndView mv) {
		
		
		
		mv.setViewName("user/mate/mateList");
		return mv;
	}
	
	//method=RequestMethod.POST , HttpServletRequest request
	
	@RequestMapping(value="/mate/selectOption.yh")
	public String mateSelectOptionView() {
		return "user/mate/mateOption";
	}
	
	/**
	 * 메이트 매칭완료
	 * @return
	 */
	@RequestMapping(value="/mate/Complete.yh", method=RequestMethod.GET)
	public String mateCompleteView() {
		return "user/mate/mateComplete";
	}
}
