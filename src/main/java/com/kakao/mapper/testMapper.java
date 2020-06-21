package com.kakao.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface testMapper {
	public HashMap getTest();
}
