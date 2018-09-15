package com.flatmate.expanse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flatmate.expanse.model.Authentication;

@Repository(value="authentication")
public interface AuthenticationRepository  extends JpaRepository<Authentication, String>  {

}
