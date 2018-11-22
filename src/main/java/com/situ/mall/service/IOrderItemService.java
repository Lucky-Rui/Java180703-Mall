package com.situ.mall.service;

import java.util.List;

import com.situ.mall.entity.OrderItem;

public interface IOrderItemService {
	List<OrderItem> selectOrderItemByUserId(Integer userId);
}
