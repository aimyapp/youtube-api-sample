package com.example.youtubeapisample.data.video;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Statistics {
	private String viewCount;
	private String likeCount;
	private String dislikeCount;
	private String favoriteCount;
	private String commentCount;
}