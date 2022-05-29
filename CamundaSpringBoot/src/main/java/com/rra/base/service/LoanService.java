package com.rra.base.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rra.base.enums.LoanRequestStatusEnum;
import com.rra.base.exception.DAOException;
import com.rra.base.persistence.LoanRequest;
import com.rra.base.persistence.repository.sql.LoanRequestRepository;

@Component
public class LoanService {

	@Autowired
	private CamundaUtilService util;
	
	@Autowired
	private LoanRequestRepository lr ;
	
	public boolean isLoanRequestExists(String ssn) {
		List<LoanRequest> loanReqeusts = lr.findBySsnAndStatus(ssn, LoanRequestStatusEnum.Active.getName());
		if(loanReqeusts!=null && loanReqeusts.size()>0) {
			return true;
		}
		return false;
	}
	
	public void initiateLoanRequest(String phoneNumber, String ssn, String name, String mailId) throws DAOException {
		createLoanRequestRecord(phoneNumber, ssn, name, mailId);
		util.start(ssn, name);
	}
	
	public void decideLoanRequest(String ssn, String accept) {
		updateLoanRequestRecord( ssn, accept);
		util.decide(ssn, accept);
	}

	private void updateLoanRequestRecord(String ssn, String accept) {
		// TODO Auto-generated method stub
		
	}

	private void createLoanRequestRecord(String phoneNumber, String ssn, String name, String mailId) throws DAOException {
		try {
			LoanRequest loanRequest = new LoanRequest();
			loanRequest.setAcceptedInd("N");
			loanRequest.setEnteredDate(new Date());
			loanRequest.setMailId(mailId);
			loanRequest.setPhoneNumber(phoneNumber);
			loanRequest.setSsn(ssn);
			loanRequest.setName(name);
			loanRequest.setStatus(LoanRequestStatusEnum.Active.getName());
			lr.save(loanRequest);
		}catch(Exception e) {
			throw new DAOException(e,"failed to add loan request record");
		}
	}
}
