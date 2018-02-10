package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.PersonDao;
import com.test.entity.Person;

@Transactional
@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;
	
	public void add(Person person) {
       personDao.add(person);
	}

	public void update(Person person) {
       personDao.update(person);
	}


	public List<Person> gets() {
		return personDao.gets();
	}
	
	public void deletebyId(String id) {
		personDao.deletebyId(id);  		
	}

    public Person getbyId(String id) {
		return personDao.getbyId(id);
	}
}
