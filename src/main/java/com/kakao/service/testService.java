package com.kakao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.domain.MsgrUser;
import com.kakao.mapper.testMapper;

@Service
public class testService {
	@Autowired
	private testMapper mapper;

	public MsgrUser testLogin(String userId, String userPwd) {	
		return mapper.testLogin(userId, userPwd);
	}
}
