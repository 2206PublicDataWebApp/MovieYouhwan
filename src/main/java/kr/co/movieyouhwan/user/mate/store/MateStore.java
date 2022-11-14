package kr.co.movieyouhwan.user.mate.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.user.mate.domain.CinemaOption;
import kr.co.movieyouhwan.user.mate.domain.GenreOption;
import kr.co.movieyouhwan.user.mate.domain.Survey;
import kr.co.movieyouhwan.user.mate.domain.SurveyGenre;
import kr.co.movieyouhwan.user.member.domain.Member;

public interface MateStore {

	int selectMateStatus(SqlSessionTemplate session, String memberId);

	int updateMateStatusY(SqlSessionTemplate session, String memberId);

	List<CinemaOption> selectCinemaOption(SqlSessionTemplate session);

	List<GenreOption> selectGenreOption(SqlSessionTemplate session);

	int insertSurvey(SqlSessionTemplate session, Survey survey);

	int selectSurveyNo(SqlSessionTemplate session, String memberId);

	int insertSurveyGenre(SqlSessionTemplate session, Integer surveyNo, List<String> genreList);

	int insertDummyMember(SqlSessionTemplate session, List<Member> dummyMemberList);

	int insertDummySurvey(SqlSessionTemplate session, List<Survey> dummySurveyList);

	int insertDummySurveyGenre(SqlSessionTemplate session, List<SurveyGenre> dummySurveyGenreList);

	Survey selectSurveyByMemberId(SqlSessionTemplate session, String memberId);

	List<Survey> selectOtherSurveyList(SqlSessionTemplate session, String memberId);

	List<SurveyGenre> selectOtherSurveyGenreList(SqlSessionTemplate session, List<Survey> firstFilteredSurvey);

	List<SurveyGenre> selectSurveyGenreBySurveyNo(SqlSessionTemplate session, Integer surveyNo);

	Member selectMemberInfo(SqlSessionTemplate session, String memberId);

	int insertMatching(SqlSessionTemplate session, String requesterId, String respondentId);

	int selectExistMatching(SqlSessionTemplate session, String requesterId, String respondentId);

}
