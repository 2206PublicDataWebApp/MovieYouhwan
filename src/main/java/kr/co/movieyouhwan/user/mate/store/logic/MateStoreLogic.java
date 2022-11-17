package kr.co.movieyouhwan.user.mate.store.logic;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.user.mate.domain.CinemaOption;
import kr.co.movieyouhwan.user.mate.domain.GenreOption;
import kr.co.movieyouhwan.user.mate.domain.Survey;
import kr.co.movieyouhwan.user.mate.domain.SurveyGenre;
import kr.co.movieyouhwan.user.mate.store.MateStore;
import kr.co.movieyouhwan.user.member.domain.Member;

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

	@Override
	public int insertDummyMember(SqlSessionTemplate session, List<Member> dummyMemberList) {
		int result=session.insert("MateMapper.insertMemberList", dummyMemberList);
		return result;
	}

	@Override
	public int insertDummySurvey(SqlSessionTemplate session, List<Survey> dummySurveyList) {
		int result=session.insert("MateMapper.insertSurveyList", dummySurveyList);
		return result;
	}

	@Override
	public int insertDummySurveyGenre(SqlSessionTemplate session, List<SurveyGenre> dummySurveyGenreList) {
		int result=session.insert("MateMapper.insertSurveyGenreList", dummySurveyGenreList);
		return result;
	}

	@Override
	public Survey selectSurveyByMemberId(SqlSessionTemplate session, String memberId) {
		Survey survey=session.selectOne("MateMapper.selectSurveyByMemberId", memberId);
		return survey;
	}

	@Override
	public List<Survey> selectOtherSurveyList(SqlSessionTemplate session, String memberId) {
		List<Survey> otherSurveyList=session.selectList("MateMapper.selectOtherSurveyList", memberId);
		return otherSurveyList;
	}

	@Override
	public List<SurveyGenre> selectOtherSurveyGenreList(SqlSessionTemplate session, List<Survey> firstFilteredSurvey) {
		List<SurveyGenre> otherSurveyGenreList=session.selectList("MateMapper.selectOtherSurveyGenreList", firstFilteredSurvey);
		return otherSurveyGenreList;
	}

	@Override
	public List<SurveyGenre> selectSurveyGenreBySurveyNo(SqlSessionTemplate session, Integer surveyNo) {
		List<SurveyGenre> requesterGenreList=session.selectList("MateMapper.selectSurveyGenreListBySurveyNo", surveyNo);
		return requesterGenreList;
	}

	@Override
	public Member selectMemberInfo(SqlSessionTemplate session, String memberId) {
		Member member=session.selectOne("MemberMapper.selectOneByDetailId", memberId);
		return member;
	}

	@Override
	public int insertMatching(SqlSessionTemplate session, String requesterId, String respondentId) {
		HashMap<String, String> param=new HashMap<>();
		param.put("requesterId", requesterId);
		param.put("respondentId", respondentId);
		int result=session.insert("MateMapper.insertMatching", param);
		return result;
	}

	@Override
	public int selectExistMatching(SqlSessionTemplate session, String requesterId, String respondentId) {
		HashMap<String, String> param=new HashMap<>();
		param.put("requesterId", requesterId);
		param.put("respondentId", respondentId);
		int result=session.selectOne("MateMapper.selectExistMatching", param);
		return result;
	}

	@Override
	public int updateMatchingCount(SqlSessionTemplate session, String memberId) {
		int result=session.update("MateMapper.updateMatchingCount",memberId);
		return result;
	}

	@Override
	public List<String> selectMyMateId(SqlSessionTemplate session, String memberId) {
		List<String> myMateId=session.selectList("MateMapper.selectMyMateId", memberId);
		return myMateId;
	}

	@Override
	public List<Survey> selectMyMateSurveyList(SqlSessionTemplate session, List<String> myMateList) {
		List<Survey> myMateSurveyList=session.selectList("MateMapper.selectMyMateSurveyList", myMateList);
		return myMateSurveyList;
	}

	@Override
	public String selectMatchDate(SqlSessionTemplate session, String requesterId, String respondentId) {
		HashMap<String, String> param=new HashMap<>();
		param.put("requesterId", requesterId);
		param.put("respondentId", respondentId);
		String matchDate=session.selectOne("MateMapper.selectMatchDate", param);
		return matchDate;
	}
	
	@Override
	public String selectAllMatchDate(SqlSessionTemplate session, String requesterId, String respondentId) {
		HashMap<String, String> param=new HashMap<>();
		param.put("requesterId", requesterId);
		param.put("respondentId", respondentId);
		String matchDate=session.selectOne("MateMapper.selectAllMatchDate", param);
		return matchDate;
	}

	@Override
	public int updateToDeleteMatching(SqlSessionTemplate session, String memberId, String mateId) {
		HashMap<String, String> param=new HashMap<>();
		param.put("memberId", memberId);
		param.put("mateId", mateId);
		int result=session.update("MateMapper.updateToDeleteMatching", param);
		return result;
	}

	@Override
	public int updateMatchingActive(SqlSessionTemplate session, String memberId, String matchingActive) {
		HashMap<String, String> param=new HashMap<>();
		param.put("memberId", memberId);
		param.put("matchingActive", matchingActive);
		int result=session.update("MateMapper.updateMatchingActive", param);
		return result;
	}

	@Override
	public List<String> selectAllMateId(SqlSessionTemplate session, String memberId) {
		List<String> myAllMateList=session.selectList("MateMapper.selectAllMyMateId", memberId);
		return myAllMateList;
	}

	@Override
	public String selectAllEndDate(SqlSessionTemplate session, String requesterId, String respondentId) {
		HashMap<String, String> param=new HashMap<>();
		param.put("requesterId", requesterId);
		param.put("respondentId", respondentId);
		String endDate=session.selectOne("MateMapper.selectAllEndDate", param);
		return endDate;
	}
}
