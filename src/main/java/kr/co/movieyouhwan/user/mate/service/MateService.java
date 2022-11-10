package kr.co.movieyouhwan.user.mate.service;

import java.util.List;

import kr.co.movieyouhwan.user.mate.domain.CinemaOption;
import kr.co.movieyouhwan.user.mate.domain.GenreOption;

public interface MateService {

	int printMateStatus(String memberId);

	int modifyMateStatusY(String memberId);

	List<CinemaOption> printCinemaOption();

	List<GenreOption> printGenreOption();
	
	
}
