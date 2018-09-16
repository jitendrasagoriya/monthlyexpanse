package com.flatmate.expanse.dao.impl;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flatmate.expanse.dao.AuthenticationDao;
import com.flatmate.expanse.model.Authentication;
import com.flatmate.expanse.repository.AuthenticationRepository;


@Service
public class AuthenticationDaoImpl implements AuthenticationDao {
	@Autowired
	private AuthenticationRepository repository;
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public AuthenticationRepository getRepository() {
		return this.repository;
	}
	
	@Override
	public Authentication getAuthentication(String accessToken) {		 
		return repository.checkAuthentication(accessToken);
	}


	@Transactional
	@Override
	public Boolean checkAuthentication(String accessToken) {
		if (repository.checkAuthentication(accessToken) != null)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	@Override
	public Boolean updateLastLogin(Long id) {	
		Query query = em.createQuery("UPDATE Authentication A SET A.lastlogin = :lastlogin WHERE A.fid = :fid");
		query.setParameter("lastlogin", new Timestamp(System.currentTimeMillis()) );	
		query.setParameter("fid", id );	
		if(query.executeUpdate()>0)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	@Transactional
	@Override
	public Boolean updateAccessTokenAndLastLogin(String newAccessToken,String accessToken) {
		Query query = em.createQuery("UPDATE Authentication A SET A.lastLogin = :lastlogin,A.accessToken = :newAccessToken WHERE A.accessToken = :accessToken");
		query.setParameter("lastlogin", new Timestamp(System.currentTimeMillis()) );
		query.setParameter("newAccessToken", newAccessToken );
		query.setParameter("accessToken", accessToken );	
		if(query.executeUpdate()>0)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

}
