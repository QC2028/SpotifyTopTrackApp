package com.qc.spotifytoptrackapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SpotifyTrackItem(
		String name
) {}
