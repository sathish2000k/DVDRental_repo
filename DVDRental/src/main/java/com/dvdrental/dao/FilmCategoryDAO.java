package com.dvdrental.dao;

import java.util.List;

import org.hibernate.Session;

public class FilmCategoryDAO {
	private Session sqlSession;
	
	public FilmCategoryDAO(Session sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Integer> getFilmByCategory(int categoryId) {
		
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Integer> films = (List<Integer>) sqlSession.createQuery("select filmId from film_category where categoryId = :category_id")
				.setParameter("category_id", categoryId)
				.getResultList();
		
		return films;
	}
}
