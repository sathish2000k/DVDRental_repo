package com.dvdrental.dao;


import org.hibernate.Session;

public class CategoryDAO {
	private Session sqlSession;
	
	public CategoryDAO(Session sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int getCategoryIdByName (String name) {
		
		@SuppressWarnings("deprecation")
		int categoryId = (int) sqlSession.createQuery("select categoryId from category where name = :name")
				.setParameter("name", name)
				.uniqueResult();
		
		return categoryId;
		
	}
	
	public String getCategoryNameById(String id) {
		
		@SuppressWarnings("deprecation")
		String categoryName = (String) sqlSession.createQuery("select name from category where categoryId = :id")
				.setParameter("id", id)
				.uniqueResult();
		
		return categoryName;
	}
}
