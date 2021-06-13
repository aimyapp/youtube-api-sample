package com.example.youtubeapisample.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Video {

	private List<Statistics> items;
}
