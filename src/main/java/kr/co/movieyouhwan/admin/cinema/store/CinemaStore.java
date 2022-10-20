package kr.co.movieyouhwan.admin.cinema.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.user.cinema.domain.Cinema;

public interface CinemaStore {
	// 영화관 등록(관리자)
	public int insertCinema(SqlSessionTemplate session, Cinema cinema);
	// 영화관 리스트(관리자)
	List<Cinema> selectAllCinema(SqlSessionTemplate session);
}
