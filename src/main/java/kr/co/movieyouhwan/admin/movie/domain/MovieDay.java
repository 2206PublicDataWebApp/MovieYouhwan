package kr.co.movieyouhwan.admin.movie.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MovieDay {
	private String thisYear;
	private String thisMonth;
	List<String> dayList = new ArrayList<String>();
	List<String> tmdayList = new ArrayList<String>();
	List<String> timeList = new ArrayList<String>();  
	
	// 2022 표시
	private SimpleDateFormat sdyear = new SimpleDateFormat("yyyy");
	// 11 표시
	private SimpleDateFormat sdmonth = new SimpleDateFormat("MM");
	// 2022-11-01으로 표시
	private SimpleDateFormat sydate = new SimpleDateFormat("yyyy-MM-dd");
	// 1 금 으로 표시
	private SimpleDateFormat tmdate = new SimpleDateFormat("dd E");
	// 11시 이후부터 출력
	private LocalTime time = LocalTime.of(11, 00); 
	
	public MovieDay() {
		super();
		setYearMonth();
		for(int i = 0; i < 8; i++) {
			dayList.add(setDate(i));
		}
		for(int i = 0; i < 8; i++) {
			tmdayList.add(setDay(i));
		}
		for(int i = 0; i <= 22; i++) {
			timeList.add(time.plusMinutes(i * 30).toString());
		}
	}

	private void setYearMonth() {
		Calendar date = new GregorianCalendar();
		date.add(Calendar.DATE, 0);
		String year = sdyear.format(date.getTime());
		String month = sdmonth.format(date.getTime());
		setThisYear(year);
		setThisMonth(month);
	}

	private String setDate(int idx) {
		Calendar date = new GregorianCalendar();
		date.add(Calendar.DATE, idx);
		String day = sydate.format(date.getTime());
		return day;
	}
	
	private String setDay(int idx) {
		Calendar date = new GregorianCalendar();
		date.add(Calendar.DATE, idx);
		String tmday = tmdate.format(date.getTime());
		return tmday;
	}

	public String getThisYear() {
		return thisYear;
	}

	public void setThisYear(String thisYear) {
		this.thisYear = thisYear;
	}

	public String getThisMonth() {
		return thisMonth;
	}

	public void setThisMonth(String thisMonth) {
		this.thisMonth = thisMonth;
	}

	public List<String> getDayList() {
		return dayList;
	}

	public void setDayList(List<String> dayList) {
		this.dayList = dayList;
	}
	
	public List<String> getTmdayList() {
		return tmdayList;
	}

	public void setTmdayList(List<String> tmdayList) {
		this.tmdayList = tmdayList;
	}

	public List<String> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<String> timeList) {
		this.timeList = timeList;
	}
}
