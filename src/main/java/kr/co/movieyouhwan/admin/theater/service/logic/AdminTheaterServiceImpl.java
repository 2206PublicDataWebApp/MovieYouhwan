package kr.co.movieyouhwan.admin.theater.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.theater.domain.Theater;
import kr.co.movieyouhwan.admin.theater.service.AdminTheaterService;
import kr.co.movieyouhwan.admin.theater.store.AdminTheaterStore;

@Service
public class AdminTheaterServiceImpl implements AdminTheaterService{
	@Autowired
	private AdminTheaterStore aTheaterStore;
	@Autowired
	private SqlSessionTemplate session;
	
	// 상영관 등록
	@Override
	public int registerTheater(Theater theater) {
		int result = aTheaterStore.insertTheater(session, theater);
		return result;
	}
	
	// 상영관 리스트
	@Override
	public List<Theater> printAllTheater() {
		List<Theater> tList = aTheaterStore.selectAllTheater(session);
		return tList;
	}

	// 상영관 상세
	@Override
	public Theater printOneTheater(Integer theaterNo) {
		Theater theater = aTheaterStore.selectOneTheater(session, theaterNo);
		return theater;
	}
	
	// 영화관 삭제
	@Override
	public int removeOneTheater(int theaterNo) {
		int result = aTheaterStore.deleteOneTheater(session, theaterNo);
		return result;
	}

}
