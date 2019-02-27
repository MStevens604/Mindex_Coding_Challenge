package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.impl.CompensationServiceImpl;
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

    /**
     * Implemented Code
     */
    @Autowired
    private ReportingStructureCalculator reportingStructCalc;
    
    @Autowired
    private CompensationService compensationService;
    
    //end implemented
    
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
    
    /*
     * Implemented code.  
     * TODO Could move this to its own rest controller?
     */
    
    /*
     * This new endpoint should accept an employeeId and return the fully filled out ReportingStructure for the specified employeeId. 
     * The values should be computed on the fly and will not be persisted.
     * TODO: Requirements clarification of returned JSON - do we actually want the employee and their "nulled" reports nested instead of returning the ID and count?
     * Or should we actually return filled out subordinates?
     */
    
    @GetMapping("/reportingStructure/{id}")
    public ReportingStructure getReportingStructure(@PathVariable String id) {
    	ReportingStructure report = reportingStructCalc.getReportingStructure(id);
    	return report;
    }
    /*
     * TODO - requirements clarification - Instead of adding the full Employee object to Compensation, should we use employeeID and read from EmployeeDB?
     */
    @PostMapping("/compensation")
    public Compensation createCompensation(@RequestBody Compensation compensation) {
    	return compensationService.create(compensation);
    }
    
    @GetMapping("/compensation/{id}")
    public Compensation readCompensation(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return compensationService.read(id);
    }   
    
    //end implemented
}
