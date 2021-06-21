package com.example.youtubeapisample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.val;

@Component
public class DateUtil {

	static final private String DATE_FORMAT = "yyyy-MM-dd";

	public String getCsvDateFormat() {
		val dateObj = new Date();
		val format = new SimpleDateFormat("yyyyMMdd_HHmmss");
		return format.format(dateObj);
	}

	public String getPublishedAtFormat(String publishedAt) throws ParseException {
		val index = publishedAt.indexOf("T");
		return publishedAt.substring(0, index);

	}

	public LocalDate string2LocalDate(final String date) {
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT));
	}

	public boolean between(LocalDate targetDate, LocalDate startDate, LocalDate endDate) {
		return !(startDate.isAfter(targetDate) || endDate.isBefore(targetDate));
	}

}
