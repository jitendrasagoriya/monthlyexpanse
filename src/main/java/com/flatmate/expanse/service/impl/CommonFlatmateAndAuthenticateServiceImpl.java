package com.flatmate.expanse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flatmate.expanse.dao.CommonFlatmateAndAuthenticateDao;
import com.flatmate.expanse.dto.AuthenticationDto;
import com.flatmate.expanse.exception.AuthenticateException;
import com.flatmate.expanse.service.CommonFlatmateAndAuthenticateService;

@Service
public class CommonFlatmateAndAuthenticateServiceImpl implements CommonFlatmateAndAuthenticateService {
	
	@Autowired
	private CommonFlatmateAndAuthenticateDao dao;

	@Override
	public AuthenticationDto getAuthenticate(String userName, String password) throws AuthenticateException {
		return dao.getAuthenticate(userName, password);
	}
	
	
	

}
