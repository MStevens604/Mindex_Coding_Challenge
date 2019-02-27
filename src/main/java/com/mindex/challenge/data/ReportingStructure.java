package com.mindex.challenge.data;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mindex.challenge.service.EmployeeService;

public class ReportingStructure {

    private EmployeeService employeeService;    
	private Employee employee;
	private int numberOfReports;
	
	public int getNumberOfReports() {
		numberOfReports = getTotalReports(employee);
		return numberOfReports;
	}
	
	public ReportingStructure(Employee _employee, EmployeeService _employeeService) {
		this.employee = _employee;
		this.employeeService = _employeeService;
	}
	
//	public t testReturns() {
//		ObjectWriter jsonMaker = new ObjectMapper().writer().withDefaultPrettyPrinter();
//		return jsonMaker.wr
//	}
	public int getTotalReports(Employee _employee) {
		int reportCount = 0;
		if (_employee.getDirectReports() == null) {
			return reportCount;
		} 
		else {
			reportCount += _employee.getDirectReports().size();
			for (Employee subord : _employee.getDirectReports()) {
				reportCount += getTotalReports(employeeService.read(subord.getEmployeeId()));
			}
			return reportCount;
		}
	}
	

}
