package com.dvdrental.dao;

import java.util.List;

import org.hibernate.Session;

public class FilmActorDAO {
	private Session sqlSession;
	
	public FilmActorDAO(Session sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Integer> getFilmIdByActorId(int Id) {
		
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Integer> filmIds = (List<Integer>) sqlSession.createQuery("select filmId from film_actor where actorId = :actor_id ")
				.setParameter("actor_id", Id)
				.getResultList();
		
		return filmIds;
	}
	
	public List<Integer> getActorIdByFilmId(int Id) {
		
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Integer> ActorIds = (List<Integer>) sqlSession.createQuery("select actorId from film_actor where filmId = :film_id ")
				.setParameter("film_id", Id)
				.getResultList();
		
		return ActorIds;
	}
	
}
