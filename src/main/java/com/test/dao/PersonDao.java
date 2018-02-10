package com.test.dao;

import java.util.List;

import com.test.entity.Person;

public interface PersonDao {

	public void add(Person person);
	
	public void update(Person person);
	
	public void deletebyId(String id);
	
	public List<Person> gets();
	
	public Person getbyId(String id);
}
