package com.flatmate.expanse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flatmate.expanse.dao.AuthenticationDao;
import com.flatmate.expanse.model.Authentication;
import com.flatmate.expanse.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private AuthenticationDao authenticationDao;

	@Override
	public Boolean checkAuthentication(String accessToken) {
		return authenticationDao.checkAuthentication(accessToken);
	}

	@Override
	public Authentication getAuthentication(String accessToken) {
		return authenticationDao.getAuthentication(accessToken);
	}

	@Override
	public Boolean updateLastLogin(Long id) {
		return authenticationDao.updateLastLogin(id);
	}

	@Override
	public Boolean updateAccessTokenAndLastLogin(String newAccessToken, String accessToken) {
		return authenticationDao.updateAccessTokenAndLastLogin(newAccessToken, accessToken);
	}

	@Override
	public Authentication save(Authentication authentication) {
		return authenticationDao.getRepository().save(authentication);
	}

	

	
}
