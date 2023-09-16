package com.dvdrental.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="film")
@Table(name="film")
public class Film {
	@Id
	@Column(name="film_id")
	private int filmId;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="release_year")
	private int year;
	@Column(name="language_id")
	private int languageId;
	@Column(name="rental_duration")
	private int rentalDuration;
	@Column(name="rental_rate")
	private float rentalRate;
	@Column(name="length")
	private int length;
	@Column(name="replacement_cost")
	private float replacementCost;
	@Column(name="rating")
	private String rating;
	@Column(name="last_update")
	private Timestamp lastUpdate;
	@Column(name="special_features")
	private String specialFeatures;
	@Column(name="fulltext")
	private String fullText;
	
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public int getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public float getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(float rentalRate) {
		this.rentalRate = rentalRate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(float replacementCost) {
		this.replacementCost = replacementCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	public String getFullText() {
		return fullText;
	}
	public void setFullText(String fullText) {
		this.fullText = fullText;
	}
	
	@Override
	public String toString() {
		return title + ", year=" + year;
	}
}
