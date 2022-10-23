package kr.co.movieyouhwan.admin.theater.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.theater.domain.Theater;
import kr.co.movieyouhwan.admin.theater.store.AdminTheaterStore;

@Repository
public class AdminTheaterStoreLogic implements AdminTheaterStore {
	// 상영관 등록
	@Override
	public int insertTheater(SqlSessionTemplate session, Theater theater) {
		int result = session.insert("TheaterMapper.insertTheater", theater);
		return result;
	}
	
	// 상영관 리스트
	@Override
	public List<Theater> selectAllTheater(SqlSessionTemplate session) {
		List<Theater> tList = session.selectList("TheaterMapper.selectAllTheater");
		return tList;
	}
	
	// 상영관 상세
	@Override
	public Theater selectOneTheater(SqlSessionTemplate session, Integer theaterNo) {
		Theater theater = session.selectOne("TheaterMapper.selectOneTheater", theaterNo);
		return theater;
	}

	// 상영관 삭제
	@Override
	public int deleteOneTheater(SqlSessionTemplate session, int theaterNo) {
		int result = session.delete("TheaterMapper.deleteOneTheater", theaterNo);
		return result;
	}
}
