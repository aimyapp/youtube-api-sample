package com.example.youtubeapisample.csv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "チャンネル名", "タイトル", "動画URL", "チャンネル登録者数", "再生回数", "登録日付" })
public class SearchResultCsv {

	@JsonProperty("チャンネル名")
	private String channelTitle;
	@JsonProperty("タイトル")
	private String title;
	@JsonProperty("動画URL")
	private String movieUrl;
	@JsonProperty("チャンネル登録者数")
	private long subscriberCount;
	@JsonProperty("再生回数")
	private int viewCount;
	@JsonProperty("登録日付")
	private String publishedAt;

	public SearchResultCsv(String channelTitle, String title, String movieUrl, long subscriberCount, int viewCount,
			String publishedAt) {

		this.channelTitle = channelTitle;
		this.title = title;
		this.movieUrl = movieUrl;
		this.subscriberCount = subscriberCount;
		this.viewCount = viewCount;
		this.publishedAt = publishedAt;

	}

}
