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
import com.example.youtubeapisample.data.search.Item;
import com.example.youtubeapisample.data.search.SearchResult;
import com.example.youtubeapisample.data.video.Video;
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

	public List<SearchResultCsv> createCsv(String searchResult, int viewsDivideSubscribers, int xDays)
			throws JsonMappingException, JsonProcessingException, ParseException, URISyntaxException {

		// Youtubeの検索結果をJavaオブジェクトに変換
		val mapper = new ObjectMapper();
		val searchResultModel = mapper.readValue(searchResult, SearchResult.class);

		// CSVに出力するモデル作成
		List<SearchResultCsv> csvList = new ArrayList<SearchResultCsv>();
		for (Item item : searchResultModel.getItems()) {
			// Youtubeの検索結果を元に動画情報を取得
			val video = youtubeDataSearch.getYoutubeVideoData(item.getId().getVideoId());
			val videoModel = mapper.readValue(video, Video.class);
			// CSVに出力する値を設定
			csvList.add(new SearchResultCsv(
					item.getSnippet().getChannelTitle(), // チャンネル名
					item.getSnippet().getTitle(), // タイトル
					youtubeApiProperties.getMovieBaseUrl() + item.getId().getVideoId(), // 動画URL
					0, // チャンネル登録者数
					videoModel.getItems().get(0).getStatistics().getViewCount(), // 再生回数
					dateUtil.getPublishedAtFormat(item.getSnippet().getPublishedAt()))); // 登録日付
		}
		return csvList;
	}

}
