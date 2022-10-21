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
	
	// 영화관 등록
	@Override
	public int registerCinema(Cinema cinema) {
		int result = cStore.insertCinema(session, cinema);
		return result;
	}
	
	// 영화관 리스트
	@Override
	public List<Cinema> printAllCinema() {
		List<Cinema> cList = cStore.selectAllCinema(session);
		return cList;
	}
	
	// 영화관 상세
	@Override
	public Cinema printOneCinema(int cinemaNo) {
		Cinema cinema = cStore.selectOneCinema(session, cinemaNo);
		return cinema;
	}
	
	// 영화관 삭제
	@Override
	public int removeOneCinema(int cinemaNo) {
		int result = cStore.deleteOneCinema(session, cinemaNo);
		return result;
	}
}
