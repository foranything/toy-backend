package com.kakao.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kakao.domain.MsgrUser;
import com.kakao.service.testService;

@Controller
@RequestMapping("/")
public class testController {

	@Autowired
	private testService service;
	
	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
	public String test() {
		return "test/test";
	}
	

	@RequestMapping(value = "testLogin", method = {RequestMethod.POST, RequestMethod.GET})
	public String testLogin(
		HttpSession session,
		@RequestParam(value = "userId") String userId,
		@RequestParam(value = "userPwd") String userPwd ) {
		
		MsgrUser user = service.testLogin(userId, userPwd);
		
		session.setAttribute("loginUser", user);
		
		System.out.println("asidjfpasidjfpasdf");
		
		return "/chat/room";
	}

		
	
	
}
