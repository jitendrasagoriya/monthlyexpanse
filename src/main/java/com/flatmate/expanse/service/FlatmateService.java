package com.flatmate.expanse.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.flatmate.expanse.model.FlatMate;

@Service
public interface FlatmateService {	
	
	public FlatMate findById(Long id) ;
	
	public List<FlatMate> findAll(Pageable pageable);
	
	public FlatMate save(FlatMate flatMate);
	
	public Boolean deleteById(Long id);
	
	public FlatMate getFlatmateByEmailId(String email);

	public FlatMate getFlatmateByNickname(String nickname);
}
