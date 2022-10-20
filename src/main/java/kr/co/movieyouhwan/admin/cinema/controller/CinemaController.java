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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.cinema.service.CinemaService;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;

@Controller
public class CinemaController {
	@Autowired
	private CinemaService cService;
	
	/**
	 * 영화관 등록 화면(관리자)
	 * @return
	 */
	@RequestMapping(value="/admin/adminCinemaRegister.yh", method=RequestMethod.GET)
	public String CinemaRegisterView() {
		return "/admin/cinema/adminCinemaRegister";
	}
	
	/**
	 * 영화관 등록(관리자)
	 * @param mv
	 * @param cinema
	 * @param address1
	 * @param address2
	 * @param uploadFile
	 * @param multipartRequest
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/admin/adminCinemaInsert.yh", method=RequestMethod.POST)
	public ModelAndView CinemaRegister(
			ModelAndView mv,
			@ModelAttribute Cinema cinema,
			@RequestParam("cinemaAddress1") String address1,
			@RequestParam("cinemaAddress2") String address2,
			@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile,
			HttpServletRequest request) throws IllegalStateException, IOException {
		cinema.setCinemaAddress(address1 + "," + address2); // 도로명주소 + 상세주소 합치기
		String cinemaFileName = uploadFile.getOriginalFilename(); // 단일 이미지 등록
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
		int result = cService.registerCinema(cinema);
		mv.setViewName("redirect:/admin/adminCinemaList.yh");
		return mv;
	}
	
	/**
	 * 영화관 목록 화면(관리자)
	 * @return
	 */
	@RequestMapping(value="/admin/adminCinemaList.yh", method=RequestMethod.GET)
	public ModelAndView CinemaListView(
			ModelAndView mv,
			@ModelAttribute Cinema cinema) {
		List<Cinema> cList = cService.printAllCinema();
		mv.addObject("cList", cList);
		mv.setViewName("admin/cinema/adminCinemaList");
		return mv;
	}
}