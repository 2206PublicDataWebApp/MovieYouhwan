package kr.co.movieyouhwan.admin.cinema.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.cinema.service.AdminCinemaService;
import kr.co.movieyouhwan.admin.theater.domain.Theater;
import kr.co.movieyouhwan.admin.theater.service.AdminTheaterService;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;

@Controller
public class AdminCinemaController {
	@Autowired
	private AdminCinemaService aCinemaService;
	@Autowired
	private AdminTheaterService aTheaterService;
	
	/**
	 * 영화관 등록 화면
	 * @return
	 */
	@RequestMapping(value="/admin/adminCinemaRegister.yh", method=RequestMethod.GET)
	public String cinemaRegisterView() {
		// 화면 출력
		return "/admin/cinema/adminCinemaRegister";
	}
	
	/**
	 * 영화관 등록 기능
	 * @param mv
	 * @param cinema
	 * @param uploadFile
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value="/admin/adminCinemaInsert.yh", method=RequestMethod.POST)
	public ModelAndView cinemaRegister(
			ModelAndView mv,
			@ModelAttribute Cinema cinema,
			@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile,
			HttpServletRequest request) throws IllegalStateException, IOException {
		// 단일 이미지 등록
		String cinemaFileName = uploadFile.getOriginalFilename();
		if(!cinemaFileName.equals("")) {
			String root = request.getSession().getServletContext().getRealPath("resources\\images");
			String savePath = root + "\\cinemaLodeImg";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String cinemaFileRename = sdf.format(new Date(System.currentTimeMillis())) + "." + cinemaFileName.substring(cinemaFileName.lastIndexOf(".") + 1);
			File file = new File(savePath);
			if(!file.exists()) {
				file.mkdir();
			}
			uploadFile.transferTo(new File(savePath + "\\" + cinemaFileRename));
			String cinemaFilePath = savePath + "\\" + cinemaFileRename;
			cinema.setCinemaImgName(cinemaFileName);
			cinema.setCinemaImgRename(cinemaFileRename);
			cinema.setCinemaImgPath(cinemaFilePath);
		}
		// 영화관 등록
		int result = aCinemaService.registerCinema(cinema);
		mv.setViewName("redirect:/admin/adminCinemaList.yh");
		return mv;
	}
	
	/**
	 * 영화관 수정 화면
	 * @return
	 */
	@RequestMapping(value="/admin/adminCinemaModify.yh", method=RequestMethod.GET)
	public ModelAndView cinemaModifyView(
			ModelAndView mv,
			@RequestParam("cinemaNo") Integer cinemaNo,
			HttpSession session) {
		Cinema cinema = aCinemaService.printOneCinema(cinemaNo);
		mv.addObject("cinema", cinema);
		mv.setViewName("/admin/cinema/adminCinemaModify");
		return mv;
	}
	
	/**
	 * 영화관 수정 기능
	 * @param mv
	 * @param cinema
	 * @param uploadFile
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/admin/adminCinemaUpdate.yh", method=RequestMethod.POST)
	public ModelAndView cinemaModify(
			ModelAndView mv,
			@ModelAttribute Cinema cinema,
			@RequestParam("cinemaNo") Integer cinemaNo,
			@RequestParam(value="reloadFile", required=false) MultipartFile reloadFile,
			HttpServletRequest request) throws IllegalStateException, IOException {
		String modifyCinemaFileName = reloadFile.getOriginalFilename();
		// 새로운 사진 변경
		if(reloadFile != null && !modifyCinemaFileName.equals("")) {
			String root = request.getSession().getServletContext().getRealPath("resources\\images");
			String savePath = root + "\\cinemaLodeImg";
			File file = new File(savePath + "\\" + cinema.getCinemaImgRename());
			if(file.exists()) {
				file.delete();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String cinemaImgRename = sdf.format(new Date(System.currentTimeMillis())) + "." + modifyCinemaFileName.substring(modifyCinemaFileName.lastIndexOf(".")+1);
			String cinemaImgPath = savePath + "\\" + cinemaImgRename;
			reloadFile.transferTo(new File(cinemaImgPath));
			cinema.setCinemaImgName(modifyCinemaFileName);
			cinema.setCinemaImgRename(cinemaImgRename);
			cinema.setCinemaImgPath(cinemaImgPath);
		} else {
			// 기존 사진 가져오기
			Cinema cinemaOriginal=aCinemaService.printOneCinema(cinema.getCinemaNo());
			cinema.setCinemaImgName(cinemaOriginal.getCinemaImgName());
			cinema.setCinemaImgRename(cinemaOriginal.getCinemaImgRename());
			cinema.setCinemaImgPath(cinemaOriginal.getCinemaImgPath());
		}
		int result = aCinemaService.modifyCinema(cinema);
		mv.setViewName("redirect:/admin/adminCinemaDetail.yh?cinemaNo="+cinemaNo);
		return mv;
	}
	
	/**
	 * 영화관 삭제 기능
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/admin/adminCinemaRemove.yh", method=RequestMethod.GET)
	public String cinemaDataRemove(
			Model model,
			HttpSession session) {
		int cinemaNo = (Integer)session.getAttribute("cinemaNo");
		int result = aCinemaService.removeOneCinema(cinemaNo);
		if(result > 0) {
			session.removeAttribute("cinemaNo");
		}
		return "redirect:/admin/adminCinemaList.yh";
	}

	/**
	 * 영화관 목록 화면
	 * @param mv
	 * @param cinema
	 * @param theater
	 * @return
	 */
	@RequestMapping(value="/admin/adminCinemaList.yh", method=RequestMethod.GET)
	public ModelAndView adminCinemaListView(
			ModelAndView mv,
			@ModelAttribute Cinema cinema,
			@ModelAttribute Theater theater) {
		// 영화관 리스트 (전체)
		List<Cinema> cList = aCinemaService.printAllCinema();
		// 상영관 리스트 (전체)
		List<Theater> tList = aTheaterService.printAllTheater();
		// 화면 출력
		mv.addObject("cList", cList);
		mv.addObject("tList", tList);
		mv.setViewName("admin/cinema/adminCinemaList");
		return mv;
	}

	/**
	 * 영화관 상세 화면
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/admin/adminCinemaDetail.yh", method=RequestMethod.GET)
	public ModelAndView adminCinemaDetailView(
			ModelAndView mv,
			@RequestParam("cinemaNo") Integer cinemaNo,
			HttpSession session) {
		Cinema cinema = aCinemaService.printOneCinema(cinemaNo);
		session.setAttribute("cinemaNo", cinema.getCinemaNo());
		mv.addObject("cinema", cinema);
		mv.setViewName("/admin/cinema/adminCinemaDetail");
		return mv;
	}
}