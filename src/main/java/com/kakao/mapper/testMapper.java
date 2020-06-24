package com.kakao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.kakao.domain.MsgrUser;

@Component
@Mapper
public interface testMapper {
	public MsgrUser testLogin(@Param (value= "userId") String userId, @Param(value = "userPwd") String userPwd);
}
