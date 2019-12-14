package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.dao.common.BaseDao;

@Repository
public interface CourseJpaRepository extends BaseDao<Course> {

}
