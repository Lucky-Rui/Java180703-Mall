package com.situ.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.User;
import com.situ.mall.mapper.UserMapper;
import com.situ.mall.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public ServerResponse<User> login(String username, String password) {
		// 这个用户名存不存在
		int count = userMapper.checkUserName(username);
		if (count == 0) {
			return ServerResponse.createError("该用户不存在");
		}

		// 用户名存在时判断用户名和密码是否一致，密码用MD5加密
		// User user = userMapper.selectLogin(username, MD5Util.EncodeUtf8(password));
		User user = userMapper.selectLogin(username, password);
		if (user == null) {
			return ServerResponse.createError("密码错误");
		}
		user.setPassword("");
		return ServerResponse.createSuccess("登录成功");
	}

}
