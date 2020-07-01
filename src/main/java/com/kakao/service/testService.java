package com.kakao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.domain.ChatRoomList;
import com.kakao.domain.MsgrUser;
import com.kakao.mapper.testMapper;

@Service
public class testService {

	@Autowired
	private testMapper mapper;

	public MsgrUser testLogin(String userId, String userPwd) {	
		return mapper.testLogin(userId, userPwd);
	}
	
	
	public int createTestRoom(String roomTitle) {
		return mapper.createTestRoom(roomTitle);
	}
	
	
	public ChatRoomList getRoomId(String roomTitle) {
		return mapper.getRoomId(roomTitle);
	}
	
	
	public List<ChatRoomList> getRoomList() {
		return mapper.getRoomList();
	}
	
	public ChatRoomList testRoomIn(int roomId) {
		return mapper.testRoomIn(roomId);
	}
	
	public int testRoomJoinUser(String userId, int roomId) {
		return mapper.testRoomJoinUser(userId, roomId);
	}
	
	public ChatRoomList testRoomUserCheck(String userId, int roomId) {
		return mapper.testRoomUserCheck(userId, roomId);
	}
	
}
