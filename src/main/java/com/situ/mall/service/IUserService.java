package com.situ.mall.service;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.User;

public interface IUserService {

	ServerResponse<User> login(String username, String password);

}
