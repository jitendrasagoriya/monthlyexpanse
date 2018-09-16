package com.flatmate.expanse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flatmate.expanse.model.Authentication;

@Repository(value = "authentication")
public interface AuthenticationRepository extends JpaRepository<Authentication, String> {

	@Query("SELECT A FROM Authentication A WHERE A.accessToken = :accessToken")
	public Authentication checkAuthentication(@Param("accessToken") String accessToken);

	@Query("SELECT A FROM Authentication A WHERE A.userName = :userName AND A.password = :password")
	public Authentication getAuthenticationByUserNameAndPassword(@Param("userName") String userName,
			@Param("password") String password);

}
