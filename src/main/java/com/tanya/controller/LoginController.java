package com.tanya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanya.constants.ApplicationConstants;
import com.tanya.model.MUser;
import com.tanya.service.login.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody MUser user) {
    	ResponseEntity<String> response = null;
        try {
        	MUser users = loginService.checkEmailExist(user.getEmail());
        	if (StringUtils.hasText(users.getEmail())) {
        		response = ResponseEntity
                        .status(HttpStatus.OK)
                        .body(ApplicationConstants.W0001);
        		return response;
        	}
        	loginService.registerUser(user);
        	response = ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Given user details are successfully registered");
        } catch (Exception ex) {
        	response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping("/user")
    public MUser getUserDetailsAfterLogin(Authentication authentication) {
        MUser users = loginService.getUserDetailsAfterLogin(authentication.getName());
        return users;
    }

}
