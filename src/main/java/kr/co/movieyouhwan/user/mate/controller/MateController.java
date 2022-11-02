package kr.co.movieyouhwan.user.mate.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MateController {
	
	@RequestMapping(value="/mate/startMate.yh")
	public String startMate() {
		return "user/mate/mateAgree";
	}
	
	@RequestMapping(value="/mate/myMateList.yh", method=RequestMethod.POST)
	public ModelAndView mateListView(ModelAndView mv,
			HttpServletRequest request) {
		
		
		
		mv.setViewName("user/mate/mateMyPage");
		return mv;
	}
}
