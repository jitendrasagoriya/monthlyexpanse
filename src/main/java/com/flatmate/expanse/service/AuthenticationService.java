package com.flatmate.expanse.service;

import org.springframework.stereotype.Service;

import com.flatmate.expanse.model.Authentication;

@Service
public interface AuthenticationService {

	public Authentication save(Authentication authentication);

	public Boolean checkAuthentication(String accessToken);

	public Authentication getAuthentication(String accessToken);

	public Boolean updateLastLogin(Long id);

	public Boolean updateAccessTokenAndLastLogin(String newAccessToken, String accessToken);

}
