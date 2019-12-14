package com.example.demo.dao.common;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BaseEntity;


public interface BaseDao <T extends BaseEntity> extends JpaRepository<T, Serializable> {

}
