package com.example.youtubeapisample.data.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Snippet {
    private String publishedAt;
    private String channelId;
    private String title;
    private String description;
    private Thumbnails thumbnails;
    private String channelTitle;
    private String liveBroadcastContent;
    private String publishTime;
}
