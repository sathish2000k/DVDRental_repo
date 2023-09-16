package com.dvdrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dvdrental.service.FilmService;

@RestController
@RequestMapping("/film")
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	@GetMapping("actor")
	public List<String> getFilmsByActorName(@RequestParam String firstName, @RequestParam String lastName) {
		
		List<String> film = filmService.getMoviesByActorName(firstName, lastName);
		return film;
		
	}
	
	@GetMapping("/all") 
	public List<String> listAllFilms() {
		List<String> allFilms = filmService.getAllFilms();
		return allFilms;
	}
	
	@GetMapping("/language")
	public List<String> filmLanguage(@RequestParam String language) {
		
		List<String> allFilms = filmService.getFilmsByLanguage(language);
		return allFilms;
	}
	
	@GetMapping("/category")
	public List<String> listFilmByCategory(@RequestParam String category) {
		
		List<String> allFilms = filmService.getFilmByCategory(category);
		return allFilms;
	}
	
	
}
