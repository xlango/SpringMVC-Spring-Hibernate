package com.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.test.dao.PersonDao;
import com.test.entity.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	@Resource
	private SessionFactory sessionFactory;			
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(Person person) {
        this.getSession().save(person);
	}

	public void update(Person person) {
        this.getSession().update(person);
	}

	@SuppressWarnings("unchecked")
	public List<Person> gets() {
		return (List<Person>) this.getSession().createCriteria(Person.class).list();
	}

	public void deletebyId(String id) {
	   this.getSession().createQuery("delete Person where id=?")
	       .setParameter(0, id).executeUpdate();		
	}

	public Person getbyId(String id) {
		return (Person)this.getSession().createQuery("from Person where id=?")
			       .setParameter(0, id).uniqueResult();
	}

}
