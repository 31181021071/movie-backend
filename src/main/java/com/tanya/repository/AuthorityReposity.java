package com.tanya.repository;

import org.springframework.data.repository.CrudRepository;

import com.tanya.model.Authority;

public interface AuthorityReposity extends CrudRepository<Authority, Long> {

}
