package com.situ.mall.controller.front;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.constant.MallConstant;
import com.situ.mall.service.IUserService;

@RequestMapping("/user")
@Controller
public class FrontUserController {
	@Autowired
	private IUserService userService;

	@RequestMapping("/login.shtml")
	@ResponseBody
	public ServerResponse login(String username, String password, HttpSession session) {
		ServerResponse response = userService.login(username, password);
		// 这个用户是存在的
		if (response.isSuccess()) {
			session.setAttribute(MallConstant.SESSION_USER, response.getData());
			// TODO :将Cookie里面数据同步到数据库中cart表，然后删除Cookie中的cart_cookie数据。
		}
		return response;
	}
}
