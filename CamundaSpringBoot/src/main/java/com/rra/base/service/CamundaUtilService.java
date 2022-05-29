package com.rra.base.service;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rra.base.controller.ScreenController;

@Component
public class CamundaUtilService {
	
	private static final Logger _logger = LoggerFactory.getLogger(ScreenController.class);

	private RuntimeService rs = null;
	
	public CamundaUtilService(RuntimeService rs) {
		this.rs=rs;
	}
	
	public void start(String businessKey, String userName) {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("user_name", userName);
		ProcessInstance pi = rs.startProcessInstanceByKey("LOAN_PROCESSING", businessKey, variables);
		_logger.info("business key = "+pi.getBusinessKey()+" pid = "+pi.getProcessInstanceId());
	}
	
	public void decide(String businessKey, String decision) {
		//rs.
	}
}
