package com.kakao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.domain.Test;
import com.kakao.mapper.testMapper;

@Service
public class testService {

	@Autowired
	private testMapper mapper;
	
	public Test getTest() {
		
		return mapper.getTest();
	}
	
}
