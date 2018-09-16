package com.flatmate.expanse.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flatmate.expanse.dao.CommonFlatmateAndAuthenticateDao;
import com.flatmate.expanse.dto.AuthenticationDto;
import com.flatmate.expanse.exception.AuthenticateException;
import com.flatmate.expanse.model.Authentication;
import com.flatmate.expanse.model.FlatMate;
import com.flatmate.expanse.repository.AuthenticationRepository;
import com.flatmate.expanse.repository.FlatMateRepository;

@Service
public class CommonFlatmateAndAuthenticateDaoImpl implements CommonFlatmateAndAuthenticateDao {
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
