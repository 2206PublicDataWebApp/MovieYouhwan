package kr.co.movieyouhwan.user.movie.domain;

public class MovieReview {
	private Integer movieReviewNo;
	private Integer movieNo;
	private String memberId;
	private String memberNick;
	private String memberImgRename;
	private Integer movieRate;
	private String movieReview;
	private String regDate;

	public Integer getMovieReviewNo() {
		return movieReviewNo;
	}

	public void setMovieReviewNo(Integer movieReviewNo) {
		this.movieReviewNo = movieReviewNo;
	}

	public Integer getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(Integer movieNo) {
		this.movieNo = movieNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public String getMemberImgRename() {
		return memberImgRename;
	}

	public void setMemberImgRename(String memberImgRename) {
		this.memberImgRename = memberImgRename;
	}

	public Integer getMovieRate() {
		return movieRate;
	}

	public void setMovieRate(Integer movieRate) {
		this.movieRate = movieRate;
	}

	public String getMovieReview() {
		return movieReview;
	}

	public void setMovieReview(String movieReview) {
		this.movieReview = movieReview;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MovieReview [movieReviewNo=" + movieReviewNo + ", movieNo=" + movieNo + ", memberId=" + memberId
				+ ", memberNick=" + memberNick + ", memberImgRename=" + memberImgRename + ", movieRate=" + movieRate
				+ ", movieReview=" + movieReview + ", regDate=" + regDate + "]";
	}

	
}
