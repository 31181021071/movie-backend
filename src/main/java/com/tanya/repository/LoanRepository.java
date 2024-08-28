package com.tanya.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tanya.model.Loans;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Integer> {
	
	List<Loans> findByUserIdOrderByStartDtDesc(int customerId);

}
