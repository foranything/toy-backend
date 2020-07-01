package com.kakao.domain;

import lombok.Data;

@Data
public class ChatRoomList {
	private String userId;
	private int myChatRoomSeq;
	private String myChatRoomName;
}
