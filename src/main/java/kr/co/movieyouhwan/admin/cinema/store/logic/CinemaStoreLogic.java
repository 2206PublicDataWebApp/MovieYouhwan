package kr.co.movieyouhwan.admin.cinema.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.cinema.store.CinemaStore;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;

@Repository
public class CinemaStoreLogic implements CinemaStore {
	// 영화관 등록(관리자)
	@Override
	public int insertCinema(SqlSessionTemplate session, Cinema cinema) {
		int result = session.insert("CinemaMapper.insertCinema", cinema);
		return result;
	}

	// 영화관 리스트(관리자)
	@Override
	public List<Cinema> selectAllCinema(SqlSessionTemplate session) {
		List<Cinema> cList = session.selectList("CinemaMapper.selectAllCinema");
		return cList;
	}

}
