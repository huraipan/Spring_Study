package kr.co.softcampus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.softcampus.beans.DataBean1;

@Controller
@SessionAttributes("sessionBean1")
public class TestController {
	
	
	@ModelAttribute("sessionBean1")
	public DataBean1 sessionBean1() {
		return new DataBean1();
	}
	
	
	
	@GetMapping("/test1")
	//public String test1(HttpServletRequest request) {
	public String test1(HttpSession session) {	
		
		//HttpSession session = request.getSession();
		session.setAttribute("data1", "String1");
		
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(HttpSession session) {
		session.setAttribute("data1", "String2");
		return "redirect:/result1";
	}
	
	@GetMapping("/test3")
	public String test3(HttpSession session) {
		session.setAttribute("data1", "String3");
		return "forward:/result1";
	}
	
	
	
	@GetMapping("/result1")
	//public String result1(HttpServletRequest request) {
	public String result1(HttpSession session) {	
		//HttpSession session = request.getSession();
		String data1 = (String)session.getAttribute("data1");
		System.out.printf("data1 : %s\n", data1);
		
		
		return "result1";
	}
	
	
	@GetMapping("/test4")
	public String test4(HttpSession session) {
	
		DataBean1 bean1 = new DataBean1();
		bean1.setData1("String4");
		bean1.setData2("String5");
		
		session.setAttribute("bean1", bean1);
		
		return "test4";
	}
	
	@GetMapping("/result4")
	//public String result4(HttpSession session) {
	public String result4(@SessionAttribute("bean1") DataBean1 bean1) {
		
		//DataBean1 bean1 = (DataBean1)session.getAttribute("bean1");
		
		System.out.printf("bean1.data1 : %s\n", bean1.getData1());
		System.out.printf("bean1.data2 : %s\n", bean1.getData2());
		
		return "result4";
	}
	
	@GetMapping("/test5")
	public String test5(@ModelAttribute("sessionBean1") DataBean1 sessionBean1) {
		
		sessionBean1.setData1("String6");
		sessionBean1.setData2("String7");
		
		return "test5";
	}
	
	@GetMapping("/result5")
	public String result5(@ModelAttribute("sessionBean1") DataBean1 sessionBean1) {
		
		System.out.printf("sessionBean1.data1 : %s\n", sessionBean1.getData1());
		System.out.printf("sessionBean1.data2 : %s\n", sessionBean1.getData2());
		
		return "result5";
	}

}
