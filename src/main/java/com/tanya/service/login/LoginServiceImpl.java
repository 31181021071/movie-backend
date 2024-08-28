package com.tanya.service.login;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tanya.constants.ApplicationConstants;
import com.tanya.model.Authority;
import com.tanya.model.MUser;
import com.tanya.repository.AuthorityReposity;
import com.tanya.repository.MUserRepository;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
    @Autowired
    private MUserRepository mUserRepository;
    
    @Autowired
    private AuthorityReposity authorityReposity;

    @Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public void registerUser(MUser mUser) {
		String hashPwd = passwordEncoder.encode(mUser.getPwd());
		mUser.setPwd(hashPwd);
		mUser.setRole("user");
		mUser.setName(mUser.getEmail());
		mUser.setCreateDt(LocalDateTime.now());
		mUser.setCreateBy(ApplicationConstants.ADMINISTRATOR);
		mUser.setUpdateDt(LocalDateTime.now());
		mUser.setUpdateBy(ApplicationConstants.ADMINISTRATOR);
		MUser newUser = mUserRepository.save(mUser);
		
		Authority authority = new Authority();
		authority.setUser(newUser);
		authority.setName(ApplicationConstants.ROLE_USER);
		authorityReposity.save(authority);
		
	}

	@Override
	public MUser getUserDetailsAfterLogin(String email) {
		MUser users = mUserRepository.findByEmail(email);
		return users;
	}

	@Override
	public MUser checkEmailExist(String email) {
		MUser users = mUserRepository.findByEmail(email);
		return users;
	}

}
