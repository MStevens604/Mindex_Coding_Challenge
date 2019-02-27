package com.mindex.challenge.service;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;

public interface ReportingStructureCalculator {
	public ReportingStructure getReportingStructure(String id);
	public int getTotalReports(Employee _employee);
}