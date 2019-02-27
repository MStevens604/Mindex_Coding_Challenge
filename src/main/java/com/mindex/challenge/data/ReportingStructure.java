package com.mindex.challenge.data;
/*
 * Create a new type, ReportingStructure, that has two properties: employee and numberOfReports.
 * 
 * For the field "numberOfReports", this should equal the total number of reports under a given employee. The number of 
reports is determined to be the number of directReports for an employee and all of their direct reports. For example, 
given the following employee structure:
 */
public class ReportingStructure {

	private Employee employee;
	private int numberOfReports;
	
    public ReportingStructure() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee _employee) {
        this.employee = _employee;
    }

	public int getNumberOfReports() {
		return numberOfReports;
	}
	
	public void setNumberOfReports(int _numberOfReports) {
		this.numberOfReports = _numberOfReports; 
	}
}
