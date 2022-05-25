package com.rra.base.controller;

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
import com.rra.base.service.CamundaUtilService;

@Controller
public class ScreenController {
	
	@Autowired
	private CamundaUtilService util;

	@GetMapping("/loan")
	public String loanRequest() {
		return "loanrequest";
	}
	
	@PostMapping("/initiateloan")
	@ResponseBody
	public ResponseEntity<String> submiLoanRequest(@RequestBody LoanRequestModal l) {
		System.out.println("start loan request "+l.getName());
		try {
			util.start(l.getSsn(), l.getName());
		}catch(Exception e) {
			return new ResponseEntity("Loan request failed", getJsonHeader(), HttpStatus.OK);
		}
		
		return new ResponseEntity("Loan request submitted", getJsonHeader(), HttpStatus.OK);
	}
	
	@PostMapping("/acceptoffer")
	@ResponseBody
	public ResponseEntity<String> acceptoffer(@RequestBody LoanRequestModal l) {
		System.out.println("start loan request "+l.getName());
		try {
			util.start(l.getSsn(), l.getName());
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
