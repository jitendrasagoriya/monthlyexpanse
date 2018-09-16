package com.flatmate.expanse.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flatmate.expanse.dao.FlatmateDao;
import com.flatmate.expanse.model.FlatMate;
import com.flatmate.expanse.repository.FlatMateRepository;

@Service
public class FlatmateDaoImpl implements FlatmateDao {

	@Autowired
	private FlatMateRepository repository;

	@Override
	public FlatMateRepository getRepository() {
		return this.repository;
	}

	@Override
	public FlatMate getFlatmateByEmailId(String email) {
		return repository.getByEmail(email);
	}

	@Override
	public FlatMate getFlatmateByNickname(String nickname) {
		return repository.getByNickName(nickname);
	}
}
