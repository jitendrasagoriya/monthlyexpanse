package com.flatmate.expanse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flatmate.expanse.dto.AuthenticationDto;
import com.flatmate.expanse.exception.AuthenticateException;
import com.flatmate.expanse.model.Authentication;
import com.flatmate.expanse.model.FlatMate;
import com.flatmate.expanse.repository.AuthenticationRepository;
import com.flatmate.expanse.repository.FlatMateRepository;
import com.flatmate.expanse.service.CommonFlatmateAndAuthenticateService;

@Service
public class CommonFlatmateAndAuthenticateServiceImpl implements CommonFlatmateAndAuthenticateService {
	
	
	@Autowired
	private AuthenticationRepository authenticationRepository;
	
	@Autowired
	private FlatMateRepository flatMateRepository;

	@Override
	public AuthenticationDto getAuthenticate(String userName, String password) throws AuthenticateException {
		
		Authentication authentication = authenticationRepository.getAuthenticationByUserNameAndPassword(userName, password);
		if (authentication == null) {
			throw new AuthenticateException();
		}
		
		FlatMate flatMate = flatMateRepository.findById(authentication.getFlatmateId()).get();
		AuthenticationDto authenticationDto = new AuthenticationDto(flatMate.getName(), authentication.getAccessToken(),
				authentication.getTokenTimeout(),flatMate.getEmail());

		return authenticationDto;		 
	}

}
