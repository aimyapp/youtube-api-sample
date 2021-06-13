package com.example.youtubeapisample.data.video;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Video {

	private List<Item> items;

}
