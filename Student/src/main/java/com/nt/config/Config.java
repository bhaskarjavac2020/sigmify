package com.nt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Value("${db.driver}")
	private String DB_DRIVER;
	
	@Value("${db.password}")
	private String DB_PASSWORD;
	
	@Value("${db.url}")
	private String DB_URL;
	
	@Value("${db.username}")
	private String DB_USERNAME;
	
	@Value("${hibernate.dialect}")
	private String HIBERNATE_DIALECT;
	
	@Value("${hibenate.show_sql}")
	private String HIBERNATE_SHOW_SQL;
	
	@Value("${}")
}
