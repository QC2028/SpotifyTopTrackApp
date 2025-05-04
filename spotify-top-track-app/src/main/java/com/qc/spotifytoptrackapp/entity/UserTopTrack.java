package com.qc.spotifytoptrackapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "user_top_track")

@Entity
public class UserTopTrack {
	private Integer id;
	private String userId;
	private String topTrackName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTopTrackName() {
		return topTrackName;
	}
	public void setTopTrackName(String topTrackName) {
		this.topTrackName = topTrackName;
	}
}
