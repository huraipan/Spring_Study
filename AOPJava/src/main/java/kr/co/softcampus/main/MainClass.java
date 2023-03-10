package kr.co.softcampus.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.softcampus.beans.TestBean1;
import kr.co.softcampus.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("kr/co/softcampus/config/beans.xml");
		
		
		System.out.println("====================================");
		
		TestBean1 xml1 = ctx1.getBean(TestBean1.class);
		try {
			xml1.method1();
		}catch(Exception e) {
			
		}
		
		
		System.out.println("====================================");
		
		ctx1.close();
		
		
		
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		
		System.out.println("====================================");
		
		
		TestBean1 java1 = ctx2.getBean(TestBean1.class);
		try {
			java1.method1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("====================================");
		
		
		
		ctx2.close();

	}

}
