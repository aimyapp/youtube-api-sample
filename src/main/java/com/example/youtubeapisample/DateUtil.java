package com.example.youtubeapisample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.val;

@Component
public class DateUtil {

	public String getCsvDateFormat() {
		val dateObj = new Date();
		val format = new SimpleDateFormat("yyyyMMdd_HHmmss");
		return format.format(dateObj);
	}

	public String getPublishedAtFormat(String publishedAt) throws ParseException {
		val index = publishedAt.indexOf("T");
		return publishedAt.substring(0, index);

	}

}
