package com.mindex.challenge.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ReportingStructure {
	private Employee employee;
	private int numberOfReports;
	
	public ReportingStructure(Employee _employee) {
		this.employee = _employee;
		this.numberOfReports = 0;
	}
	
//	public Object testReturns() {
//		ObjectWriter jsonMaker = new ObjectMapper().writer().withDefaultPrettyPrinter();
//		return jsonMaker.wr
//	}
	

}
