package com.sigmi.emp.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigmi.emp.model.Employee;
import com.sigmi.emp.model.Message;
import com.sigmi.emp.service.IEmployeeService;
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/rest/employee")
public class EmployeeRestController {
	@Autowired
	private IEmployeeService service;
	/**
	 * This method takes student object 
	 * as input from JASON/XML using 
	 * @RequestBody and returns 
	 * ResponseEntity<T>
	 * call service.saveStudent(ob)
	 */
    @PostMapping("/save")
	public ResponseEntity<Message> saveEmployee(@RequestBody Employee employee){
		ResponseEntity<Message> resp=null;
		try {
			Integer id=service.saveEmployee(employee);
			resp=new ResponseEntity<Message>(new 
					Message("SUCCESS",id+"-saved"),HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<Message>(new Message("FAIL","Unable to Save"),HttpStatus.OK);
			e.printStackTrace();
		}
		return resp;
	}
    /**
     * 2.This method reads data from db
     * using findAll and() returns and returns
     * List<Student> if data exist
     * or String (Exit)
     * as response using annotation
     * @Response body
     */
    public ResponseEntity<?> getAllEmployees(){
	   ResponseEntity<?> res=null;
	   try {
		List<Employee> list=service.getAllEmployees();
		if(list!=null&&!list.isEmpty())
			res=new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		else
			res=new ResponseEntity<String>("No data found",HttpStatus.OK);
	} catch (Exception e) {
		res=new ResponseEntity<String>("Unable to fetch Data",HttpStatus.INTERNAL_SERVER_ERROR);
		e.printStackTrace();
	}
    	return res;	
    }
    /**3.Read path variable id(as input)
     * use service layer to find one object
     * based on id.return statement if exist 
     * else string (error msg) as
     * ResponseEntity<?>
     */
    @GetMapping("/one/{id}")
    public ResponseEntity<?> getOneEmployee(
    		@PathVariable Integer id){
    	ResponseEntity<?> res=null;
    	try {
			Optional<Employee> opt=service.getOneEmployee(id);
			if (opt.isPresent())
				res=new 
						ResponseEntity<Employee>(opt.get(),HttpStatus.OK);
				else
					res=new ResponseEntity<String>("No data Found",HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			res=new ResponseEntity<String>("Unable to fetch Data",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return res;
    }
    /**4.Read the path varibale id
     * check row exit or not
     * if exit call service delete
     * else return String error message
     */
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Message> deleteEmployee(
    		@PathVariable Integer id){
    	System.out.println("welcome");
    	ResponseEntity<Message> res=null;
    	try {
			boolean exist=service.isExist(id);
			if (exist) {
				service.deleteEmployee(id);
				res=new ResponseEntity<Message>(new 
						Message("SUCCESS ",id+"-removed"),HttpStatus.OK);
			}else {
				res=new ResponseEntity<Message>(new 
						Message("FAIL",id+"-Not exist"),HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			res=new ResponseEntity<Message>(new
					Message("FAIL",id+"-Unable to Delete"),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return res;
		}
}
