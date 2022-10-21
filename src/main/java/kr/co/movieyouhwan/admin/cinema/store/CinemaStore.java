package kr.co.movieyouhwan.admin.cinema.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.user.cinema.domain.Cinema;

public interface CinemaStore {
	// 영화관 등록
	public int insertCinema(SqlSessionTemplate session, Cinema cinema);
	// 영화관 리스트
	public List<Cinema> selectAllCinema(SqlSessionTemplate session);
	// 영화관 상세
	public Cinema selectOneCinema(SqlSessionTemplate session, int cinemaNo);
	// 영화관 삭제
	public int deleteOneCinema(SqlSessionTemplate session, int cinemaNo);
}
