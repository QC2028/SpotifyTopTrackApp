package com.qc.spotifytoptrackapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qc.spotifytoptrackapp.client.SpotifyClient;
import com.qc.spotifytoptrackapp.entity.UserTopTrack;
import com.qc.spotifytoptrackapp.repository.UserTopTrackRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private SpotifyClient spotifyClient;
	
	@Autowired
	private UserTopTrackRepository userRepository;
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args).close();;
    }

    @Override
    public void run(String... args) {
        System.out.println("Application start...");
        String userId = args[0];
        

		
		UserTopTrack topTrackRecord = userRepository.findByUserId(userId);  //topTrackRecord is the one from the db, we want to compare it to the one we get from spotifyClient
		if (topTrackRecord == null) { //create new record for the db if it doesnt already exist for the user, user id is passed in through run config arguments
			topTrackRecord = new UserTopTrack();
			topTrackRecord.setUserId(userId);
		}
		String spotifyTopTrackName = spotifyClient.getTopTrackName();
		if (!topTrackRecord.getTopTrackName().equals(spotifyTopTrackName)){
				System.out.println("You have a new top track! ");
				topTrackRecord.setTopTrackName(spotifyTopTrackName);
				userRepository.save(topTrackRecord);
		}
        
		System.out.println("the top track name is: " + spotifyTopTrackName);
		
		System.out.println(topTrackRecord.getTopTrackName());
    }
	

}
