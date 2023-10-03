package org.java.bestoftheyear.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
	
	@GetMapping("/movies/{id}")
    public String getMovieDetails(@PathVariable int id, Model model) {
			Movie movie = findMovieById(id);
        
            model.addAttribute("movie", movie);
            return "single-movie";
    }
	
	@GetMapping("/songs/{id}")
    public String getSongDetalis(@PathVariable int id, Model model) {
			Song song = findSongById(id);
        
            model.addAttribute("song", song);
            return "single-song";
    }
	
	@GetMapping("/song")
	public String song(Model model) {
		
		List<Song> songs = getBestSongs();
		
		model.addAttribute("songs", songs);
		
		return "song";
	}
	
	private List<Movie> getBestMovies() {
		List<Movie> movies = new ArrayList<>();
		
			movies.add(new Movie("Movie 1",1));
			movies.add(new Movie("Movie 2",2));
			movies.add(new Movie("Movie 3",3));
			
		return movies;
	}
	
	private List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<>();
		
		songs.add(new Song(1,"Song 1"));
		songs.add(new Song(2,"Song 2"));
		songs.add(new Song(3,"Song 3"));
		
		return songs;
	}
	
	private Movie findMovieById(int id) {
	    List<Movie> movies = getBestMovies();
	    
	    Movie filteredMovies = movies.stream()
	                 .filter(movie -> movie.getId() == id)
	                 .toList().get(0);
	    return filteredMovies;
	}
	
	private Song findSongById(int id) {
	    List<Song> songs = getBestSongs();
	    
	    Song filteredSongs = songs.stream()
	                 .filter(song -> song.getId() == id)
	                 .toList().get(0);
	    return filteredSongs;
	}
	
}
