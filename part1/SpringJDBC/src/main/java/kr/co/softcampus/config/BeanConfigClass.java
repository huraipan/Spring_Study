package kr.co.softcampus.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = {"kr.co.softcampus.beans", "kr.co.softcampus.db"})
public class BeanConfigClass {
	
	
	// DataSource
	@Bean
	public BasicDataSource source() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName("oracle.jdbc.OracleDriver");
		source.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		source.setUsername("scott");
		source.setPassword("1234");
		
		return source;
	}
	
	
	
	
	
	// 데이터베이스에 접속해서 쿼리를 전달하는 빈을 등록한다.
	@Bean
	public JdbcTemplate db(BasicDataSource source) {
		// 데이터 소스(접속정보를 가지고 있는 객체 - DBCP)
		JdbcTemplate db = new JdbcTemplate(source);
		return db;
		
	}

}
