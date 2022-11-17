package kr.co.movieyouhwan.admin.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.member.service.AdminMemberService;
import kr.co.movieyouhwan.user.member.domain.Member;

@Controller
public class AdminMemberController {
	@Autowired
	private AdminMemberService aMemberService;
	/**
	 * 로그인 화면
	 * @return
	 */
	@RequestMapping(value="/admin.yh", method=RequestMethod.GET)
	public String adminLoginView() {
		
		return "/admin/main/adminLogin";
	}
	/**
	 * 로그인 기능
	 * ********************redirect 주소 메인이 될 페이지로 변경해야함.*************************
	 * method=RequestMethod.POST로 변경할 것
	 * @return
	 */
	@RequestMapping(value="/admin/login.yh", method=RequestMethod.POST)
	public ModelAndView adminLogin(
			@ModelAttribute Member member
			,ModelAndView mv
			,HttpServletRequest request) {
		try {
			// 회원구분 설정하기
			member.setMemberType("2");
			//member.setMemberYn("Y");
			Member loginAdmin = aMemberService.loginManager(member);
			if(loginAdmin != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginAdmin", loginAdmin);
				mv.setViewName("redirect:/admin/adminCinemaList.yh");
				
			}else {
				mv.addObject("msg", "관리자로 등록되지 않은 회원정보입니다");
				mv.setViewName("common/errorPage");
			}
			
		} catch (Exception e) {
			mv.addObject("msg",e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	/**
	 * 회원목록
	 * @param mv
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/admin/memberList.yh", method = RequestMethod.GET)
	public ModelAndView adminList(
			ModelAndView mv
			,@RequestParam(value = "page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = aMemberService.getTotalCount("","");	// 전체 게시물 개수
		int listLimit = 20;	// 페이지당 보여질 게시물의 개수
		int naviLimit = 5;	// 보여질 페이지의 개수
		int maxPage;	// 전체 페이지 수
		int startNavi;	// 페이징 바 시작 번호
		int endNavi;	// 페이징 바 마지막 번호
		maxPage = (int)((double)totalCount/listLimit + 0.9);
		startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		List<Member> uMemberList = aMemberService.printAllMember(currentPage, listLimit);
		if(!uMemberList.isEmpty()) {
			mv.addObject("urlVal", "memberList");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("uMemberList", uMemberList);
		}
		mv.setViewName("/admin/member/adminMemberList");
		return mv;
	}
	
	/**
	 * 게시글 조건 검색
	 * @param mv
	 * @param searchCondition
	 * @param searchValue
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/admin/memberSearch.yh", method = RequestMethod.GET)
	public ModelAndView memberSearchList(
			ModelAndView mv
			,@RequestParam("searchCondition")String searchCondition
			,@RequestParam("searchValue") String searchValue
			,@RequestParam(value = "page", required = false)Integer page) {
		try {
			int currentPage = (page != null) ? page : 1;
			int totalCount = aMemberService.getTotalCount(searchCondition, searchValue);
			int listLimit = 20;
			int naviLimit = 5;	
			int maxPage;	
			int startNavi;	
			int endNavi;	
			maxPage = (int)((double)totalCount/listLimit + 0.9);
			startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
			endNavi = startNavi + naviLimit - 1;
			if(maxPage < endNavi) {
				endNavi = maxPage;
			}
			List<Member> uMemberList = aMemberService.selectOneMember(searchCondition, searchValue, currentPage, listLimit);
			if(!uMemberList.isEmpty()) {
				mv.addObject("uMemberList", uMemberList);
			}else {
				mv.addObject("uMemberList", null);
			}
			mv.addObject("urlVal", "serach");
			mv.addObject("searchCondition", searchCondition);
			mv.addObject("searchValue", searchValue);
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.setViewName("/admin/member/adminMemberList");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	
}
