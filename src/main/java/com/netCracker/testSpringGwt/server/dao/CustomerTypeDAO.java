package com.netCracker.testSpringGwt.server.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO;

@Repository("customerTypeDAO")
public class CustomerTypeDAO extends JpaDAO<Long, CustomerTypeDTO> {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@PostConstruct
	public void init() {
		super.setEntityManagerFactory(entityManagerFactory);
	}
}
