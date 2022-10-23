package kr.co.movieyouhwan.admin.cinema.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.cinema.store.AdminCinemaStore;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;

@Repository
public class AdminCinemaStoreLogic implements AdminCinemaStore {
	// 영화관 등록
	@Override
	public int insertCinema(SqlSessionTemplate session, Cinema cinema) {
		int result = session.insert("CinemaMapper.insertCinema", cinema);
		return result;
	}

	// 영화관 리스트
	@Override
	public List<Cinema> selectAllCinema(SqlSessionTemplate session) {
		List<Cinema> cList = session.selectList("CinemaMapper.selectAllCinema");
		return cList;
	}
	
	// 영화관 상세
	@Override
	public Cinema selectOneCinema(SqlSessionTemplate session, int cinemaNo) {
		Cinema cinema = session.selectOne("CinemaMapper.selectOneCinema", cinemaNo);
		return cinema;
	}
	
	// 영화관 삭제
	@Override
	public int deleteOneCinema(SqlSessionTemplate session, int cinemaNo) {
		int result = session.delete("CinemaMapper.deleteOneCinema", cinemaNo);
		return result;
	}

	// 영화관 수정
	@Override
	public int updateCinema(SqlSessionTemplate session, Cinema cinema) {
		int result = session.update("CinemaMapper.updateCinema", cinema);
		return result;
	}

}
