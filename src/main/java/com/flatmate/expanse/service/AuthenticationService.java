package com.flatmate.expanse.service;

import org.springframework.stereotype.Service;

import com.flatmate.expanse.repository.AuthenticationRepository;

@Service
public interface AuthenticationService {
	
	public AuthenticationRepository getRepository();

}
