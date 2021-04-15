package com.example.youtubeapisample.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.youtubeapisample.csv.SearchResultCsv;
import com.example.youtubeapisample.form.SearchForm;
import com.example.youtubeapisample.service.CreateSearchResultCsvService;
import com.example.youtubeapisample.service.YoutubeDataSearchSearvice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import lombok.val;

@RestController
public class CsvDownloadController {

	@Autowired
	YoutubeDataSearchSearvice youtubeDataSearch;
	@Autowired
	CreateSearchResultCsvService createSearchResultCsvService;

	@GetMapping({ "/", "/index", "/csvDownload" })
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("searchForm", new SearchForm());
		return mav;
	}

	@PostMapping(value = "/csvDownload", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
			+ "; charset=UTF-8; Content-Disposition: attachment")
	@ResponseBody
	public Object csvDownload(@ModelAttribute SearchForm searchForm)
			throws URISyntaxException, JsonProcessingException {

		// Youtubeの検索結果を取得
		val SearchResult = youtubeDataSearch.getYoutubeSearchData(searchForm.getKeyword());
		// Youtubeの検索結果を整形してCSVファイルを作成
		val csv = createSearchResultCsvService.createCsv(SearchResult);

		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(SearchResultCsv.class).withHeader();

		return mapper.writer(schema).writeValueAsString(csv);

	}
}
