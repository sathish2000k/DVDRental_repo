package com.dvdrental.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.dvdrental.dao.ActorDAO;
import com.dvdrental.dao.CategoryDAO;
import com.dvdrental.dao.FilmActorDAO;
import com.dvdrental.dao.FilmCategoryDAO;
import com.dvdrental.dao.FilmDAO;
import com.dvdrental.entity.Actor;
import com.dvdrental.entity.Film;
import com.dvdrental.enums.Language;
import com.dvdrental.utils.HibernateUtil;

@Component
public class FilmService {
	
	public List<String> getMoviesByActorName(String firstName, String lastName) {
		List<Film> movies = new ArrayList<Film>();
		
		try (Session session = HibernateUtil.getSession()) {
			
			ActorDAO actorDAO = new ActorDAO(session);
			Actor actor = actorDAO.getActorByActorName(firstName, lastName);
			
			System.out.println(actor.toString());
			
			FilmActorDAO filmactorDAO = new FilmActorDAO(session);
			List<Integer> filmIds = filmactorDAO.getFilmIdByActorId(actor.getActorId());
			
			FilmDAO filmDAO = new FilmDAO(session);
			movies = filmDAO.getFilmByFilmIds(filmIds);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<String> films = new ArrayList<>();
		movies.forEach(film -> films.add(film.toString()));
		
		return films;
	}
	
	public List<String> getActorsByFilmName(String filmName) {
		
		List<Actor> actorsList = new ArrayList<Actor>();
		
		try (Session session = HibernateUtil.getSession()) {
			
			FilmDAO filmDAO = new FilmDAO(session);
			Film film = filmDAO.getFilmByFilmName(filmName);
			
			FilmActorDAO filmActorDAO = new FilmActorDAO(session);
			List<Integer> actorIds = filmActorDAO.getActorIdByFilmId(film.getFilmId());
					
			ActorDAO actorDAO = new ActorDAO(session);
			actorsList = actorDAO.getActorByActorIds(actorIds);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<String> actors = new ArrayList<>();
		actorsList.forEach(actor -> actors.add(actor.toString()));
		
		return actors;
	}

	public List<String> getAllFilms() {
		
		List<Film> allFilms = new ArrayList<>();
		
		try (Session session = HibernateUtil.getSession()) {
			
			FilmDAO filmDAO = new FilmDAO(session);
			allFilms = filmDAO.getAllFilmList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<String> films = new ArrayList<String>();
		allFilms.forEach(film -> films.add(film.toString()));
		
		return films;
	}
	
	public List<String> getFilmsByLanguage(String language) {
		List<Film> allFilms = new ArrayList<>();
		
		try (Session session = HibernateUtil.getSession()) {
			
			Language languageObj = Language.ENGLISH;
			languageObj = languageObj.fromLanguage(language);
			
			FilmDAO filmDAO = new FilmDAO(session);
			allFilms = filmDAO.getFilmByLanguageId(languageObj.getId());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<String> films = new ArrayList<String>();
		allFilms.forEach(film -> films.add(film.toString()));
		
		return films;
		
	}

	public List<String> getFilmByCategory(String category) {
		
		List<Film> allFilms = new ArrayList<Film>();
		
		try (Session session=HibernateUtil.getSession()) {
			
			CategoryDAO categoryDAO = new CategoryDAO(session);
			int categoryId = categoryDAO.getCategoryIdByName(category);
			
			FilmCategoryDAO filmCategoryDAO = new FilmCategoryDAO(session);
			List<Integer> filmId = filmCategoryDAO.getFilmByCategory(categoryId);
			
			FilmDAO filmDAO = new FilmDAO(session);
			allFilms = filmDAO.getFilmByFilmIds(filmId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<String> films = new ArrayList<String>();
		allFilms.forEach(film -> films.add(film.toString()));
		
		return films;
	}
}
