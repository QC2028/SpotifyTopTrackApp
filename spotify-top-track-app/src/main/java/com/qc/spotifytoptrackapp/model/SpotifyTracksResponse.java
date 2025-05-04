package com.qc.spotifytoptrackapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SpotifyTracksResponse(
		List<SpotifyTrackItem> items
) {}
