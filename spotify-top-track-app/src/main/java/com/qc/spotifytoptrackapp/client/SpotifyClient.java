package com.qc.spotifytoptrackapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.qc.spotifytoptrackapp.model.SpotifyTracksResponse;

@Component
public class SpotifyClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getTopTrackName() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth("BQAo8wpcg_XjZd2En3EwCydoipvJHAvB6qs7_u4CVe0Hgyw1jCFygnAcbnkGr8j8JXudvwGrCBJJUW4RWOu7ftW66LFw-bS7GdWf340hyBz3oxa4uf4QhkTUd9wYYvUyyLnFp12L-P2OXOKbqJTLrOwNsz6Qwe-u5iocQ1m5fv2F69PTkeoGacWPsoVu0uB4S2d8cvRnQx3vwsPT-NBUDxSw");
		String url = "https://api.spotify.com/v1/me/top/tracks?limit=1";
		HttpEntity<Void> entity = new HttpEntity<>(headers);
		
		ResponseEntity<SpotifyTracksResponse> response =
				restTemplate.exchange(url, HttpMethod.GET, entity, SpotifyTracksResponse.class);
		

		if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
			return response.getBody().items().get(0).name();
		}
		
		return "";
	}

}
