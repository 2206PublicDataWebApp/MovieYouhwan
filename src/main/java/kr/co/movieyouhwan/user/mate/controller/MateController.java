package kr.co.movieyouhwan.user.mate.controller;


import java.sql.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.user.mate.domain.CinemaOption;
import kr.co.movieyouhwan.user.mate.domain.GenreOption;
import kr.co.movieyouhwan.user.mate.domain.Survey;
import kr.co.movieyouhwan.user.mate.service.MateService;
import kr.co.movieyouhwan.user.member.domain.Member;
import net.datafaker.Faker;

@Controller
public class MateController {
	
	@Autowired
	private MateService mService;
	
	@RequestMapping(value="/mate/startMate.yh")
	public String startMate() {
		Faker faker=new Faker(new Locale("ko"));
		Faker faker_us=new Faker();
		String name=faker.name().name();
		name=name.replace(" ", "");
		System.out.println(name);
		String id=faker.expression("#{regexify '[a-z]{1}[a-z0-9]{5,11}'}");
		System.out.println(id+" length :"+id.length());
		String birth=faker.expression("#{regexify '(19[6-9][0-9]|200[0-3])(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9])'}");
		System.out.println(birth);
		String gender=faker.expression("#{options.option '여','남'}");
		System.out.println(gender);
		String phone=faker.expression("#{regexify '010[0-9]{8}'}");
		System.out.println(phone);
		String email=faker_us.internet().emailAddress();
		System.out.println(email);
		
		
		
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
	public ModelAndView mateSelectOptionView(ModelAndView mv,
			HttpServletRequest request) {
		HttpSession session=request.getSession();
		if((Member)session.getAttribute("loginUser")==null) {
			mv.setViewName("redirect:/member/loginView.yh");
		}
		List<CinemaOption> cinemaOptionList=mService.printCinemaOption();
		List<GenreOption> genreOptionList=mService.printGenreOption();
		if(cinemaOptionList!=null && genreOptionList!=null) {
			mv.addObject("cinemaOptionList", cinemaOptionList);
			mv.addObject("genreOptionList", genreOptionList);
			System.out.println(genreOptionList.toString());
		}
		mv.setViewName("user/mate/mateOption");
		return mv;
	}
	
	@RequestMapping(value="/mate/selectOption.complete.yh", method=RequestMethod.POST)
	public ModelAndView selectOptionComplete(ModelAndView mv, HttpServletRequest request,
			@RequestParam("gender") String gender,
			@RequestParam("age") String age,
			@RequestParam("cinemaName") String cinemaName,
			@RequestParam("genreList") List<String> genreList) {
		
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("loginUser");
		if(member!=null) {
			String memberId=member.getMemberId();
			Survey survey=new Survey(); 
			survey.setGender(gender);
			survey.setAge(age);
			survey.setCinemaName(cinemaName);
			survey.setMemberId(memberId);
			int result=mService.registerSurvey(survey);
			if (result>0) {
				Integer surveyNo=mService.printSurveyNo(memberId);
				if(surveyNo>0) {
					result=mService.registerSurveyGenre(surveyNo, genreList);
				}
			}
		}
		
		
		System.out.println(gender);
		System.out.println(age);
		System.out.println(cinemaName);
		System.out.println(genreList.toString());
		return mv;
	}
	
	
	/**
	 * 메이트 매칭완료
	 * @return
	 */
	@RequestMapping(value="/mate/Complete.yh", method=RequestMethod.GET)
	public String mateCompleteView() {
		return "user/mate/mateComplete";
	}
	
	public void makeFakeData() {
		Faker faker=new Faker();
		String name=faker.name().fullName();
		System.out.println(name);
	}
}
