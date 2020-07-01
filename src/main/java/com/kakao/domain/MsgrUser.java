package com.kakao.domain;

import lombok.Data;

@Data
public class MsgrUser {
	private String userId;
	private String userNick;
	private String userPwd;
	private String userEmail;
}
