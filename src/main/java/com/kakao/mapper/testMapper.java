package com.kakao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.kakao.domain.ChatRoomList;
import com.kakao.domain.MsgrUser;

@Component
@Mapper
public interface testMapper {
	public MsgrUser testLogin(@Param (value= "userId") String userId, @Param(value = "userPwd") String userPwd);
	public int createTestRoom(@Param (value= "roomTitle") String roomTitle);
	public ChatRoomList getRoomId(@Param (value= "roomTitle") String roomTitle);
	public List<ChatRoomList> getRoomList();	
	public ChatRoomList testRoomIn(@Param (value= "roomId") int roomId);	
	public int testRoomJoinUser(@Param (value= "userId") String userId, @Param (value= "roomId") int roomId);
	public ChatRoomList testRoomUserCheck(@Param (value= "userId") String userId, @Param (value= "roomId") int roomId);
}