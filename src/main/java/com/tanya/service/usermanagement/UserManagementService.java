package com.tanya.service.usermanagement;

import org.springframework.data.domain.Page;

import com.tanya.dto.usermanagement.SearchUserConditionDto;
import com.tanya.dto.usermanagement.SearchUserResultDto;
import com.tanya.model.MUser;

public interface UserManagementService {

	Page<SearchUserResultDto> searchUser(SearchUserConditionDto dto);
	
	MUser changeEnableUser(MUser user);
}
