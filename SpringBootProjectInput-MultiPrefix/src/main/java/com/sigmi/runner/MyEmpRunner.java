package com.sigmi.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Bhaskar
 *
 */
@Component
@ConfigurationProperties(prefix="nc.emp")
public class MyEmpRunner implements CommandLineRunner {
	private int eid;
	private String name;
	private double sal;
	private String company;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(this);
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "MyEmpRunner [eid=" + eid + ", name=" + name + ", sal=" + sal + ", company=" + company + "]";
	}
	
}
