package com.situ.mall.service;

import java.util.List;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Cart;

public interface ICartService {
	ServerResponse pageList(Integer page, Integer limit, Cart cart);

	ServerResponse deleteById(Integer id);

	ServerResponse deleteAll(String ids);

	ServerResponse add(Cart cart);

	Cart selectByProductId(Integer productId);

	List<Cart> selectByUserId(Integer userId);

	ServerResponse update(Cart cart);

	ServerResponse updateByProductId(Cart cart);

	ServerResponse deleteByProductId(Integer productId);

	ServerResponse updateChecked(Integer checked);
}
