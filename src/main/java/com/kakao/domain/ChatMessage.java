package com.kakao.domain;

import lombok.Data;

@Data
public class ChatMessage {

    // 메시지 타입 : 입장, 채팅
    public enum MessageType {
        ENTER, TALK
    }

    private MessageType type; // 메시지 타입
    private int roomId; // 방번호
    private String sender; // 메시지 보낸사람
    private String message; // 메시지
    private String msgRegDt; // 메시지 전송날짜
    private String msgRegId; // 메시지 입력자
}