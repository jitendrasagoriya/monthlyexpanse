package com.flatmate.expanse.dao;

import org.springframework.stereotype.Service;

import com.flatmate.expanse.repository.ExpenseRepository;

@Service
public interface ExpenseDao {	
	public ExpenseRepository getRepository();	
}
