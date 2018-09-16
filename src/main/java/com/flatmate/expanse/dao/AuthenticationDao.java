package com.flatmate.expanse.dao;

import org.springframework.stereotype.Service;

import com.flatmate.expanse.model.Authentication;
import com.flatmate.expanse.repository.AuthenticationRepository;

@Service
public interface AuthenticationDao {
	public AuthenticationRepository getRepository();

	public Boolean checkAuthentication(String accessToken);
	
	public Authentication getAuthentication(String accessToken);

	public Boolean updateLastLogin(Long id);
	
	public Boolean updateAccessTokenAndLastLogin(String newAccessToken,String accessToken);
}
