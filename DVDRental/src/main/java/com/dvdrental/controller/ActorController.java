package com.dvdrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dvdrental.entity.Actor;
import com.dvdrental.entity.Film;
import com.dvdrental.service.ActorService;
import com.dvdrental.service.FilmService;

@RestController
@RequestMapping("/actor")
public class ActorController {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private ActorService actorService;
	
	@GetMapping("/film")
	public List<String> getActorsByFilmName(@RequestParam String filmName) {
		List<String> actors = filmService.getActorsByFilmName(filmName);
		return actors;
	}
	
	@GetMapping("/all") 
	public List<String> listAllFilms() {
		List<String> allFilms = actorService.getAllActors();
		return allFilms;
	}
}
