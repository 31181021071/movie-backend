package com.tanya.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tanya.constants.ApplicationConstants;
import com.tanya.dto.usermanagement.SearchUserConditionDto;
import com.tanya.dto.usermanagement.SearchUserResultDto;
import com.tanya.model.MUser;
import com.tanya.service.usermanagement.UserManagementService;

@RestController
public class UserManagementController {

	@Autowired
	private UserManagementService userManagementService;
	
	@PostMapping("/search-user")
	public Page<SearchUserResultDto> searchUser(@RequestBody SearchUserConditionDto dto) {
		return userManagementService.searchUser(dto);
	}
	
	@PostMapping("/change-enable-user")
	public ResponseEntity<Map<String, String>> updateProfile(@RequestBody MUser user) {
		Map<String, String> response = new HashMap<String, String>() ;
        try {
        	MUser updateUser = userManagementService.changeEnableUser(user);
        	if (Objects.isNull(updateUser)) {
        		response.put("code", ApplicationConstants.W0002);
        		return ResponseEntity.ok(response);
        	}
        	response.put("code", ApplicationConstants.I0002);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	response.put("code", ApplicationConstants.E0001);
        }
        return ResponseEntity.ok(response);
	}
}
