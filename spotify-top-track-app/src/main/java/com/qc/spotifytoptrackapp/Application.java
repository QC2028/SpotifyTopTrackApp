package com.qc.spotifytoptrackapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qc.spotifytoptrackapp.client.SpotifyClient;
import com.qc.spotifytoptrackapp.repository.UserTopTrackRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private SpotifyClient spotifyClient;
	
	@Autowired
	private UserTopTrackRepository userRepository;
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Application start...");
		System.out.println(args[0]);
		String userId = args[0];
		

		System.out.println("the top track name is: " + spotifyClient.getTopTrackName());
        System.out.println("Application end...");
    }
	

}
