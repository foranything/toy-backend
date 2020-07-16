package com.kakao.domain;

import lombok.Data;

@Data
public class CreateRoom {
    // 메시지 타입 : 생성, 채팅
    public enum CreateType {
        CREATE
    }

    private CreateType type; // 메시지 타입
    private int roomId; // 방번호
    private String roomName; // 방이름
    private String message; // 방이름
    private String friendId; // 초대한 친구 아이디
    private String createUser; // 방 생성한 사람
    private String roomRegDt; // 방 생성일자

}
