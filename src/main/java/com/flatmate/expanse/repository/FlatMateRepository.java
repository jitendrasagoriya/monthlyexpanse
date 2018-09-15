package com.flatmate.expanse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flatmate.expanse.model.FlatMate;

@Repository(value="flatmate")
public interface FlatMateRepository extends JpaRepository<FlatMate, Long> {

}
