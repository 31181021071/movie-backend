package com.tanya.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tanya.model.MUser;

@Repository
public interface MUserRepository extends CrudRepository<MUser, Integer> {

	MUser findByEmail(String email);
	
	Page<MUser> findByNameContaining(String name, Pageable pageable);
	
	Page<MUser> findByEmailContaining(String name, Pageable pageable);
	
	Page<MUser> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable);
	
	Page<MUser> findAll(Pageable pageable);
    
}
