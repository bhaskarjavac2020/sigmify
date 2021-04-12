package com.sigmi.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.nt.model.Student;
@Component
@ConfigurationProperties(prefix="com.sigmi")
public class MyDataRunner implements CommandLineRunner {
	private Student stud;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(this);
	}
	public Student getStud() {
		return stud;
	}
	public void setStud(Student stud) {
		this.stud = stud;
	}
	@Override
	public String toString() {
		return "MyDataRunner [stud=" + stud + "]";
	}
}
