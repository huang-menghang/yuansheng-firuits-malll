package com.ysdevelop.api.shop.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ysdevelop.api.entity.Member;
import com.ysdevelop.api.vo.LoginVo;

public interface MemberService {
	void save(Member member,String confirmPassword, String messageCode, HttpSession session);

	void sendMessage(HttpSession session, String mobile);
	
	Member login(LoginVo loginVo,HttpSession session,HttpServletResponse response);
	
}
