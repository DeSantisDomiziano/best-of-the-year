package org.java.bestoftheyear.controller;

import java.util.ArrayList;
import java.util.List;
import org.java.bestoftheyear.model.Movie;
import org.java.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

	@GetMapping("/")
	public String index(Model model) {
		
		final String name = "Dom";
		model.addAttribute("name", name);
		
		return "web-index";
	}
	
	@GetMapping("/movie")
	public String movie(Model model) {
		
		List<Movie> movies = getBestMovies();
		
		model.addAttribute("movies", movies);
		
		return "movie";
	}
	
	@GetMapping("/song")
	public String song(Model model) {
		
		List<Song> songs = getBestSongs();
		
		model.addAttribute("songs", songs);
		
		return "song";
	}
	
	private List<Movie> getBestMovies() {
		List<Movie> movies = new ArrayList<>();
		
		for(int i = 1; i < 6; i++) {
			movies.add(new Movie("Movie " + i));
		}
		
		return movies;
	}
	
	private List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<>();
		
		for(int i = 1; i < 6; i++) {
			songs.add(new Song("Song" + i));
		}
		
		return songs;
	}
}
