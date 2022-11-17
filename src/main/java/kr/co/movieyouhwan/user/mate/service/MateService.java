package kr.co.movieyouhwan.user.mate.service;

import java.util.Date;
import java.util.List;

import kr.co.movieyouhwan.user.mate.domain.CinemaOption;
import kr.co.movieyouhwan.user.mate.domain.GenreOption;
import kr.co.movieyouhwan.user.mate.domain.Survey;
import kr.co.movieyouhwan.user.mate.domain.SurveyGenre;
import kr.co.movieyouhwan.user.member.domain.Member;

public interface MateService {

	int printMateStatus(String memberId);

	int modifyMateStatusY(String memberId);

	List<CinemaOption> printCinemaOption();

	List<GenreOption> printGenreOption();

	int registerSurvey(Survey survey);

	int printSurveyNo(String memberId);

	int registerSurveyGenre(Integer surveyNo, List<String> genreList);

	int registerDummyMember(List<Member> dummyMemberList);

	int registerDummySurvey(List<Survey> dummySurveyList);

	int registerDummySurveyGenreList(List<SurveyGenre> dummySurveyGenreList);

	Survey getSurveyByMemberId(String memberId);

	List<Survey> getOtherSurveyList(String memberId);

	List<SurveyGenre> getFilteredSurveyGenreList(List<Survey> firstFilteredSurvey);

	List<SurveyGenre> getGenreListBySurveyNo(Integer surveyNo);

	Member printUserInfo(String memberId);

	int registerMatching(String requesterId, String respondentId);

	int checkExistMatching(String requesterId, String respondentId);

	int addMatchingCount(String memberId);

	List<String> printMyMateId(String memberId);

	List<Survey> getMyMateSurveyList(List<String> myMateList);

	String printMatchDate(String requesterId, String respondentId);

	String printAllMatchDate(String requesterId, String respondentId);

	int updateToDeleteMatching(String memberId, String mateId);

	int modifyMatchingActive(String memberId, String matchingActive);

	List<String> printMyAllMateId(String memberId);

	String printAllEndDate(String requesterId, String respondentId);

	
}
