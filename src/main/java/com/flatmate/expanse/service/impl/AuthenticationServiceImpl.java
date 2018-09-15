package com.flatmate.expanse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flatmate.expanse.repository.AuthenticationRepository;
import com.flatmate.expanse.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private AuthenticationRepository repository;

	@Override
	public AuthenticationRepository getRepository() {
		return this.repository;
	}

}
