package kr.co.movieyouhwan.admin.cinema.service;

import java.util.List;

import kr.co.movieyouhwan.user.cinema.domain.Cinema;

public interface CinemaService {
	// 영화관 등록
	public int registerCinema(Cinema cinema);
	// 영화관 리스트
	public List<Cinema> printAllCinema();
	// 영화관 상세
	public Cinema printOneCinema(int cinemaNo);
	// 영화관 삭제
	public int removeOneCinema(int cinemaNo);

}
