package kr.co.movieyouhwan.admin.cinema.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.cinema.service.CinemaService;
import kr.co.movieyouhwan.admin.cinema.store.CinemaStore;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;

@Service
public class CinemaServiceImpl implements CinemaService{
	@Autowired
	private CinemaStore cStore;
	@Autowired
	private SqlSessionTemplate session;
	
	// 영화관 등록(관리자)
	@Override
	public int registerCinema(Cinema cinema) {
		int result = cStore.insertCinema(session, cinema);
		return result;
	}
	
	// 영화관 리스트(관리자)
	@Override
	public List<Cinema> printAllCinema() {
		List<Cinema> cList = cStore.selectAllCinema(session);
		return cList;
	}
}
