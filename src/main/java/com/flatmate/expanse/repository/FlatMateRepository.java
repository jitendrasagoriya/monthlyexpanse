package com.flatmate.expanse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flatmate.expanse.model.FlatMate;

@Repository(value="flatmate")
public interface FlatMateRepository extends JpaRepository<FlatMate, Long> {

	
	@Query("SELECT F FROM FlatMate F WHERE F.email = :email")
	public FlatMate getByEmail(@Param("email") String email);
	
	@Query("SELECT F FROM FlatMate F WHERE F.nickName = :nickName")
	public FlatMate getByNickName(@Param("nickName") String nickName);
}
