package com.dvdrental.entity;

import java.sql.Timestamp;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name="film_category")
@Table(name="film_category")
public class FilmCategory {
	@EmbeddedId
	private FilmCategoryId id;
	@Column(name="film_id")
	private int filmId;
	@Column(name="category_id")
	private int categoryId;
	@Column(name="last_update")
	private Timestamp lastUpdate;
	
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}

@Embeddable
public class FilmCategoryId implements Serializable {
	private int filmId;
	private int categoryId;
}
