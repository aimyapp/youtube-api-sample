package com.example.youtubeapisample.controller;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.youtubeapisample.DateUtil;
import com.example.youtubeapisample.DownloadHelper;
import com.example.youtubeapisample.csv.SearchResultCsv;
import com.example.youtubeapisample.form.SearchForm;
import com.example.youtubeapisample.service.CreateSearchResultCsvService;
import com.example.youtubeapisample.service.YoutubeDataSearchSearvice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;

import lombok.val;

@RestController
public class CsvDownloadController {

	@Autowired
	YoutubeDataSearchSearvice youtubeDataSearch;
	@Autowired
	CreateSearchResultCsvService createSearchResultCsvService;
	@Autowired
	DownloadHelper downloadHelper;
	@Autowired
	DateUtil dateUtil;

	@GetMapping({ "/", "/index", "/csvDownload" })
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("searchForm", new SearchForm());
		return mav;
	}

	@PostMapping(value = "/csvDownload")
	public ResponseEntity<byte[]> csvDownload(@ModelAttribute SearchForm searchForm)
			throws URISyntaxException, JsonProcessingException, ParseException, UnsupportedEncodingException {

		// Youtubeの検索結果を取得
		val searchResult = youtubeDataSearch.getYoutubeSearchData(searchForm.getKeyword());
		// Youtubeの検索結果を整形してCSVファイルを作成
		val csvList = createSearchResultCsvService.createCsv(searchResult);

		val headers = new HttpHeaders();
		// 第二引数にダウンロード時のファイル名を設定
		downloadHelper.addContentDisposition(headers,
				searchForm.getKeyword() + "_" + dateUtil.getDateFormat() + ".csv");

		val mapper = new CsvMapper();
		val schema = mapper.schemaFor(SearchResultCsv.class).withHeader();

		return new ResponseEntity<>(mapper.writer(schema).writeValueAsString(csvList).getBytes("MS932"), headers,
				HttpStatus.OK);

	}
}
