package com.kakao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.kakao.domain.Test;

@Component
@Mapper
public interface testMapper {
	public Test getTest();
}
