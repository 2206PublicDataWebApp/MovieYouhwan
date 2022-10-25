package kr.co.movieyouhwan.admin.theater.service;

import java.util.List;

import kr.co.movieyouhwan.admin.theater.domain.Theater;

public interface AdminTheaterService {
	// 상영관 등록
	public int registerTheater(Theater theater);
	// 상영관 리스트
	public List<Theater> printAllTheater();
	// 상영관 상세
	public Theater printOneTheater(Integer theaterNo);
	// 상영관 수정
	public int modifyTheater(Theater theater);
	// 상영관 삭제
	public int removeOneTheater(int theaterNo);
}
