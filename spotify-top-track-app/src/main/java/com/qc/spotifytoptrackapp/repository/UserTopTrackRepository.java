package com.qc.spotifytoptrackapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qc.spotifytoptrackapp.entity.UserTopTrack;

@Repository
public interface UserTopTrackRepository extends JpaRepository<UserTopTrack, Long> {
	
	// Fetch all top tracks for a given userId
    UserTopTrack findByUserId(String userId);
}
