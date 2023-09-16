package com.dvdrental.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.dvdrental.dao.ActorDAO;
import com.dvdrental.entity.Actor;
import com.dvdrental.utils.HibernateUtil;

@Component
public class ActorService {
	
	public List<String> getAllActors() {
		List<Actor> actorList = new ArrayList<>();
		
		try (Session session = HibernateUtil.getSession()) {
			ActorDAO actorDAO = new ActorDAO(session);
			actorList = actorDAO.getAllActorsList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<String> actors = new ArrayList<>();
		actorList.forEach(actor -> actors.add(actor.toString()));
		
		return actors;
	}
}
