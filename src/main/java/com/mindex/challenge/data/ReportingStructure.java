package com.mindex.challenge.data;

public class ReportingStructure {

	private Employee employee;
	private int numberOfReports;
	
	public int getNumberOfReports() {
		return numberOfReports;
	}
	
	public ReportingStructure(Employee _employee, int _numberOfReports) {
		this.employee = _employee;
		this.numberOfReports = _numberOfReports;
	}

}
