package kr.co.movieyouhwan.user.mate.service.logic;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.user.mate.domain.CinemaOption;
import kr.co.movieyouhwan.user.mate.domain.GenreOption;
import kr.co.movieyouhwan.user.mate.domain.Survey;
import kr.co.movieyouhwan.user.mate.domain.SurveyGenre;
import kr.co.movieyouhwan.user.mate.service.MateService;
import kr.co.movieyouhwan.user.mate.store.MateStore;
import kr.co.movieyouhwan.user.member.domain.Member;

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

	@Override
	public int registerDummyMember(List<Member> dummyMemberList) {
		int result=mStore.insertDummyMember(session, dummyMemberList);
		return result;
	}

	@Override
	public int registerDummySurvey(List<Survey> dummySurveyList) {
		int result=mStore.insertDummySurvey(session, dummySurveyList);
		return result;
	}

	@Override
	public int registerDummySurveyGenreList(List<SurveyGenre> dummySurveyGenreList) {
		int result=mStore.insertDummySurveyGenre(session, dummySurveyGenreList);	
		return result;
	}

	@Override
	public Survey getSurveyByMemberId(String memberId) {
		Survey survey=mStore.selectSurveyByMemberId(session, memberId);
		return survey;
	}

	@Override
	public List<Survey> getOtherSurveyList(String memberId) {
		List<Survey> otherSurveyList=mStore.selectOtherSurveyList(session, memberId);
		return otherSurveyList;
	}

	@Override
	public List<SurveyGenre> getFilteredSurveyGenreList(List<Survey> firstFilteredSurvey) {
		List<SurveyGenre> otherSurveyGenreList=mStore.selectOtherSurveyGenreList(session, firstFilteredSurvey);
		return otherSurveyGenreList;
	}

	@Override
	public List<SurveyGenre> getGenreListBySurveyNo(Integer surveyNo) {
		List<SurveyGenre> requesterGenreList=mStore.selectSurveyGenreBySurveyNo(session, surveyNo);
		return requesterGenreList;
	}

	@Override
	public Member printUserInfo(String memberId) {
		Member member=mStore.selectMemberInfo(session, memberId);
		return member;
	}

	@Override
	public int registerMatching(String requesterId, String respondentId) {
		int result=mStore.insertMatching(session, requesterId, respondentId);
		return result;
	}

	@Override
	public int checkExistMatching(String requesterId, String respondentId) {
		int result=mStore.selectExistMatching(session, requesterId, respondentId);
		return result;
	}

	@Override
	public int addMatchingCount(String memberId) {
		int result=mStore.updateMatchingCount(session, memberId);
		return result;
	}

	@Override
	public List<String> printMyMateId(String memberId) {
		List<String> myMateId=mStore.selectMyMateId(session, memberId);
		return myMateId;
	}

	@Override
	public List<Survey> getMyMateSurveyList(List<String> myMateList) {
		List<Survey> myMateSurveyList=mStore.selectMyMateSurveyList(session, myMateList);
		return myMateSurveyList;
	}

	@Override
	public String printMatchDate(String requesterId, String respondentId) {
		String matchDate=mStore.selectMatchDate(session, requesterId, respondentId);
		return matchDate;
	}

	@Override
	public int updateToDeleteMatching(String memberId, String mateId) {
		int result=mStore.updateToDeleteMatching(session, memberId, mateId);
		return result;
	}

	@Override
	public int modifyMatchingActive(String memberId, String matchingActive) {
		int result=mStore.updateMatchingActive(session, memberId, matchingActive);
		return result;
	}

}
