package com.tanya.service.profile;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tanya.model.MUser;
import com.tanya.repository.MUserRepository;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private MUserRepository mUserRepository;

	@Override
	public MUser updateProfile(MUser user) {
		MUser existUser = mUserRepository.findByEmail(user.getEmail());
		if (Objects.isNull(existUser)) {
			return null;
		}
		existUser.setName(user.getName());
		existUser.setUpdateBy(user.getEmail());
		existUser.setUpdateDt(LocalDateTime.now());
		MUser updateUser = mUserRepository.save(existUser);
		return updateUser;
	}

}
