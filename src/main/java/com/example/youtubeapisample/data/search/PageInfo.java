package com.example.youtubeapisample.data.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class PageInfo {
    private long totalResults;
    private long resultsPerPage;
}
