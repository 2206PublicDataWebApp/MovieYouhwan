package kr.co.movieyouhwan.admin.movie.controller;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.cinema.service.AdminCinemaService;
import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.domain.MovieImg;
import kr.co.movieyouhwan.admin.movie.domain.MovieVideo;
import kr.co.movieyouhwan.admin.movie.service.AdminMovieService;
import kr.co.movieyouhwan.admin.theater.domain.Theater;
import kr.co.movieyouhwan.admin.theater.service.AdminTheaterService;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;

@Controller
public class AdminMovieController {
	@Autowired
	private AdminMovieService aMovieService;
	@Autowired
	private AdminCinemaService aCinemaService;
	@Autowired
	private AdminTheaterService aTheaterService;
	
	/**
	 * 영화 등록 화면
	 * @return
	 */
	@RequestMapping(value="/admin/adminMovieRegister.yh", method=RequestMethod.GET)
	public String movieRegisterView() {
		return "/admin/movie/adminMovieRegister";
	}
	
	/**
	 * 영화 등록 기능
	 * @param mv
	 * @param movie
	 * @param uploadImgFile
	 * @param multipartRequest
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value="/admin/adminMovieInsert.yh", method=RequestMethod.POST)
	public ModelAndView movieRegister(
			ModelAndView mv,
			@ModelAttribute Movie movie,
			@RequestParam(value="uploadImgFile") List<MultipartFile> uploadImgFile,
			@RequestParam(value="uploadVideoFile") List<MultipartFile> uploadVideoFile,
			MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request) throws IllegalStateException, IOException {
		int imgNo = 1;
		int videoNo = 1;
		MovieImg movieImg = null;
		MovieVideo movieVideo = null;
		int result1 = aMovieService.registerMovie(movie);
		for(MultipartFile mf : uploadImgFile) {
			String movieImgName = mf.getOriginalFilename();
			if(!movieImgName.equals("")) {
				String root = request.getSession().getServletContext().getRealPath("resources\\images");
				String savePath = root + "\\movieLodeImg";
				SimpleDateFormat simpledf = new SimpleDateFormat("yyyyMMddHHmmSS");
				String movieImgRename = simpledf.format(new Date(System.currentTimeMillis())) + "." + movieImgName.substring(movieImgName.lastIndexOf(".")+1);
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdir();
				}
				mf.transferTo(new File(savePath+"\\"+movieImgRename));
				String movieImgPath = savePath+"\\"+movieImgRename;
				movieImg = new MovieImg();
				movieImg.setMovieImgName(movieImgName);
				movieImg.setMovieImgRename(movieImgRename);
				movieImg.setMovieImgPath(movieImgPath);
				imgNo = imgNo + 1;
			}
			int result2 = aMovieService.registerMovieImg(movieImg);
		}
		for(MultipartFile mf : uploadVideoFile) {
			String movieVideoName = mf.getOriginalFilename();
			if(!movieVideoName.equals("")) {
				String root = request.getSession().getServletContext().getRealPath("resources\\\\images");
				String savePath = root + "\\movieLodeVideo";
				SimpleDateFormat simpledf = new SimpleDateFormat("yyyyMMddHHmmSS");
				String movieVideoRename = simpledf.format(new Date(System.currentTimeMillis())) + "." + movieVideoName.substring(movieVideoName.lastIndexOf(".")+1);
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdir();
				}
				mf.transferTo(new File(savePath+"\\"+movieVideoRename));
				String movieVideoPath = savePath+"\\"+movieVideoRename;
				movieVideo = new MovieVideo();
				movieVideo.setMovieVideoName(movieVideoName);
				movieVideo.setMovieVideoRename(movieVideoRename);
				movieVideo.setMovieVideoPath(movieVideoPath);
				videoNo = videoNo + 1;
			}
			int result3 = aMovieService.registerMovieVideo(movieVideo);
			mv.setViewName("redirect:/admin/adminMovieList.yh");
		}
		return mv;
	}
	
	/**
	 * 영화 목록 화면
	 * @param mv
	 * @param movie
	 * @return
	 */
	@RequestMapping(value="/admin/adminMovieList.yh", method=RequestMethod.GET)
	public ModelAndView movieListView(
			ModelAndView mv,
			@ModelAttribute Movie movie) {
		List<Movie> mList = aMovieService.printAllMovie();
		mv.addObject("mList", mList);
		mv.setViewName("/admin/movie/adminMovieList");
		return mv;
	}
	
	/**
	 * 영화 리스트 검색 기능
	 * @param mv
	 * @param searchName
	 * @return
	 */
	@RequestMapping(value="/admin/movieSearch.yh", method=RequestMethod.GET)
	public ModelAndView movieSearchList(
			ModelAndView mv,
			@RequestParam("searchName") String searchName) {
		List<Movie> mList = aMovieService.printSearchMovie(searchName);
		if(!mList.isEmpty()) {
			mv.addObject("mList", mList);
		}else {
			mv.addObject("mList", null);
		}
		mv.addObject("searchName", searchName);
		mv.setViewName("/admin/movie/adminMovieList");
		return mv;
	}
	
	/**
	 * 영화 상세 화면
	 * @param mv
	 * @param movieNo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/admin/adminMovieDetail.yh", method=RequestMethod.GET)
	public ModelAndView adminMovieDetailView(
			ModelAndView mv,
			@RequestParam("movieNo") Integer movieNo,
			HttpSession session) {
		Movie movie = aMovieService.printOneMovie(movieNo);
		List<MovieImg> miList = aMovieService.printAllMovieImg(movieNo);
		List<MovieVideo> mvList = aMovieService.printAllMovieVideo(movieNo);
		session.setAttribute("movieNo", movie.getMovieNo());
		mv.addObject("movie", movie);
		mv.addObject("miList", miList);
		mv.addObject("mvList", mvList);
		mv.setViewName("/admin/movie/adminMovieDetail");
		return mv;
	}

	/**
	 * 영화 수정 화면
	 * @param mv
	 * @param movieNo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/admin/adminMovieModify.yh", method=RequestMethod.GET)
	public ModelAndView movieModifyView(
			ModelAndView mv,
			@RequestParam("movieNo") Integer movieNo,
			HttpSession session) {
		Movie movie = aMovieService.printOneMovie(movieNo);
		List<MovieImg> miList = aMovieService.printAllMovieImg(movieNo);
		List<MovieVideo> mvList = aMovieService.printAllMovieVideo(movieNo); 
		mv.addObject("movie", movie);
		mv.addObject("miList", miList);
		mv.addObject("mvList", mvList);
		mv.setViewName("/admin/movie/adminMovieModify");
		return mv;
	}
	
	/**
	 * 영화 수정 기능
	 * @param mv
	 * @param movie
	 * @param reloadImgFile
	 * @param movieImgNoArray
	 * @param movieImgRenameArray
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value="/admin/adminMovieUpdate.yh", method=RequestMethod.POST)
	public ModelAndView movieModify(
			ModelAndView mv,
			@ModelAttribute Movie movie,
			@RequestParam(value="reloadImgFile", required=false) List<MultipartFile> reloadImgFile,
			@RequestParam("movieImgNo") int [] movieImgNoArray,
			@RequestParam("movieImgRename") String[] movieImgRenameArray,
			HttpServletRequest request) throws IllegalStateException, IOException {
		int num = 0;
		MovieImg movieImg = null;
		int result1 = aMovieService.modifyMovieData(movie);
		for(MultipartFile mf : reloadImgFile) {
			String movieImgName = mf.getOriginalFilename();
			if(!movieImgName.equals("")) {
				String root = request.getSession().getServletContext().getRealPath("resources\\images");
				String savePath = root + "\\movieLodeImg";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
				String movieFileRename = movieImgRenameArray[num];
				File file = new File(savePath + "\\" + movieFileRename);
				if(file.exists()) {
					file.delete();
				}
				String movieImgRename = sdf.format(new Date(System.currentTimeMillis())) + num + "." + movieImgName.substring(movieImgName.lastIndexOf(".")+1);
				file = new File(savePath);
				mf.transferTo(new File(savePath + "\\" + movieImgRename));
				String movieImgPath = savePath + "\\" + movieImgRename;
				movieImg = new MovieImg();
				movieImg.setMovieImgName(movieImgName);
				movieImg.setMovieImgRename(movieImgRename);
				movieImg.setMovieImgPath(movieImgPath);
				int movieImgNo = movieImgNoArray[num];
				movieImg.setMovieImgNo(movieImgNo);
				int result2 = aMovieService.modifyMoiveImg(movieImg);
			}
			num = num + 1;
		}
		mv.setViewName("redirect:/admin/adminMovieList.yh");
		return mv;
	}
	
	/**
	 * 영화 수정 (이미지 삭제)
	 * @param mv
	 * @param movieImgNo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/admin/adminMovieImgDelete.yh", method=RequestMethod.POST)
	public ModelAndView movieImgDeleteModify(
			ModelAndView mv,
			@RequestParam("movieImgNo") Integer movieImgNo,
			HttpSession session) {
		int result1 = aMovieService.removeMovieImg(movieImgNo);
		mv.setViewName("redirect:/admin/adminMovieList.yh");
		return mv;
	}

	/**
	 * 영화 삭제 기능
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/admin/adminMovieRemove.yh", method=RequestMethod.GET)
	public String movieDataRemove(
			Model model,
			HttpSession session) {
		int movieNo = (Integer)session.getAttribute("movieNo");
		int result1 = aMovieService.removeOneMovie(movieNo);
		int result2 = aMovieService.removeOneMovieImg(movieNo);
		int result3 = aMovieService.removeOneMovieVideo(movieNo);
		if(result1 > 0 && result2 > 0 && result3 > 0) {
			session.removeAttribute("movieNo");
		}
		return "redirect:/admin/adminMovieList.yh";
	}
	
	/**
	 * 상영 영화 관리
	 * @param mv
	 * @param cinema
	 * @param Theater
	 * @return
	 */
	@RequestMapping(value="/admin/adminMovieTime.yh", method=RequestMethod.GET)
	public ModelAndView adminMovieOpen(
			ModelAndView mv,
			@RequestParam("cinemaNo") Integer cinemaNo,
			@RequestParam("theaterNo") Integer theaterNo) {
		Cinema cinema = aCinemaService.printOneCinema(cinemaNo);
		Theater theater = aTheaterService.printOneTheater(theaterNo);
		List<Cinema> cList = aCinemaService.printAllCinema();
		List<Theater> tList = aTheaterService.printAllTheater();
		List<Movie> mList = aMovieService.printAllMovie();
		mv.addObject("cinema", cinema);
		mv.addObject("theater", theater);
		mv.addObject("cList", cList);
		mv.addObject("tList", tList);
		mv.addObject("mList", mList);
		mv.setViewName("/admin/movie/adminMovieTime");
		return mv;
	}
}
