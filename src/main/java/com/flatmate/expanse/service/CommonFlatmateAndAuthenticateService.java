package com.flatmate.expanse.service;

import org.springframework.stereotype.Service;

import com.flatmate.expanse.dto.AuthenticationDto;
import com.flatmate.expanse.exception.AuthenticateException;

@Service
public interface CommonFlatmateAndAuthenticateService {
	
	public AuthenticationDto getAuthenticate(String userName, String password) throws AuthenticateException;

}
