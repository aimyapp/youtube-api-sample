package com.example.youtubeapisample.csv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "タイトル", "url" })
public class SearchResultCsv {

	@JsonProperty("タイトル")
	private String title;
	@JsonProperty("url")
	private String url;

	public SearchResultCsv(String title, String url) {
		this.title = url;
		this.url = url;

	}

}
