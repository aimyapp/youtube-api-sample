package com.example.youtubeapisample;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.val;

@Component
public class DateUtil {

	public String getDateFormat() {
		val dateObj = new Date();
		val format = new SimpleDateFormat("yyyyMMdd_HHmmss");
		return format.format(dateObj);
	}

}
