package com.situ.mall.service;

import java.util.List;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Order;

public interface IOrderService {

	List<Order> list();

	ServerResponse<List<Order>> pageList(Integer page, Integer limit, Order order);

	ServerResponse<List<Order>> deleteByPrimaryKey(Integer id);

	ServerResponse<List<Order>> deleteAll(String ids);
}
