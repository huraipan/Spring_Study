package kr.co.softcampus.advisor;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdvisorClass {
	
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}
	
	public void afterMethod() {
		System.out.println("afterMethod");
	}
	
	public Object aroundMethod(ProceedingJoinPoint pjp)throws Throwable {
		System.out.println("aroundMethod1");
		
		Object obj = (Integer)pjp.proceed();
		
		System.out.println("aroundMethod2");
		
		return obj;
	}
	
	
	public void afterReturningMethod() {
		System.out.println("afterReturningMethod");
	}
	
	public void afterThrowingMethod(Throwable e1) {
		System.out.println("afterThrowingMethod");
		System.out.println(e1);
	}
	
	

}
