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
				.queryParam("maxResults", youtubeApiProperties.getMaxResults())
				.queryParam("q", keword)
				.queryParam("key", youtubeApiProperties.getApiKey());

		HttpEntity<String> responseEntity = restTemplate.exchange(
				builder.toUriString(),
				HttpMethod.GET,
				entity,
				String.class);
		return responseEntity.getBody();
	}

	/**
	 * YouTube Data API(Videos: List)
	 * API リクエストのパラメータに一致する動画のリストを取得する
	 * @throws URISyntaxException
	 */
	public String getYoutubeVideoData(String videoId)
			throws URISyntaxException {

		val headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		val entity = new HttpEntity<>(headers);

		val builder = UriComponentsBuilder.fromHttpUrl(youtubeApiProperties.getVideoUrl())
				.queryParam("part", youtubeApiProperties.getStatistics())
				.queryParam("id", videoId)
				.queryParam("fields", youtubeApiProperties.getFields())
				.queryParam("key", youtubeApiProperties.getApiKey());

		HttpEntity<String> responseEntity = restTemplate.exchange(
				builder.toUriString(),
				HttpMethod.GET,
				entity,
				String.class);
		return responseEntity.getBody();
	}

}
