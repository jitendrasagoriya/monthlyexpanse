package com.flatmate.expanse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flatmate.expanse.model.Expense;

@Repository(value="expense")
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
