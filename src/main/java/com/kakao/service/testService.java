package com.kakao.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.mapper.testMapper;

@Service
public class testService {

	@Autowired
	private testMapper mapper;
	
	public HashMap getTest() {
		
		return mapper.getTest();
	}
	
}
