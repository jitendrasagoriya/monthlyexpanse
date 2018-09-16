/**
 * 
 */
package com.flatmate.expanse.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.flatmate.expanse.dao.FlatmateDao;
import com.flatmate.expanse.dto.FlatmateDto;
import com.flatmate.expanse.model.FlatMate;
import com.flatmate.expanse.service.FlatmateService;

/**
 * @author lenovo
 *
 */
@Service
public class FlatmateServiceImpl implements FlatmateService {
	
	Logger logger = LoggerFactory.getLogger(FlatmateServiceImpl.class);
	
	@Autowired
	private FlatmateDao dao;

	@Override
	public FlatMate getFlatmateByEmailId(String email) {
		return dao.getFlatmateByEmailId(email);
	}

	@Override
	public FlatMate getFlatmateByNickname(String nickname) {
		return dao.getFlatmateByNickname(nickname);
	}

	@Override
	public FlatMate findById(Long id) {
		return dao.getRepository().findById(id).get();
	}

	@Override
	public List<FlatMate> findAll(Pageable pageable) {
		return dao.getRepository().findAll();
	}

	@Override
	public FlatMate save(FlatMate flatMate) {
		return dao.getRepository().save(flatMate);
	}

	@Override
	public Boolean deleteById(Long id) {
		try {
			dao.getRepository().deleteById(id);
			return Boolean.TRUE;
		}catch (Exception e) {
			  logger.error("Unable to delete flatmate : Flatmate Id :"+id, e);
		}
		return Boolean.FALSE;
	}
	

}
