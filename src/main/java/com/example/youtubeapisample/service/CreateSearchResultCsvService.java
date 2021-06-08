package com.example.youtubeapisample.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public List<SearchResultCsv> createCsv(String searchResult)
			throws JsonMappingException, JsonProcessingException, ParseException {

		// Youtubeの検索結果をJavaオブジェクトに変換
		val mapper = new ObjectMapper();
		val model = mapper.readValue(searchResult, SearchResult.class);
		// CSVに出力するモデル作成
		val dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<SearchResultCsv> csvList = new ArrayList<SearchResultCsv>();
		for (Item item : model.getItems()) {
			csvList.add(new SearchResultCsv(
					item.getSnippet().getChannelID(), //
					item.getSnippet().getTitle(), //
					youtubeApiProperties.getMovieBaseUrl() + item.getId().getVideoID(), //
					0, //
					0, //
					dateFormat.parse(item.getSnippet().getPublishedAt())));
		}

		return csvList;
	}

}
