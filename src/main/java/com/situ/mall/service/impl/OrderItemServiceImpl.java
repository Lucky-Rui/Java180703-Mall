package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.entity.OrderItem;
import com.situ.mall.mapper.OrderItemMapper;
import com.situ.mall.service.IOrderItemService;

@Service
public class OrderItemServiceImpl implements IOrderItemService {
	@Autowired
	private OrderItemMapper orderItemMapper;

	@Override
	public List<OrderItem> selectOrderItemByUserId(Integer userId) {
		List<OrderItem> orderItemList = orderItemMapper.selectOrderItemByUserId(userId);
		return orderItemList;
	}

}