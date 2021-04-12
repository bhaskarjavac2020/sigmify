package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserBO;

@Repository("loginDAO")
public class LoginDAOImple implements ILoginDAO {
	@Autowired
	private SimpleJdbcCall sjc;
	
	@Override
	public String authenticate(UserBO bo) {
	    
		//set procedure name
		sjc.setProcedureName("P_AUTHENTICATE");
		//prepare map object having param name and param values
		Map<String,Object> inParam=Map.of("USERNAME",bo.getUname(),"PWD",bo.getPwd());
		//call pl-sql procedure
		Map<String, Object> outParams=sjc.execute(inParam);
		return (String) outParams.get("RESULT");
	}

}
