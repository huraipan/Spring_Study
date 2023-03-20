package kr.co.softcampus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.softcampus.beans.DataBean1;
import kr.co.softcampus.beans.DataBean2;

@Configuration
public class RootAppContext {
	
	@Bean
	@RequestScope
	public DataBean1 dataBean1() {
		return new DataBean1();
	}
	
	@Bean("requestBean2")
	@RequestScope
	public DataBean2 dataBean2() {
		return new DataBean2();
	}

}
