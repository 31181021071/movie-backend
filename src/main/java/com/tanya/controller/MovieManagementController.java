package com.tanya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanya.dto.moviemanagement.InitMovieManagementDto;
import com.tanya.service.moviemanagement.MovieManagementService;

@RestController
public class MovieManagementController {

	@Autowired
	private MovieManagementService movieManagementService;
	
	@GetMapping("/movie-management-init")
	public ResponseEntity<InitMovieManagementDto> getInit() {
		InitMovieManagementDto dto = movieManagementService.getInitMovieManagement();
		return ResponseEntity.ok(dto);
	}
}
