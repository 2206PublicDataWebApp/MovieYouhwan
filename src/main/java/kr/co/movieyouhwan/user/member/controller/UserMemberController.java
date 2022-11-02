package kr.co.movieyouhwan.user.member.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.member.service.UserMemberService;
@Controller
public class UserMemberController {
	@Autowired
	private UserMemberService uMemberService;
	/**
	 * 회원가입 화면
	 * 구현 중
	 * @return
	 */
	@RequestMapping(value="/member/joinView.yh", method=RequestMethod.GET)
	public String memberJoinView() {
		return "/user/member/memberJoin";
	}
	/**
	 * 회원가입
	 * @param member
	 * @param mv
	 * @param uploadFile
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/member/join.yh",method = RequestMethod.POST)
	public ModelAndView memberJoin(
			@ModelAttribute Member member
			, ModelAndView mv
			, @RequestParam(value="uploadFile", required = false) MultipartFile uploadFile
			, HttpServletRequest request) throws IllegalStateException, IOException {
		String memberProfileName = uploadFile.getOriginalFilename();  // 단일 이미지 등록
		if (!memberProfileName.equals("")) {
			String root = request.getSession().getServletContext().getRealPath("resources\\images");
			String savePath = root + "\\userProfileImg";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String memberProfileRename = sdf.format(new Date(System.currentTimeMillis())) + "." + memberProfileName.substring(memberProfileName.lastIndexOf(".") + 1);
			File file = new File(savePath);
			if(!file.exists()) {
				file.mkdir();
			}
			uploadFile.transferTo(new File(savePath + "\\" + memberProfileRename));
			String memberProfilePath = savePath + "\\" + memberProfileRename;
			member.setMemberImgName(memberProfileName);
			member.setMemberImgRename(memberProfileRename);
			member.setMemberImgRename(memberProfilePath);
		}
		int result = uMemberService.registerMember(member);
		mv.setViewName("redirect:/member/loginSuccess.yh");
		
		return mv;
	}
	
	/**
	 * 로그인 화면
	 * @return
	 */
	@RequestMapping(value = "/member/loginView.yh", method = RequestMethod.GET)
	public String memberLoginView() {
		return "/user/member/memberLogin";
	}
	/**
	 * 로그인..
	 * @param member
	 * @param mv
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/member/login.yh", method=RequestMethod.POST)
	public ModelAndView memberLogin(
			@ModelAttribute Member member
			,ModelAndView mv
			,HttpServletRequest request) {
		try {
			// 회원구분 설정하기
			member.setMemberType("1");
			//member.setMemberYn("Y");
			Member loginUser = uMemberService.loginMember(member);
			if(loginUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				mv.setViewName("redirect:/home.yh");
				
			}else {
				mv.addObject("msg", "잘못된 입력입니다.");
				mv.setViewName("redirect:/member/loginError.yh");
			}
			
		} catch (Exception e) {
			mv.addObject("msg",e.toString());
			mv.setViewName("user/loginError");
		}
		return mv;
	}
	
	
	/**
	 * 로그인 실패시
	 */
	@RequestMapping(value = "/member/loginError.yh", method = RequestMethod.GET)
	public String loginError() {
		return "/user/member/loginError";
	}
	
	/**
	 * 로그아웃
	 * @param request
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/member/logout.yh", method = RequestMethod.GET)
	public ModelAndView memberLogout(
			HttpServletRequest request
			,ModelAndView mv) {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
			mv.setViewName("redirect:/home.yh");
		}else {
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	/**
	 * 아이디 중복 체크
	 * @param memberId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/member/idSearch.yh", method= RequestMethod.GET)
	public String duplicateIdCheck(@RequestParam("memberId") String memberId) {
		// 데이터가 있으면 객체 or 1 or true
		// 데이터가 없으면  null or 0 or false
		System.out.println(memberId);
		int result = uMemberService.checkDupId(memberId);
		return String.valueOf(result);
	}
	
	
	/**
	 * 마이페이지 
	 * ----- 탑 메뉴(포인트, 메이트)
	 * ----- 메뉴 탭
	 * @param request
	 * @param mv
	 * @return
	 */
	
	  @RequestMapping(value = "/member/profileModify.yh", method = RequestMethod.GET) 
	  public ModelAndView showMyPage(
		  @ModelAttribute Member member
		  ,ModelAndView mv) { 
		  try { 
			int result = uMemberService.modifyMember(member);
			if(result > 0) {
				mv.setViewName("redirect:/home.kh");
			}else {
				mv.addObject("msg", "회원 정보 수정 실패");
				mv.setViewName("common/errorPage");
			}
		  }catch (Exception e) { 
			  mv.addObject("msg",e.getMessage()).setViewName("common/errorPage"); 
			  } 
		  return mv;
		  } 
	  
		
	 
	
	
	/**
	 * 아이디 찾기
	 * @return
	 */
	@RequestMapping(value="/member/findId.yh", method=RequestMethod.GET)
	public String findId() {
		return "/user/member/findId";
	}
	
	/**
	 * 비밀번호 찾기
	 * @return
	 */
	@RequestMapping(value="/member/findPassword.yh", method=RequestMethod.GET)
	public String findPassword() {
		return "/user/member/findPassword";
	}
	
	/*
	 * @RequestMapping(value = "/member/myPoint.yh", method = RequstMethod.GET)
	 * public ModelAndView pointHistoryView( HttpServletRequest request,
	 * 
	 * @RequestParam(value = ""))
	 */
	
	
}

