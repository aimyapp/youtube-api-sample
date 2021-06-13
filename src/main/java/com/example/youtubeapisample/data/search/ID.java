package com.example.youtubeapisample.data.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class ID {
    private String kind;
    private String videoId;
}
