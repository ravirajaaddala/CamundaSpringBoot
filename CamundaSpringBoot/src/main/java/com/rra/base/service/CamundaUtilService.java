package com.rra.base.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Component;

@Component
public class CamundaUtilService {

private RuntimeService rs = null;
	
	public CamundaUtilService(RuntimeService rs) {
		this.rs=rs;
	}
	
	public void start(String businessKey, String userName) {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("user_name", userName);
		Date d = new Date();
		ProcessInstance pi = rs.startProcessInstanceByKey("LOAN_PROCESSING", businessKey, variables);
		System.out.println("business key = "+pi.getBusinessKey()+" pid = "+pi.getProcessInstanceId());
	}
	
	public void decide(String businessKey, String decision) {
		rs.
	}
}
