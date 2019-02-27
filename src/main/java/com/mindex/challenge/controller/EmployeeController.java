package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.impl.ReportingStructureCalculator;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    private ReportingStructureCalculator reportingStructCalc; //TODO autowire inside this
    private ArrayList<Compensation> compensationCollection = new ArrayList<Compensation>();//This is totally not what they meant by persist.  Maybe create mongo instance?
    																					   //Could also hijack EmployeeServiceImpl and its access to the data repo
    
    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        LOG.debug("Received employee create request for [{}]", employee);

        return employeeService.create(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return employeeService.read(id);
    }

    @PutMapping("/employee/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        LOG.debug("Received employee create request for id [{}] and employee [{}]", id, employee);

        employee.setEmployeeId(id);
        return employeeService.update(employee);
    }
    
    /**
     * Implemented code.  
     * TODO Maybe move this to its own rest controller?
     */
    
    /*
     * This new endpoint should accept an employeeId and return the fully filled out ReportingStructure for the specified employeeId. 
     * The values should be computed on the fly and will not be persisted.
     * TODO: Requirements clarification of returned JSON - do we actually want the employee and their reports nested instead of just returning the ID and count?
     */
    
    @GetMapping("/reportingStructure/{id}")
    public ReportingStructure getReportingStructure(@PathVariable String id) {
    	if (reportingStructCalc == null) { //This can go away after autowiring
    		reportingStructCalc = new ReportingStructureCalculator(employeeService);
    	}
    	ReportingStructure report = reportingStructCalc.getReportingStructure(id);
    	return report;
    }
    
    /**
     * TODO - requirements clarification - EmployeeID instead of the full employee object in compensation type?
     * TODO - get rid of this arraylist hack and make it a mongo
     */
    @PostMapping("/compensation")
    public Compensation createCompensation(@RequestBody Compensation compensation) {
    	compensationCollection.add(compensation);
    	return compensationCollection.get(compensationCollection.size()-1);//Get the 'newest' compensation.  
    }
    
    /*
     * TODO - change this from being arraylist hack to mongo calls
     */
    @GetMapping("/compensation/{id}")
    public Compensation getCompensation(@PathVariable String id) {
    	for (Compensation comp : compensationCollection) {
    		if (comp.getEmployee().getEmployeeId().equals(id)) {
    			return comp;
    		}
    	}
    	return null;
    }
    
}
