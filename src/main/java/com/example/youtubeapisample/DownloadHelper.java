package com.example.youtubeapisample;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriUtils;

import lombok.val;


@Component
public class DownloadHelper {

	private final String CONTENT_DISPOSITION_FORMAT = "attachment; filename=\"%s\"; filename*=UTF-8''%s";

	// CSVダウンロードする際、ファイル名を日本語に対応
	public void addContentDisposition(HttpHeaders headers, String fileName)
			throws UnsupportedEncodingException {
		val headerValue = String.format(CONTENT_DISPOSITION_FORMAT,
				fileName, UriUtils.encode(fileName, StandardCharsets.UTF_8.name()));
		headers.add(HttpHeaders.CONTENT_DISPOSITION, headerValue);
	}

}
