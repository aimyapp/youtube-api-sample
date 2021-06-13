package com.example.youtubeapisample.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Statistics {
	private int viewCount;
	private int likeCount;
	private int dislikeCount;
	private int favoriteCount;
	private int commentCount;
}
