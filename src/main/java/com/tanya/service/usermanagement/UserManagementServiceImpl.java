package com.tanya.service.usermanagement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tanya.constants.ApplicationConstants;
import com.tanya.dto.usermanagement.SearchUserConditionDto;
import com.tanya.dto.usermanagement.SearchUserResultDto;
import com.tanya.model.MUser;
import com.tanya.repository.MUserRepository;

@Service
public class UserManagementServiceImpl implements UserManagementService {
	
	@Autowired
	private MUserRepository mUserRepository;

	@Override
	public Page<SearchUserResultDto> searchUser(SearchUserConditionDto dto) {
		Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize());
		List<MUser> usersList = new ArrayList<MUser>();
		long totalUser = 0;
		if (StringUtils.hasText(dto.getEmail()) && StringUtils.hasText(dto.getName())) {
			Page<MUser> usersPage = mUserRepository.findByNameContainingAndEmailContaining(dto.getName(), dto.getEmail(), pageable);
			usersList = usersPage.getContent(); 
			totalUser = usersPage.getTotalElements();
		} else if (!StringUtils.hasText(dto.getEmail()) && StringUtils.hasText(dto.getName())) {
			Page<MUser> usersPage = mUserRepository.findByNameContaining(dto.getName(), pageable);
			usersList = usersPage.getContent(); 
			totalUser = usersPage.getTotalElements();
		} else if (StringUtils.hasText(dto.getEmail()) && !StringUtils.hasText(dto.getName())) {
			Page<MUser> usersPage = mUserRepository.findByEmailContaining(dto.getEmail(), pageable);
			usersList = usersPage.getContent(); 
			totalUser = usersPage.getTotalElements();
		} else if (!StringUtils.hasText(dto.getEmail()) && !StringUtils.hasText(dto.getName())) {
			Page<MUser> usersPage = mUserRepository.findAll(pageable);
			usersList = usersPage.getContent(); 
			totalUser = usersPage.getTotalElements();
		}
		List<SearchUserResultDto> dtoList = new ArrayList<SearchUserResultDto>();
		for (MUser user: usersList) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ApplicationConstants.DATETIME_FORMAT);
	        String createDt = Objects.isNull(user.getCreateDt()) ? null : user.getCreateDt().format(formatter);
			SearchUserResultDto dtoResult = new SearchUserResultDto(user.getName(), user.getEmail(), user.isEnable(), user.getId(), createDt);
			dtoList.add(dtoResult);
		} 
		
		return new PageImpl<>(dtoList, pageable, totalUser);
	}

	@Override
	public MUser changeEnableUser(MUser user) {
		MUser existUser = mUserRepository.findByEmail(user.getEmail());
		if (Objects.isNull(existUser)) {
			return null;
		}
		existUser.setEnable(user.isEnable());
		existUser.setUpdateBy(user.getEmail());
		existUser.setUpdateDt(LocalDateTime.now());
		MUser updateUser = mUserRepository.save(existUser);
		return updateUser;
	}

}
