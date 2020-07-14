package com.kakao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.kakao.domain.ChatMessage;
import com.kakao.domain.ChatRoomList;
import com.kakao.domain.MsgrFriendList;
import com.kakao.domain.MsgrUser;

@Component
@Mapper
public interface testMapper {
	public MsgrUser testLogin(@Param (value= "userId") String userId, @Param(value = "userPwd") String userPwd);
	public int createTestRoom(@Param (value= "roomTitle") String roomTitle);

	public int createTestChatRoom(@Param (value= "userId") String friendId, @Param(value = "roomName") String roomName, @Param(value = "strTime") String strTime);
	
	public ChatRoomList getRoomId(@Param (value= "roomTitle") String roomTitle);

	public ChatRoomList getMyChatRoomId(@Param (value= "userId") String userId, @Param (value= "strTime") String strTime);
	
	
	public List<ChatRoomList> getRoomList(@Param (value= "userId") String userId);	
	public ChatRoomList testRoomIn(@Param (value= "roomId") int roomId);	
	public int testRoomJoinUser(@Param (value= "userId") String userId, @Param(value = "roomName") String roomName, @Param (value= "roomId") int roomId);
	public ChatRoomList testRoomUserCheck(@Param (value= "userId") String userId, @Param (value= "roomId") int roomId);
	public int friendAdd(@Param (value= "userId") String userId, @Param (value= "myFriendId") String myFriendId);
	public List<MsgrFriendList> getMsgrFriendList(@Param (value= "userId") String userId);
	public MsgrFriendList getMsgrFriend(@Param (value= "userId") String userId);

	public List<MsgrUser> getChatRoomUserList(@Param (value= "roomId") int roomId);	
	
	public int insertChatMsg(@Param (value= "roomId")int roomId, @Param (value= "userId")String userId, @Param (value= "msgCnt")String msgCnt, @Param (value= "msgRegDt")String msgRegDt);
	
	public List<ChatMessage> getChatMsgHistory(@Param (value= "roomId")int roomId);

}