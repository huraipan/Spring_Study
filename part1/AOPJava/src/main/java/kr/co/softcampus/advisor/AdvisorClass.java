package kr.co.softcampus.advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AdvisorClass {
	
	@Before("execution(* method1())")
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}
	
	
	
	@After("execution(* method1())")
	public void afterMethod() {
		System.out.println("afterMethod");
	}
	
	@Around("execution(* method1())")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("aroundMethod1");
		Object result = pjp.proceed();
		System.out.println("aroundMethod2");
		return result;
	}
	
	
	@AfterReturning("execution(* method1())")
	public void afterReturningMethod() {
		System.out.println("afterReturningMethod");
	}
	
	@AfterThrowing("execution(* method1())")
	public void afterThrowingMethod() {
		System.out.println("afterThrowing");
	}
	
	
	
	
	
	

}
