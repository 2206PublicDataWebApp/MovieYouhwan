package kr.co.movieyouhwan.admin.theater.store;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.admin.theater.domain.Theater;

public interface TheaterStore {
	// 상영관 등록
	public int insertTheater(SqlSessionTemplate session, Theater theater);

}
