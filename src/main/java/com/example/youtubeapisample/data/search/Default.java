package com.example.youtubeapisample.data.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Default {
    private String url;
    private long width;
    private long height;
}
