package com.tanya.service.moviemanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanya.constants.ApplicationConstants;
import com.tanya.dto.moviemanagement.InitMovieManagementDto;
import com.tanya.model.MCodes;
import com.tanya.repository.MCodesRepository;

@Service
public class MovieManagementServiceImpl implements MovieManagementService {
	
	@Autowired
	private MCodesRepository mCodesRepository;

	@Override
	public InitMovieManagementDto getInitMovieManagement() {
		List<MCodes> listCountry = mCodesRepository.findByCodeType(ApplicationConstants.MCODES_COUNTRY);
		InitMovieManagementDto dto = new InitMovieManagementDto();
		dto.setListCountry(listCountry);
		return dto;
	}

}
