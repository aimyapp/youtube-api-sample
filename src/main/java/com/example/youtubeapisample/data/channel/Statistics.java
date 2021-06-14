package com.example.youtubeapisample.data.channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Statistics {
	private int viewCount;
	private int subscriberCount;
	private boolean hiddenSubscriberCount;
	private int videoCount;
}
