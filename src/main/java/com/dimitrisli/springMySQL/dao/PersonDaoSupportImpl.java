package com.dimitrisli.springMySQL.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.dimitrisli.springMySQL.model.Person;


public class PersonDaoSupportImpl extends JdbcDaoSupport implements PersonDao{

	public void createPerson(String name, String surname) {
		getJdbcTemplate().update("INSERT INTO PERSON_RECORD (NAME,SURNAME) VALUES (?,?)",
				new Object[]{name,surname});
	}

	public List<Person> selectPerson(String name, String surname) {
		return getJdbcTemplate().query("SELECT NAME,SURNAME FROM PERSON_RECORD WHERE NAME=? AND SURNAME=?",
				new Object[] {name,surname},
				new PersonRowMapper());
	}

	public List<Person> selectAll() {
		return getJdbcTemplate().query("SELECT NAME,SURNAME FROM PERSON_RECORD",
				new PersonRowMapper());
	}

	public void deletePerson(String name, String surname) {
		getJdbcTemplate().update("DELETE FROM PERSON_RECORD WHERE NAME=? AND SURNAME=?",
				new Object[]{name,surname});
	}

	public void deleteAll() {
		getJdbcTemplate().update("DELETE FROM PERSON_RECORD");
	}

	
}
