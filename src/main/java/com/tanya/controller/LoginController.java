package com.tanya.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody MUser user) {
    	Map<String, String> response = new HashMap<String, String>() ;
        try {
        	MUser existUser = loginService.checkEmailExist(user.getEmail());
        	if (!Objects.isNull(existUser)) {
        		response.put("code", ApplicationConstants.W0001);
        		return ResponseEntity.ok(response);
        	}
        	loginService.registerUser(user);
        	response.put("code", ApplicationConstants.I0001);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	response.put("code", ApplicationConstants.E0001);
        }
        return ResponseEntity.ok(response);
    }

    @RequestMapping("/user")
    public MUser getUserDetailsAfterLogin(Authentication authentication) {
    	MUser users = new MUser();
    	try {
            users = loginService.getUserDetailsAfterLogin(authentication.getName());
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		users = null;
    	}

        return users;
    }

}
