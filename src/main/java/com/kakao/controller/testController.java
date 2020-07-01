package com.kakao.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kakao.domain.ChatRoom;
import com.kakao.domain.ChatRoomList;
import com.kakao.domain.ChatRoomRepository;
import com.kakao.domain.MsgrUser;
import com.kakao.service.testService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class testController {

	private static int SUCCESS = 1;
	private static int FAILED = 0;
	
	@Autowired
	private testService service;
	private final ChatRoomRepository chatRoomRepository;
	
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
		List<ChatRoomList> roomList = service.getRoomList();
		model.addAttribute("roomList", roomList);
		
		return "/test/testRoom";
	}

		
	@ResponseBody
	@RequestMapping(value = "/testCreateRoom", method = {RequestMethod.POST, RequestMethod.GET})
	public void testCreateRoom(
		HttpSession session,
		HttpServletResponse response,
		@RequestParam(value = "roomTitle") String roomTitle) throws NoSuchAlgorithmException, GeneralSecurityException, IOException { 
	
		HashMap<String, Object> status = new HashMap<String, Object>();
		status.put("status", FAILED);
		MsgrUser user = (MsgrUser)session.getAttribute("loginUser");
		
		if(service.createTestRoom(roomTitle) == SUCCESS) {
			service.testRoomJoinUser(user.getUserId(), service.getRoomId(roomTitle).getMyChatRoomSeq());
			status.put("status", SUCCESS);
			status.put("roomId", service.getRoomId(roomTitle).getMyChatRoomSeq());
		}
	
		String json = new Gson().toJson(status);
		response.getWriter().write(json);
	}
	
	
	@RequestMapping(value = "/joinRoom", method = {RequestMethod.POST, RequestMethod.GET})
	public String joinRoom(
			HttpSession session,
			HttpServletResponse response,
			@RequestParam(value = "roomId") int roomId,
			Model model) { 		
	
		MsgrUser user = (MsgrUser)session.getAttribute("loginUser");
		
		System.out.println("userId:" + user.getUserId());
		System.out.println("roomId:" + roomId);
		
		if(service.testRoomUserCheck(user.getUserId(), roomId) == null) {
			service.testRoomJoinUser(user.getUserId(), roomId);
		}
		
		ChatRoomList roomDetail = service.testRoomIn(roomId);
		model.addAttribute("roomDetail", roomDetail);

		System.out.println(roomDetail.getMyChatRoomName());
		
		return "test/testRoomdetail";
	}
	
	
	
	
	@RequestMapping(value = "/findRoom/{roomId}", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public ChatRoom findRoom(@PathVariable String roomId) { 		
		System.out.println("들어더어어어어어어니니니니니닝");
        return chatRoomRepository.findRoomById(roomId);
	}
}
