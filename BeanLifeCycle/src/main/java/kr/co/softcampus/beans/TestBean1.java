package kr.co.softcampus.beans;

public class TestBean1 {
	
	public TestBean1() {
		System.out.println("TestBean1");
	}
	
	public void bean1_init() {
		System.out.println("TestBean1`s init method");
	}
	
	public void bean1_destroy() {
		System.out.println("TestBean1`S destroy method");
	}

}