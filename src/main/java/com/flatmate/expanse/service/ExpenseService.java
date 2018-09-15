/**
 * 
 */
package com.flatmate.expanse.service;

import org.springframework.stereotype.Service;

import com.flatmate.expanse.repository.ExpenseRepository;

/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface ExpenseService {
	
	 public ExpenseRepository getRepository();	 
}
