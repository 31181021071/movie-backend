package com.tanya.service.login;

import com.tanya.model.MUser;

public interface LoginService {
	MUser checkEmailExist(String email);
	
	void registerUser(MUser mUser);

	MUser getUserDetailsAfterLogin(String email);
}
