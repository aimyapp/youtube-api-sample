package com.example.youtubeapisample.data.video;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	private String kind;
	private String etag;
	private String id;
	private Statistics statistics;

}
