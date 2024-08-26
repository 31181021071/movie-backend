package com.tanya.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tanya.model.MUser;

@Repository
public interface MUserRepository extends CrudRepository<MUser, Integer> {

	MUser findByEmail(String email);
    
}
