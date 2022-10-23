package kr.co.movieyouhwan.admin.theater.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.admin.theater.domain.Theater;

public interface AdminTheaterStore {
	// 상영관 등록
	public int insertTheater(SqlSessionTemplate session, Theater theater);
	// 상영관 리스트
	public List<Theater> selectAllTheater(SqlSessionTemplate session);
	// 상영관 상세
	public Theater selectOneTheater(SqlSessionTemplate session, Integer theaterNo);
	// 상영관 삭제
	public int deleteOneTheater(SqlSessionTemplate session, int theaterNo);
}
