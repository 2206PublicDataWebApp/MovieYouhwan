package kr.co.movieyouhwan.user.mate.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.user.mate.domain.CinemaOption;
import kr.co.movieyouhwan.user.mate.domain.GenreOption;
import kr.co.movieyouhwan.user.mate.domain.Survey;
import kr.co.movieyouhwan.user.mate.domain.SurveyGenre;
import kr.co.movieyouhwan.user.mate.service.MateService;
import kr.co.movieyouhwan.user.member.domain.Member;
import net.datafaker.Faker;

@Controller
public class MateController {

	@Autowired
	private MateService mService;

	private static final ArrayList<String> GENRE_NAMES = new ArrayList<>(
			Arrays.asList("공포", "액션", "로맨스", "범죄", "SF", "스릴러", "판타지", "코미디"));

	private int i = 0;

	/**
	 * FAKE DATA 생성
	 * 
	 * @throws ParseException
	 */
	@RequestMapping(value = "/member/dummydata.yh")
	public void dataFaker() throws ParseException {
		Faker faker = new Faker(new Locale("ko"));
		Faker faker_us = new Faker();
		List<Member> dummyMemberList = new ArrayList<>();
		List<Survey> dummySurveyList = new ArrayList<>();
		List<SurveyGenre> dummySurveyGenreList = new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");
		List<CinemaOption> cinemaOptionList = mService.printCinemaOption();
		for (i = 0; i < 200; i++) {

			// id와 password 같음
			String id = faker.expression("#{regexify '[a-z]{1}[a-z0-9]{5,11}'}");
			// name과 nickname 같음
			String name = faker.name().name().replace(" ", "");
			String birth = faker.date().birthday(20, 60, "YYYYMMdd");
			String gender = faker.expression("#{options.option '여','남'}");
			String phone = faker.expression("#{regexify '010[0-9]{8}'}");
			String email = faker_us.internet().emailAddress();
			Date signupDate = formatter.parse(faker.date().past(100, TimeUnit.DAYS, "YY/MM/dd"));
			String level = faker.expression("#{options.option '0','1','2','3','4'}");

			Member member = new Member();
			member.setMemberId(id);
			member.setMemberPwd(id);
			member.setMemberName(name);
			member.setMemberNick(name);
			member.setMemberBirth(birth);
			member.setMemberGender(gender);
			member.setMemberPhone(phone);
			member.setMemberEmail(email);
			member.setMemberSignUpDate(signupDate);
			member.setMemberLevel(level);

			dummyMemberList.add(member);

			// survey
			Survey survey = new Survey();
			String genderOption = faker.expression("#{options.option '여','남', '무관'}");
			String age = faker.expression("#{options.option '20대', '30대', '40대' '50대 이상'}");

			survey.setSurveyNo(i);
			survey.setAge(age);
			survey.setGender(genderOption);
			survey.setCinemaName(cinemaOptionList.get((i) % cinemaOptionList.size()).getCinemaName());
			survey.setMemberId(id);
			survey.setMemberBirth(birth);
			survey.setMemberGender(gender);

			ArrayList<String> genres = (ArrayList<String>) GENRE_NAMES.clone();

			int gerneSize = 2;
			for (int j = gerneSize * i; j < gerneSize * i + gerneSize; j++) {
				SurveyGenre surveyGenre = new SurveyGenre();
				surveyGenre.setSurveyGenreNo(j);
				int genreIdx = faker.random().nextInt(genres.size());
				surveyGenre.setGenre(genres.get(genreIdx));
				genres.remove(genreIdx);
				surveyGenre.setSurveyNo(i);
				dummySurveyGenreList.add(surveyGenre);
			}
			dummySurveyList.add(survey);
		}

		int result_member = mService.registerDummyMember(dummyMemberList);
		int result_survey = mService.registerDummySurvey(dummySurveyList);
		int result_survey_genre = mService.registerDummySurveyGenreList(dummySurveyGenreList);

		System.out.println("멤버 dummy insert 결과 : " + result_member);
		System.out.println("서베이 dummy insert 결과 : " + result_survey);
		System.out.println("서베이 장르 dummy insert 결과 : " + result_survey_genre);
	}

	@RequestMapping(value = "/mate/startMate.yh")
	public String startMate() {
		return "user/mate/mateAgree";
	}

	/**
	 * 메이트 페이지로 이동
	 * 
	 * @param mv
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/mate/main.yh")
	public ModelAndView mateListView(ModelAndView mv, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();

		// 메이트 서비스 가입여부 확인
		int isMate = mService.printMateStatus(memberId);

		// 가입했으면 mate list 페이지로 이동
		if (isMate > 0) {
			mv.setViewName("user/mate/mateList");
		}

		// 아니면 약관 동의 페이지로 이동
		else {
			mv.setViewName("user/mate/mateAgree");
		}
		return mv;
	}

	@RequestMapping(value = "/mate/modifyMstatusY")
	public ModelAndView modifyMateStatusY(ModelAndView mv, HttpServletRequest request,
			@RequestParam("memberId") String memberId) {
		HttpSession session = request.getSession();
		if ((Member) session.getAttribute("loginUser") == null) {
			mv.setViewName("redirect:/member/loginView.yh");
		} else {
			int result = mService.modifyMateStatusY(memberId);
			if (result > 0) {
				mv.setViewName("redirect:/mate/selectOption.yh");
				// 만약 조건 선택 완료 안하고 다른 페이지로 나가면 메이트 리스트에서 매칭하기를 눌렀을 때 다시 조건 선택부터 하게 해야함
			} else {

				// 에러처리 해야함
			}
		}
		return mv;
	}

	// method=RequestMethod.POST , HttpServletRequest request

	@RequestMapping(value = "/mate/selectOption.yh")
	public ModelAndView mateSelectOptionView(ModelAndView mv, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if ((Member) session.getAttribute("loginUser") == null) {
			mv.setViewName("redirect:/member/loginView.yh");
		}
		List<CinemaOption> cinemaOptionList = mService.printCinemaOption();
		List<GenreOption> genreOptionList = mService.printGenreOption();
		if (cinemaOptionList != null && genreOptionList != null) {
			mv.addObject("cinemaOptionList", cinemaOptionList);
			mv.addObject("genreOptionList", genreOptionList);
			System.out.println(genreOptionList.toString());
		}
		mv.setViewName("user/mate/mateOption");
		return mv;
	}

	@RequestMapping(value = "/mate/selectOption.complete.yh", method = RequestMethod.POST)
	public ModelAndView selectOptionComplete(ModelAndView mv, HttpServletRequest request,
			@RequestParam("gender") String gender, @RequestParam("age") String age,
			@RequestParam("cinemaName") String cinemaName, @RequestParam("genreList") List<String> genreList) {

		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser");
		if (member != null) {
			String memberId = member.getMemberId();
			Survey survey = new Survey();
			survey.setGender(gender);
			survey.setAge(age);
			survey.setCinemaName(cinemaName);
			survey.setMemberId(memberId);
			survey.setMemberBirth(member.getMemberBirth());
			survey.setGender(member.getMemberGender());
			int result = mService.registerSurvey(survey);
			if (result > 0) {
				Integer surveyNo = mService.printSurveyNo(memberId);
				if (surveyNo > 0) {
					result = mService.registerSurveyGenre(surveyNo, genreList);
					System.out.println(result);
					if (result > 0) {

					}
				}
			}
		}
		return mv;
	}

	/**
	 * 메이트 매칭완료
	 * 
	 * @return
	 */
	@RequestMapping(value = "/mate/Complete.yh", method = RequestMethod.GET)
	public String mateCompleteView() {
		return "user/mate/mateComplete";
	}

	public void makeFakeData() {
		Faker faker = new Faker();
		String name = faker.name().fullName();
		System.out.println(name);
	}

	@RequestMapping(value = "/mate/matching.yh")
	public ModelAndView mateMatching(ModelAndView mv, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser");
		if (member != null) {
			String memberId = member.getMemberId();
			Survey requesterSurvey = mService.getSurveyByMemberId(memberId);
			List<Survey> otherSurveyList = mService.getOtherSurveyList(memberId);
			for (int i = 0; i < otherSurveyList.size(); i++) {
				// 연령대 매칭 검사
				if (requesterSurvey.getAge().equals(otherSurveyList.get(i).getMemberAge())
						&& requesterSurvey.getMemberAge().equals(otherSurveyList.get(i).getAge())) {
					otherSurveyList.get(i).setMatchingGrade(otherSurveyList.get(i).getMatchingGrade() + 30);
				}

				// 성별 매칭 검사
				if (requesterSurvey.getGender().equals("무관")) {
					// 무관 무관
					if (otherSurveyList.get(i).getGender().equals("무관")) {
						otherSurveyList.get(i).setMatchingGrade(otherSurveyList.get(i).getMatchingGrade() + 30);
					}

					// 무관 선택
					else {
						if (otherSurveyList.get(i).getGender().equals(requesterSurvey.getMemberGender())) {
							otherSurveyList.get(i).setMatchingGrade(otherSurveyList.get(i).getMatchingGrade() + 30);
						}
					}
				} else {

					// 선택 무관
					if (otherSurveyList.get(i).getGender().equals("무관")) {
						if (requesterSurvey.getGender().equals(otherSurveyList.get(i).getMemberGender())) {
							otherSurveyList.get(i).setMatchingGrade(otherSurveyList.get(i).getMatchingGrade() + 30);
						}
					}

					// 선택 선택
					else {
						if (requesterSurvey.getGender().equals(otherSurveyList.get(i).getMemberGender())
								&& requesterSurvey.getMemberGender().equals(otherSurveyList.get(i).getGender())) {
							otherSurveyList.get(i).setMatchingGrade(otherSurveyList.get(i).getMatchingGrade() + 30);
						}
					}
				}

				// 영화관 매칭 검사
				if (requesterSurvey.getCinemaName().equals(otherSurveyList.get(i).getCinemaName())) {
					otherSurveyList.get(i).setMatchingGrade(otherSurveyList.get(i).getMatchingGrade() + 30);
				}
			}

			// A - 성별, 나이, 영화관 점수 합이 0점인 survey 필터링
			List<Survey> firstFilteredSurvey = otherSurveyList.stream().filter(survey -> survey.getMatchingGrade() != 0)
					.collect(Collectors.toList());

			// SurveyNo로 매칭 요청자의 SurveyGenre List 가져오기
			List<SurveyGenre> requesterGenreList = mService.getGenreListBySurveyNo(requesterSurvey.getSurveyNo());
			System.out.println("requestrGenreList: " + requesterGenreList);

			// A에서 필터링한 SurveyList를 매개변수로 3개의 조건 중 하나 이상 부합하는 survey의 장르 리스트를 가져옴
			List<SurveyGenre> otherSurveyGenreList = mService.getFilteredSurveyGenreList(firstFilteredSurvey);
			System.out.println("otherSurveyGenreList: " + otherSurveyGenreList);

			// 매칭 요청자의 선호 장르와 같은 SurveyGenre 필터링
			List<SurveyGenre> filteredSurveyGenreList = new ArrayList<>();
			for (i = 0; i < requesterGenreList.size(); i++) {
				filteredSurveyGenreList.addAll(otherSurveyGenreList.stream()
						.filter(surveyGenre -> requesterGenreList.get(i).getGenre().equals(surveyGenre.getGenre()))
						.collect(Collectors.toList()));
			}

			for (int k = 0; k < filteredSurveyGenreList.size(); k++) {
				System.out.println("filteredSurveyGenreList: "+filteredSurveyGenreList.get(k).toString());
			}

			// 장르 1개가 부합할 때마다 가산되는 점수
			int genreGrade = 10 / requesterGenreList.size();
//			System.out.println("grade: "+genreGrade);

			// 필터링 된 Survey에 장르 점수 합산
			for (i = 0; i < firstFilteredSurvey.size(); i++) {
				for (int j = 0; j < filteredSurveyGenreList.size(); j++) {
					if (firstFilteredSurvey.get(i).getSurveyNo() == filteredSurveyGenreList.get(j).getSurveyNo()) {
						System.out.println("i = " + i + " , j = " + j);
						System.out.println("first: " + firstFilteredSurvey.get(i).toString());
						System.out.println("filterd: " + filteredSurveyGenreList.get(j).toString());
						firstFilteredSurvey.get(i)
								.setMatchingGrade(firstFilteredSurvey.get(i).getMatchingGrade() + genreGrade);
						filteredSurveyGenreList.remove(j);
						j = -1;
					} else {
						break;
					}
				}
			}
			List<Survey> sortedSurveyList = firstFilteredSurvey.stream()
					.sorted(Comparator.comparing(Survey::getMatchingGrade).reversed()).collect(Collectors.toList());
//			firstFilteredSurvey.stream().sorted(Comparator.comparing(Survey::getMatchingGrade));
			List<Survey> finalMatchList = new ArrayList<>();

			System.out.println("requester : " + requesterSurvey.toString());
			System.out.println("=================================================================");
			for (int k = 0; k < sortedSurveyList.size(); k++) {
				System.out.println(sortedSurveyList.get(k).toString());
			}

			mv.addObject("MatchResultSurvey", sortedSurveyList.get(0));
			mv.addObject("mySurvey", requesterSurvey);
			mv.setViewName("user/mate/mateAgree");
		}
		return mv;
	}

}
