package com.flatmate.expanse.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flatmate.expanse.dao.ExpenseDao;
import com.flatmate.expanse.repository.ExpenseRepository;

@Service
public class ExpenseDaoImpl implements ExpenseDao {
	
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
