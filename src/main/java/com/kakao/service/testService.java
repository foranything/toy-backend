package com.kakao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.domain.ChatMessage;
import com.kakao.domain.ChatRoomList;
import com.kakao.domain.MsgrFriendList;
import com.kakao.domain.MsgrUser;
import com.kakao.mapper.testMapper;

@Service
public class testService {

	@Autowired
	private testMapper mapper;

	public MsgrUser testLogin(String userId, String userPwd) {	
		return mapper.testLogin(userId, userPwd);
	}
	
	
	public ChatRoomList getMyChatRoomId(String userId, String strTime) {
		return mapper.getMyChatRoomId(userId, strTime);
	}
	
	
	public int createTestChatRoom(String userId, String roomName, String strTime) {
		return mapper.createTestChatRoom(userId, roomName, strTime);
	}

	
	public int createTestRoom(String roomTitle) {
		return mapper.createTestRoom(roomTitle);
	}
	
	
	public ChatRoomList getRoomId(String roomTitle) {
		return mapper.getRoomId(roomTitle);
	}
	
	
	public List<ChatRoomList> getRoomList(String userId) {
		return mapper.getRoomList(userId);
	}
	
	public ChatRoomList testRoomIn(int roomId) {
		return mapper.testRoomIn(roomId);
	}
	
	public int testRoomJoinUser(String userId, String roomName, int roomId) {
		return mapper.testRoomJoinUser(userId, roomName, roomId);
	}
	
	public ChatRoomList testRoomUserCheck(String userId, int roomId) {
		return mapper.testRoomUserCheck(userId, roomId);
	}
	
	public int friendAdd(String userId, String myFriendId) {
		return mapper.friendAdd(userId, myFriendId);
	}
	
	public List<MsgrFriendList> getMsgrFriendList(String userId) {
		return mapper.getMsgrFriendList(userId);
	}

	
	public MsgrFriendList getMsgrFriend(String userId) {
		return mapper.getMsgrFriend(userId);
	}	
	
	public List<MsgrUser> getChatRoomUserList(int roomId) {
		return mapper.getChatRoomUserList(roomId);
	}

	
	
	//메시지
	public int insertChatMsg(int roomId, String userId, String msgCnt, String msgRegDt) {
		return mapper.insertChatMsg(roomId, userId, msgCnt, msgRegDt);
	}
	
	public List<ChatMessage> getChatMsgHistory(int roomId) {
		return mapper.getChatMsgHistory(roomId);
	}
	
}
