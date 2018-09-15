/**
 * 
 */
package com.flatmate.expanse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flatmate.expanse.repository.FlatMateRepository;
import com.flatmate.expanse.service.FlatmateService;

/**
 * @author lenovo
 *
 */
@Service
public class FlatmateServiceImpl implements FlatmateService {
	
	@Autowired
	private FlatMateRepository repository;

	@Override
	public FlatMateRepository getRepository() {
		return this.repository;
	}

}
