package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;

public class ReportingStructureCalculator {

	private EmployeeService employeeService; //TODO make this autowired
    
    public ReportingStructureCalculator(EmployeeService _employeeService) {
		employeeService = _employeeService;
	}

	public ReportingStructure getReportingStructure(String id) {
		Employee e = employeeService.read(id); //only make one database call per employee
		ReportingStructure repStruct = new ReportingStructure();
		repStruct.setEmployee(e);
		repStruct.setNumberOfReports(getTotalReports(e));
    	return repStruct;
		
	}

	public int getTotalReports(Employee _employee) {
		int reportCount = 0; //base case 0 reports
		if (_employee.getDirectReports() == null) {
			return reportCount;
		} 
		else {
			reportCount += _employee.getDirectReports().size(); //Other option - add 1 for each iteration of loop.  Potentially faster with no size call
			for (Employee subord : _employee.getDirectReports()) {
				reportCount += getTotalReports(employeeService.read(subord.getEmployeeId())); //recurse down and add reports until all employees with 0 are reached
																						 	  //what if an employee reports to multiple people?
			}
			return reportCount;
		}
	}

}