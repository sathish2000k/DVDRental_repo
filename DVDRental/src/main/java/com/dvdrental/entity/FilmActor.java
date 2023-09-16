package com.dvdrental.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name="film_actor")
@Table(name="film_actor")
public class FilmActor {
	@EmbeddedId
	private filmActorId id;
	@Column(name="actor_id")
	private int actorId;
	@Column(name="film_id")
	private int filmId;
	@Column(name="last_update")
	private Timestamp lastUpdate;
	
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}

@Embeddable
public class filmActorId implements Serializable {
	private int actorId;
	private int filmId;
}
