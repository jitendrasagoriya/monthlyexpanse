package com.flatmate.expanse.service;

import org.springframework.stereotype.Service;

import com.flatmate.expanse.repository.FlatMateRepository;

@Service
public interface FlatmateService {	
	
	 public FlatMateRepository getRepository();	 

}
