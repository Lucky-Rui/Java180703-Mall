package com.situ.mall.controller.back;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.User;
import com.situ.mall.service.IUserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/getLoginPage")
	public String getLoginPage() {
		return "/user/login";
	}

	@RequestMapping(value = "/login")
	@ResponseBody
	public ServerResponse<User> login(String username, String password, HttpSession session) {
		ServerResponse<User> response = userService.login(username,password);
		// 这个用户是存在的
		if (response.isSuccess()) {
			session.setAttribute("USER", response.getData());
		}
		return response;
	}

}
