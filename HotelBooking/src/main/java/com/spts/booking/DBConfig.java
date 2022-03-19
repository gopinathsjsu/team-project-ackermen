package com.spts.booking;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;


/**
 *  @author Teja Ganapati Jaddipal - 015957526
 */

@Configuration
@Component
public class DBConfig {
	
	
	@Value("${spring.datasource.driverClassName}")
	private String driver;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	
	@Bean
	public JdbcTemplate getJDBCtemplate() {
		JdbcTemplate template = new JdbcTemplate(getDataSource());
		return template;
	}
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
	}

}