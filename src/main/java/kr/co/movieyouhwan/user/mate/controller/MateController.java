package kr.co.movieyouhwan.user.mate.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.cinema.service.AdminCinemaService;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;
import kr.co.movieyouhwan.user.mate.service.MateService;
import kr.co.movieyouhwan.user.member.domain.Member;

@Controller
public class MateController {
	@Autowired
	private AdminCinemaService aCinemaService;
	
	@Autowired
	private MateService mService;
	
	@RequestMapping(value="/mate/startMate.yh")
	public String startMate() {
		return "user/mate/mateAgree";
	}
	
	/**
	 * 메이트 페이지로 이동
	 * @param mv
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/mate/main.yh")
	public ModelAndView mateListView(ModelAndView mv, HttpServletRequest request) {
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("loginUser");
		String memberId=member.getMemberId();
		
		// 메이트 서비스 가입여부 확인
		int isMate=mService.printMateStatus(memberId);
		
		// 가입했으면 mate list 페이지로 이동
		if(isMate>0) {
			mv.setViewName("user/mate/mateList");
		}
		
		// 아니면 약관 동의 페이지로 이동
		else {
			mv.setViewName("user/mate/mateAgree");
		}
		return mv;
	}
	
	@RequestMapping(value="/mate/modifyMstatusY")
	public ModelAndView modifyMateStatusY(ModelAndView mv, 
			HttpServletRequest request,
			@RequestParam("memberId") String memberId) {
		HttpSession session=request.getSession();
		if((Member)session.getAttribute("loginUser")==null) {
			mv.setViewName("redirect:/member/loginView.yh");
		}
		else {
			int result=mService.modifyMateStatusY(memberId);
			if(result>0) {
				mv.setViewName("redirect:/mate/selectOption.yh");
				// 만약 조건 선택 완료 안하고 다른 페이지로 나가면 메이트 리스트에서 매칭하기를 눌렀을 때 다시 조건 선택부터 하게 해야함
			}
			else {
				
				// 에러처리 해야함
			}
				
		}
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
