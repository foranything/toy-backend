package com.kakao.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.kakao.domain.ChatMessage;
import com.kakao.domain.ChatRoomList;
import com.kakao.domain.MsgrFriendList;
import com.kakao.domain.MsgrUser;
import com.kakao.service.testService;

@Controller
@RestController
@RequestMapping("/")
public class testController {

	private static int SUCCESS = 1;
	private static int FAILED = 0;
	
	@Autowired
	private testService service;
	
	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
	public String test() {
		return "test/test";
	}
	

	@RequestMapping(value = "/testLogin", method = {RequestMethod.POST, RequestMethod.GET})
	public String testLogin(
		HttpSession session,
		@RequestParam(value = "userId") String userId,
		@RequestParam(value = "userPwd") String userPwd,
		Model model) {
		
		MsgrUser user = service.testLogin(userId, userPwd);	
		session.setAttribute("loginUser", user);
		List<ChatRoomList> roomList = service.getRoomList(user.getUserId());
		List<MsgrFriendList> friendList = service.getMsgrFriendList(user.getUserId());
		
		model.addAttribute("roomList", roomList);
		model.addAttribute("friendList", friendList);
		
		
		//"/test/testRoom"
		return "/test/testMain";
	}

	
	@ResponseBody
	@RequestMapping(value = "/friendAdd", method = {RequestMethod.POST, RequestMethod.GET})
	public String friendAdd(
		HttpSession session,
		@RequestParam(value = "myFriendId") String myFriendId,
		Model model) {

		HashMap<String, Object> status = new HashMap<String, Object>();
		MsgrUser user = (MsgrUser)session.getAttribute("loginUser");

		status.put("status", FAILED);
		
		if(service.friendAdd(user.getUserId(), myFriendId) == SUCCESS) {
			MsgrFriendList friend = service.getMsgrFriend(user.getUserId());
			status.put("status", SUCCESS);
			status.put("friend", friend);
		}
	
		String json = new Gson().toJson(status);
		return json;
	}
	
	
	
	@RequestMapping(value = "/joinRoom", method = {RequestMethod.POST, RequestMethod.GET})
	public String joinRoom(
			HttpSession session,
			HttpServletResponse response,
			@RequestParam(value = "roomId") int roomId,
			Model model) { 		
	
		MsgrUser user = (MsgrUser)session.getAttribute("loginUser");

		System.out.println("user : " + user.getUserId());
		
		
		ChatRoomList roomDetail = service.testRoomIn(roomId);

		List<MsgrUser> userList = service.getChatRoomUserList(roomId);
		
		List<ChatMessage> chatMsgHistory = service.getChatMsgHistory(roomId);
		
		model.addAttribute("roomDetail", roomDetail);
		model.addAttribute("userList", userList);
		model.addAttribute("chatMsgHistory", chatMsgHistory);
		
		
		return "test/testChatRoom";
	}
}
