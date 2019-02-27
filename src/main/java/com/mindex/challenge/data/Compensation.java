package com.mindex.challenge.data;
/*
 * Create a new type, Compensation. A Compensation has the following fields: employee, salary, and effectiveDate. Create 
two new Compensation REST endpoints. One to create and one to read by employeeId. These should persist and query the 
Compensation from the persistence layer.
 */
public class Compensation {

	private Employee employee;
	private int salary;
	private String effectiveDate; //TODO use java date

    public Compensation() {
    }

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee _employee) {
		this.employee = _employee;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int _salary) {
		this.salary = _salary;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String _effectiveDate) {
		this.effectiveDate = _effectiveDate;
	}
}
