package com.rra.base.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rra.base.modal.LoanRequestModal;
import com.rra.base.service.LoanService;

@Controller
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ScreenController {
	
	private static final Logger _logger = LoggerFactory.getLogger(ScreenController.class);

	@Autowired 
	private LoanService loanService;

	@GetMapping("/loan")
	public String loanRequest() {
		return "loanrequest";
	}
	
	@PostMapping("/initiateloan")
	@ResponseBody
	public ResponseEntity<String> submiLoanRequest(@RequestBody LoanRequestModal l) {
		_logger.info("start loan request "+l.getName());
		String status = "Loan request submitted";
		HashMap<String,String> response = new HashMap<String,String>();
		try {
			boolean isLoanRequestExists = loanService.isLoanRequestExists(l.getSsn());
			if(isLoanRequestExists) {
				status = "A loan request already exists";
			}else {
				loanService.initiateLoanRequest(l.getPhoneNumber(), l.getSsn(), l.getName(), l.getMailId());
			}
		}catch(Exception e) {
			status = "Loan request failed";
		}
		response.put("status", status);
		return new ResponseEntity(response, getJsonHeader(), HttpStatus.OK);
	}
	
	
	@PostMapping("/acceptoffer")
	@ResponseBody
	public ResponseEntity<String> acceptoffer(@RequestBody LoanRequestModal l) {
		_logger.info("start loan request "+l.getName());
		try {
			loanService.decideLoanRequest(l.getSsn(), l.getAccept());
		}catch(Exception e) {
			return new ResponseEntity("Loan request failed", getJsonHeader(), HttpStatus.OK);
		}
		
		return new ResponseEntity("Loan request submitted", getJsonHeader(), HttpStatus.OK);
	}
	
	public HttpHeaders getJsonHeader() {
		HttpHeaders resHeader = new HttpHeaders();
		resHeader.setContentType(MediaType.APPLICATION_JSON);
		return resHeader;
	}
}
