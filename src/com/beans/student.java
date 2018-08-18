package com.beans;

public class student {
	private String sid;
	private String sname;
	private String spassword;
	private String sEmailId;
	private String cpi;
	private double salary;
	private String company;
	private int placementStatus;
	private String interest;
	private String branch;
	
	public String getSid() { // getters and setters
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSpassword() {
		return spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public String getsEmailId() {
		return sEmailId;
	}

	public void setsEmailId(String sEmailId) {
		this.sEmailId = sEmailId;
	}

	public String getCpi() {
		return cpi;
	}

	public void setCpi(String cpi) {
		this.cpi = cpi;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPlacementStatus() {
		return placementStatus;
	}

	public void setPlacementStatus(int placementStatus) {
		this.placementStatus = placementStatus;
	}
	
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
}
