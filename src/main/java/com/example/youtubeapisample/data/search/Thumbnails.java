package com.example.youtubeapisample.data.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Thumbnails {
    private Default thumbnailsDefault;
    private Default medium;
    private Default high;
}
