package com.SpringBootAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootAPI.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

}
