package com.mindex.challenge.data;

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
