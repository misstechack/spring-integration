package com.sbi.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

import com.sbi.model.Employee;

@MessagingGateway
public interface EmployeeGateway {
	
	//#########################  SERVICE ACTIVATOR  ########################//
	
	//	Get call
	@Gateway(requestChannel = "request-emp-name-channel")
	public String getEmployeeName(String name);
	
	//	Post call
	@Gateway(requestChannel = "request-hire-emp-channel")
	public Message<Employee> hireEmployee(Employee employee);
	
	
	//#########################  TRANSFORMER  ########################//
	
	@Gateway(requestChannel = "emp-status-channel")
	public String processEmployeeStatus(String status);
	
	//#########################  SPLITTER  ########################//
	
	@Gateway(requestChannel = "emp-managers-channel")
	public String getManagerList(String managers);
	
	//#########################  FILTER  ########################//
	
	@Gateway(requestChannel = "dev-emp-channel")
	public String getEmployeeIfADeveloper(String empDesignation);
	
	
}
