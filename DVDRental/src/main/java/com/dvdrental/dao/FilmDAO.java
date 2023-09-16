package com.dvdrental.dao;

import java.util.List;
import org.hibernate.Session;

import com.dvdrental.entity.Film;

public class FilmDAO {
	private Session sqlSession;
	
	public FilmDAO(Session sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Film> getFilmByFilmIds(List<Integer> filmIds) {
		
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Film> movies = (List<Film>) sqlSession.createQuery("from film where filmId in (:film_id)")
				.setParameter("film_id", filmIds)
				.getResultList();
		
		return movies;
	}
	
	public Film getFilmByFilmName(String filmName) {
		@SuppressWarnings({ "deprecation" })
		Film film = (Film) sqlSession.createQuery("from film where title in (:film_name)")
				.setParameter("film_name", filmName)
				.uniqueResult();
		
		return film;
	}

	public List<Film> getAllFilmList() {
		
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Film> allFilms = (List<Film>) sqlSession.createQuery("from film")
				.getResultList();
		return allFilms;
	}

	public List<Film> getFilmByLanguageId(int languageId) {
		
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Film> allFilms = (List<Film>) sqlSession.createQuery("from film where languageId = :language_id")
				.setParameter("language_id", languageId)
				.getResultList();
		return allFilms;
		
	}	
	
}
