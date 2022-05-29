package com.rra.base.persistence.repository.sql;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rra.base.persistence.LoanRequest;

public interface LoanRequestRepository extends CrudRepository<LoanRequest, Long> {
	List<LoanRequest> findBySsnAndStatus(String ssn, String status);
}
