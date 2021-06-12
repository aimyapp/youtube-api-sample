package com.example.youtubeapisample.service;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.youtubeapisample.YoutubeApiProperties;

import lombok.val;

@Service
public class YoutubeDataSearchSearvice {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	YoutubeApiProperties youtubeApiProperties;

	/**
	 * YouTube Data API(Search: List)
	 * 指定したクエリ パラメータに一致する検索結果を取得する
	 * @throws URISyntaxException
	 */
	public String getYoutubeSearchData(String keword)
			throws URISyntaxException {

		val headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		val entity = new HttpEntity<>(headers);

		val builder = UriComponentsBuilder.fromHttpUrl(youtubeApiProperties.getUrl())
				.queryParam("type", youtubeApiProperties.getType())
				.queryParam("part", youtubeApiProperties.getPart())
				.queryParam("q", keword)
				.queryParam("key", youtubeApiProperties.getApiKey());

		HttpEntity<String> responseEntity = restTemplate.exchange(
				builder.toUriString(),
				HttpMethod.GET,
				entity,
				String.class);
		return responseEntity.getBody();
	}

}
