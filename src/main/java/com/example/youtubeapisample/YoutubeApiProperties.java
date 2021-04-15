package com.example.youtubeapisample;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "youtube.api")
public class YoutubeApiProperties {
	private String url;
	private String apiKey;
	private String type;
	private String part;
}
