package com.dvdrental.enums;

public enum Language {
	ENGLISH(1,"English"),
	ITALIAN(2,"Italian"),
	JAPANESE(3,"Japanese"),
	MANDARIN(4,"Mandarin"),
	FRENCH(5,"French"),
	GERMAN(6,"German");

	private final int id;
	private final String language;	
	
	Language(int id, String language) {
		this.id = id;
		this.language = language;
	}
	
	public int getId() {
		return id;
	}

	public String getLanguage() {
		return language;
	}
	
	public Language fromLanguage(String languageName) {
		Language language;
		switch(languageName.toUpperCase()) {
			case "ENGLISH": 
				language = ENGLISH;
				break;
			case "ITALIAN":
				language = ITALIAN;
				break;
			case "JAPANESE":
				language =  JAPANESE;
				break;
			case "MANDARIN":
				language = MANDARIN;
				break;
			case "FRENCH":
				language = FRENCH;
				break;
			case "GERMAN":
				language =  GERMAN;
				break;
			default:
				throw new IllegalArgumentException("Invalid language: "+languageName);
			
		}
		
		return language;
	}

}
