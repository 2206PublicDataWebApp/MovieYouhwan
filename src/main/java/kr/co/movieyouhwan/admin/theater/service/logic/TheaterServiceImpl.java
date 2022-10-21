package kr.co.movieyouhwan.admin.theater.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.theater.domain.Theater;
import kr.co.movieyouhwan.admin.theater.service.TheaterService;
import kr.co.movieyouhwan.admin.theater.store.TheaterStore;

@Service
public class TheaterServiceImpl implements TheaterService{
	@Autowired
	private TheaterStore tStore;
	@Autowired
	private SqlSessionTemplate session;
	
	// 상영관 등록
	@Override
	public int registerTheater(Theater theater) {
		int result = tStore.insertTheater(session, theater);
		return result;
	}

}
