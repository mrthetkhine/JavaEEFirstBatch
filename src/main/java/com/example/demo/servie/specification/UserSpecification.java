package com.example.demo.servie.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.dto.UserSearch;
import com.example.demo.model.User;

public class UserSpecification {

	public static Specification<User> getUserByNameOrEmail(UserSearch search)
	{
		return new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				
				Predicate name = criteriaBuilder.equal(root.get("name"), search.getName());
				Predicate email = criteriaBuilder.equal(root.get("email"), search.getEmail());
				
				return criteriaBuilder.or(name , email);
			}
		     
			
		    };
		
	}
}
