package com.example.youtubeapisample.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Item {
    private String kind;
    private String etag;
    private ID id;
    private Snippet snippet;
}
