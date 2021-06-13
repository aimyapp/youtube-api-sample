package com.example.youtubeapisample.service;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.youtubeapisample.DateUtil;
import com.example.youtubeapisample.YoutubeApiProperties;
import com.example.youtubeapisample.csv.SearchResultCsv;
import com.example.youtubeapisample.data.Item;
import com.example.youtubeapisample.data.SearchResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.val;

@Service
public class CreateSearchResultCsvService {

	@Autowired
	YoutubeApiProperties youtubeApiProperties;
	@Autowired
	DateUtil dateUtil;
	@Autowired
	YoutubeDataSearchSearvice youtubeDataSearch;

	public List<SearchResultCsv> createCsv(String searchResult)
			throws JsonMappingException, JsonProcessingException, ParseException, URISyntaxException {

		// Youtubeの検索結果をJavaオブジェクトに変換
		val mapper = new ObjectMapper();
		val model = mapper.readValue(searchResult, SearchResult.class);

		//	List<Video> videos = new ArrayList<Video>();
		//	String a = youtubeDataSearch.getYoutubeVideoData(model.getItems().get(0).getId().getVideoId());

		// CSVに出力するモデル作成
		List<SearchResultCsv> csvList = new ArrayList<SearchResultCsv>();
		for (Item item : model.getItems()) {
			csvList.add(new SearchResultCsv(
					item.getSnippet().getChannelTitle(), //
					item.getSnippet().getTitle(), //
					youtubeApiProperties.getMovieBaseUrl() + item.getId().getVideoId(), //
					0, //
					0, //
					dateUtil.getPublishedAtFormat(item.getSnippet().getPublishedAt())));
		}

		return csvList;
	}

}
