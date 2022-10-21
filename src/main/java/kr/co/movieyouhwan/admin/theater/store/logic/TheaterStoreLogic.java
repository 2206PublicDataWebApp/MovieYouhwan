package kr.co.movieyouhwan.admin.theater.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.theater.domain.Theater;
import kr.co.movieyouhwan.admin.theater.store.TheaterStore;

@Repository
public class TheaterStoreLogic implements TheaterStore {
	// 상영관 등록
	@Override
	public int insertTheater(SqlSessionTemplate session, Theater theater) {
		int result = session.insert("TheaterMapper.insertTheater", theater);
		return result;
	}
}
