/**
 * 
 */
package com.flatmate.expanse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.flatmate.expanse.repository.ExpenseRepository;
import com.flatmate.expanse.service.ExpenseService;

/**
 * @author jitendra sagoriya
 *
 */
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository repository;
	
	/* (non-Javadoc)
	 * @see com.flatmate.expanse.service.ExpenseService#getRepository()
	 */
	@Override
	public ExpenseRepository getRepository() {
		return this.repository;
	}

}
