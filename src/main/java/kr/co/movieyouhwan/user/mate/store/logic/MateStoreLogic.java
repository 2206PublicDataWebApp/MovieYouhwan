package kr.co.movieyouhwan.user.mate.store.logic;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.user.mate.domain.CinemaOption;
import kr.co.movieyouhwan.user.mate.domain.GenreOption;
import kr.co.movieyouhwan.user.mate.domain.Survey;
import kr.co.movieyouhwan.user.mate.store.MateStore;

@Repository
public class MateStoreLogic implements MateStore {

	@Override
	public int selectMateStatus(SqlSessionTemplate session, String memberId) {
		int result=session.selectOne("MateMapper.selectMateStatus", memberId);
		return result;
	}

	@Override
	public int updateMateStatusY(SqlSessionTemplate session, String memberId) {
		int result=session.update("MateMapper.updateMateStatusY", memberId);
		return result;
	}

	@Override
	public List<CinemaOption> selectCinemaOption(SqlSessionTemplate session) {
		List<CinemaOption> cinemaOptionList=session.selectList("MateMapper.selectCinemaOption");
		return cinemaOptionList;
	}

	@Override
	public List<GenreOption> selectGenreOption(SqlSessionTemplate session) {
		List<GenreOption> genreOptionList=session.selectList("MateMapper.selectGenreOption");
		return genreOptionList;
	}

	@Override
	public int insertSurvey(SqlSessionTemplate session, Survey survey) {
		int result=session.insert("MateMapper.insertSurvey", survey);
		return result;
	}

	@Override
	public int selectSurveyNo(SqlSessionTemplate session, String memberId) {
		int surveyNo=session.selectOne("MateMapper.selectSurveyNo", memberId);
		return surveyNo;
	}

	@Override
	public int insertSurveyGenre(SqlSessionTemplate session, Integer surveyNo, List<String> genreList) {
		HashMap<String, Object> param=new HashMap<>();
		param.put("genreList", genreList);
		param.put("surveyNo", surveyNo);
		
		int result=session.insert("MateMapper.insertSurveyGenre", param);
		return result;
	}

}
