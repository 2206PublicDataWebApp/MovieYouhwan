package kr.co.movieyouhwan.user.mate.domain;

public class SurveyGenre {
	private Integer surveyGenreNo;
	private String gerne;
	private Integer surveyNo;
	public Integer getSurveyGenreNo() {
		return surveyGenreNo;
	}
	public void setSurveyGenreNo(Integer surveyGenreNo) {
		this.surveyGenreNo = surveyGenreNo;
	}
	public String getGerne() {
		return gerne;
	}
	public void setGerne(String gerne) {
		this.gerne = gerne;
	}
	public Integer getSurveyNo() {
		return surveyNo;
	}
	public void setSurveyNo(Integer surveyNo) {
		this.surveyNo = surveyNo;
	}
	@Override
	public String toString() {
		return "SurveyGenre [surveyGenreNo=" + surveyGenreNo + ", gerne=" + gerne + ", surveyNo=" + surveyNo + "]";
	}

	
	
}
