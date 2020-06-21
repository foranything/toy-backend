package com.kakao.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kakao.service.testService;

@Controller
@RequestMapping("/")
public class testController {

	
	@Autowired
	private testService service;
	
	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
	public String test() {
	
		HashMap test = service.getTest();
		System.out.println("로그"+test);
		
		System.out.println("안녕하세요");
		
		return "test/test";
	}
	
	
	
	
}
