package kr.co.movieyouhwan.admin.cinema.service;

import java.util.List;

import kr.co.movieyouhwan.user.cinema.domain.Cinema;

public interface CinemaService {
	// 영화관 등록(관리자)
	public int registerCinema(Cinema cinema);
	// 영화관 리스트(관리자)
	public List<Cinema> printAllCinema();

}
