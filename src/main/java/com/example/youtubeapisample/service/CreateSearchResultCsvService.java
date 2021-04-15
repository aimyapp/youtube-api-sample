package com.example.youtubeapisample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.youtubeapisample.csv.SearchResultCsv;

@Service
public class CreateSearchResultCsvService {

	public List<SearchResultCsv> createCsv(String searchResult) {

		// Youtubeの検索結果をJavaオブジェクトに変換


		// CSVに出力するモデル作成
		List<SearchResultCsv> csv = new ArrayList<SearchResultCsv>() {
			{
			//	add(new SearchResultCsv("aaa", "xxx"));
			}
		};

		return csv;
	}

}
