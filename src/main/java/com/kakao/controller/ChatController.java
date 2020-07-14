package com.kakao.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import com.kakao.domain.ChatMessage;
import com.kakao.domain.CreateRoom;
import com.kakao.service.testService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSocketMessageBroker
@Controller
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;
	private static int SUCCESS = 1;
	private static int FAILED = 0;


    @Autowired
	private testService service;
    
    /*
    //view에서 사용하는 것.. 나중에 지워도 되는 것
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType()))
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
    */

    
    //test용 메신저, 지우면 안돼는 것 이거 기반으로 작업할 것
    @MessageMapping("/message")
    public void messages(ChatMessage message) {
    	
    	System.out.println("messages : " + message.getMessage() + "," + message.getRoomId() + "," + message.getSender());
    	
		java.util.Date utilDate = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy.MM.dd HH:mm:ss"
		);
		String msgRegDt = sdf.format(utilDate);
    	
		if(message.getMessage() != null) {
	    	service.insertChatMsg(message.getRoomId(), message.getSender(), message.getMessage(), msgRegDt);
		}
    	
        if (ChatMessage.MessageType.ENTER.equals(message.getType()))
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        messagingTemplate.convertAndSend("/sub/room/" + message.getRoomId(), message);
    }
    

    @MessageMapping("/createChat")
    public void createChat(CreateRoom createRoom) {
		
		java.util.Date utilDate = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy.MM.dd HH:mm:ss"
		);
		String strTime = sdf.format(utilDate);
		String roomName = createRoom.getCreateUser() + "," + createRoom.getFriendId();
		
		String[] inputUserList = new String[2];
		inputUserList[0] = createRoom.getCreateUser();
		inputUserList[1] = createRoom.getFriendId();

		int roomId = -1;

        if (CreateRoom.CreateType.CREATE.equals(createRoom.getType())) {
        	boolean flag = true;
        	
        	if(service.createTestChatRoom(createRoom.getCreateUser(), roomName, strTime) == SUCCESS) {
    			roomId = service.getMyChatRoomId(createRoom.getCreateUser(), strTime).getMyChatRoomSeq();

    			for(int idx = 0; idx < inputUserList.length; idx++) {
    				service.testRoomJoinUser(inputUserList[idx], roomName, roomId);
    			}
    		}

        	createRoom.setRoomName(createRoom.getCreateUser() + "," + createRoom.getFriendId());
        	createRoom.setRoomId(roomId);

        	
        	

        }

        messagingTemplate.convertAndSend("/sub/mainHome/" + createRoom.getFriendId(), createRoom);
        messagingTemplate.convertAndSend("/sub/mainHome/" + createRoom.getCreateUser(), createRoom);
    }
}