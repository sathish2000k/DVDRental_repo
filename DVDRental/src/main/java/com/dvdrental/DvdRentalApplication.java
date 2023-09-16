package com.dvdrental;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.dvdrental.dao.ActorDAO;
import com.dvdrental.dao.FilmActorDAO;
import com.dvdrental.dao.FilmDAO;
import com.dvdrental.entity.Actor;
import com.dvdrental.entity.Film;
import com.dvdrental.utils.HibernateUtil;



@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}) 
public class DvdRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvdRentalApplication.class, args);
		
	}

}
