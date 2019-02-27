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
		int totalReports = getTotalReports(e);
		ReportingStructure repStruct = new ReportingStructure(employeeService.read(id), totalReports);
    	return repStruct;
		
	}

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