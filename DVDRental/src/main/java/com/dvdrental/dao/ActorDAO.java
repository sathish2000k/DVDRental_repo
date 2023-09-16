package com.dvdrental.dao;

import java.util.List;

import org.hibernate.Session;

import com.dvdrental.entity.Actor;

public class ActorDAO {
	private Session sqlSession;
	
	public ActorDAO(Session sqlSession) {
		this.sqlSession = sqlSession;
	}

	public Actor getActorByActorId(int id) {
		Actor actor = sqlSession.get(Actor.class, id);
		return actor;
	}
	
	@SuppressWarnings("deprecation")
	public Actor getActorByActorName(String firstName, String lastName) {
		Actor actor = (Actor) sqlSession.createQuery("from actor where firstName = :first_name and lastName = :last_name")
				.setParameter("first_name", firstName)
				.setParameter("last_name", lastName)
				.uniqueResult();
		
		return actor;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Actor> getActorByActorIds(List<Integer> actorIds) {
		// TODO Auto-generated method stub
		List<Actor> actors = (List<Actor>) sqlSession.createQuery("from actor where actorId in (:actor_ids)")
				.setParameter("actor_ids", actorIds)
				.getResultList();
		
		return actors;
	}

	public List<Actor> getAllActorsList() {
		
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Actor> allActorList = (List<Actor>) sqlSession.createQuery("from actor")
				.getResultList();
		return allActorList;
		
	}
}
