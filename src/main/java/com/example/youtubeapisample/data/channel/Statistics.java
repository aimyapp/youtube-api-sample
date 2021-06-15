package com.example.youtubeapisample.data.channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Statistics {
	private long viewCount;
	private long subscriberCount;
	private boolean hiddenSubscriberCount;
	private long videoCount;
}
