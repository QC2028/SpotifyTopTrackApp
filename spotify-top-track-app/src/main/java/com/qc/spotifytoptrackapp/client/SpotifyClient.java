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
		
		HttpHeaders headers = new HttpHeaders(); //set auth token from spotify ouath2 on postman
		headers.setBearerAuth("BQBVEUyMVLk6lnmK-ZIWx0uMqmio4jqW737QkzmkirBk3GFPgQq9FfUeNMQkDrM89p9iXeEGHQrEcgN4UPmquQ8xB5HHpRJRomhqsvpasZJKuqtrQH4raT9WHrOikpW31P1g2tiRmva3-FYdpHwtM10gQaVBJeqSOqZdvqh1E_Q6DIb7FNwD0POfBOBE6m-D9fAYqERYybwNvDC8IdbhjHxn4gUH");
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
