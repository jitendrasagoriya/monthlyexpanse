package com.flatmate.expanse.dao;

import org.springframework.stereotype.Service;

import com.flatmate.expanse.dto.AuthenticationDto;
import com.flatmate.expanse.exception.AuthenticateException;


@Service
public interface CommonFlatmateAndAuthenticateDao {
	
	public AuthenticationDto getAuthenticate(String userName, String password) throws AuthenticateException;
}
