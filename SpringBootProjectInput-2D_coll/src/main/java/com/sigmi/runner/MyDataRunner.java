package com.sigmi.runner;

import java.util.Map;
import java.util.Properties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix="sig.info")
public class MyDataRunner implements CommandLineRunner {
	private Map<String,String> emp;
	private Properties student;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	System.out.println(this);	
	}

	public Map<String, String> getEmp() {
		return emp;
	}

	public void setEmp(Map<String, String> emp) {
		this.emp = emp;
	}
	public Properties getStudent() {
		return student;
	}

	public void setStudent(Properties student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "MyDataRunner [emp=" + emp + ", student=" + student + "]";
	}
	
}
