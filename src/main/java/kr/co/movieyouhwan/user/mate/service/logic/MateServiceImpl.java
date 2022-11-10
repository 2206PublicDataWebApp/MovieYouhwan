package kr.co.movieyouhwan.user.mate.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.user.mate.domain.CinemaOption;
import kr.co.movieyouhwan.user.mate.domain.GenreOption;
import kr.co.movieyouhwan.user.mate.domain.Survey;
import kr.co.movieyouhwan.user.mate.service.MateService;
import kr.co.movieyouhwan.user.mate.store.MateStore;

@Service
public class MateServiceImpl implements MateService{
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private MateStore mStore;

	@Override
	public int printMateStatus(String memberId) {
		int result=mStore.selectMateStatus(session, memberId);
		return result;
	}

	@Override
	public int modifyMateStatusY(String memberId) {
		int result=mStore.updateMateStatusY(session, memberId);
		return result;
	}

	@Override
	public List<CinemaOption> printCinemaOption() {
		List<CinemaOption> cinemaOptionList=mStore.selectCinemaOption(session);
		return cinemaOptionList;
	}

	@Override
	public List<GenreOption> printGenreOption() {
		List<GenreOption> genreOptionList=mStore.selectGenreOption(session);
		return genreOptionList;
	}

	@Override
	public int registerSurvey(Survey survey) {
		int result=mStore.insertSurvey(session, survey);
		return result;
	}

	@Override
	public int printSurveyNo(String memberId) {
		int surveyNo=mStore.selectSurveyNo(session, memberId);
		return surveyNo;
	}

	@Override
	public int registerSurveyGenre(Integer surveyNo, List<String> genreList) {
		int result=mStore.insertSurveyGenre(session,surveyNo,genreList);
		return result;
	}

}
