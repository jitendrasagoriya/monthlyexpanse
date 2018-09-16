package com.flatmate.expanse.dao;

import org.springframework.stereotype.Service;

import com.flatmate.expanse.model.FlatMate;
import com.flatmate.expanse.repository.FlatMateRepository;

@Service
public interface FlatmateDao {
	
	public FlatMateRepository getRepository();

	public FlatMate getFlatmateByEmailId(String email);

	public FlatMate getFlatmateByNickname(String nickname);
}
