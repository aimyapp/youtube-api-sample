package com.example.youtubeapisample.data.channel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@lombok.Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Channel {
	private String kind;
	private String etag;
	private PageInfo pageInfo;
	private List<Item> items;
}
