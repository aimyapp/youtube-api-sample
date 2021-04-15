package com.example.youtubeapisample.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.youtubeapisample.form.SearchForm;
import com.example.youtubeapisample.service.YoutubeDataSearchSearvice;

@RestController
public class CsvDownloadController {

	@Autowired
	YoutubeDataSearchSearvice youtubeDataSearch;

	@GetMapping({ "/", "index" })
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("searchForm", new SearchForm());
		return mav;
	}

	@PostMapping("/csvDownload")
	@ResponseBody
	public String csvDownload(@ModelAttribute SearchForm searchForm) throws URISyntaxException {
		return youtubeDataSearch.getYoutubeSearchData(searchForm.getKeyword());
	}
}
