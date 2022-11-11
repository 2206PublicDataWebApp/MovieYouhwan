package kr.co.movieyouhwan.user.myPage.domain;

import java.util.Date;

public class Zzim {
	private int zzimNo;	
	private int memberId;	
	private int movieNo;	
	private Date zzimDate;
	
	
	public int getZzimNo() {
		return zzimNo;
	}
	public void setZzimNo(int zzimNo) {
		this.zzimNo = zzimNo;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public Date getZzimDate() {
		return zzimDate;
	}
	public void setZzimDate(Date zzimDate) {
		this.zzimDate = zzimDate;
	}
	@Override
	public String toString() {
		return "Zzim [zzimNo=" + zzimNo + ", memberId=" + memberId + ", movieNo=" + movieNo + ", zzimDate=" + zzimDate
				+ "]";
	}
	public Zzim(int zzimNo, int memberId, int movieNo, Date zzimDate) {
		super();
		this.zzimNo = zzimNo;
		this.memberId = memberId;
		this.movieNo = movieNo;
		this.zzimDate = zzimDate;
	}
	
	
}
