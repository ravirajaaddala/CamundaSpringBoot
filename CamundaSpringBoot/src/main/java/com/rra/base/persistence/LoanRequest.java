package com.rra.base.persistence;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoanRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long loanRequestId;
	private String name;
	private String ssn;
	private String mailId;
	private String phoneNumber;
	private String acceptedInd;
	private String status;
	private Date enteredDate;
	public Long getLoanRequestId() {
		return loanRequestId;
	}
	public void setLoanRequestId(Long loanRequestId) {
		this.loanRequestId = loanRequestId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAcceptedInd() {
		return acceptedInd;
	}
	public void setAcceptedInd(String acceptedInd) {
		this.acceptedInd = acceptedInd;
	}
	public Date getEnteredDate() {
		return enteredDate;
	}
	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
