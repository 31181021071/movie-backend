package com.tanya.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tanya.model.MCodes;
import com.tanya.model.MCodesId;

public interface MCodesRepository extends CrudRepository<MCodes, MCodesId> {
	List<MCodes> findByCodeType(String codeType);
}
