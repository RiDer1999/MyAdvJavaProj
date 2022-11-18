 package com.springorm;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	// Insert Data.... & Save Student...
	@Transactional
	public int insert(Student student) {
		
			Integer i= (Integer)hibernateTemplate.save(student);
		return i;
		
	}
	
	// Get All Data....
	public List<Student> getAllRecord() {
		List <Student> list = this.hibernateTemplate.loadAll(Student.class);
		return list;
	}
	
	// Delete Record.....
	@Transactional
	public void deleteRecord(int id) {
		
		Student st = this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(st);
	}
	
	// Update Record....
	@Transactional
	public void updateRecord(int id, String name, String city) {
		
		Student st = this.hibernateTemplate.get(Student.class, id);
		st.setStudent_name(name);
		st.setStudent_city(city);
		this.hibernateTemplate.update(st);
	}
	
	// Show Specific Record....
	public Student getSingleRecord(int id) {
		
		Student st = this.hibernateTemplate.get(Student.class, id);
		return st;
	}


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	
	

}
