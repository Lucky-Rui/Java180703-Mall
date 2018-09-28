package com.situ.mall.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Order;
import com.situ.mall.service.IOrderService;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@RequestMapping("/getOrderPage")
	public String getOrderPage() {
		return "/order/order_list";
	}

	@RequestMapping("/pageList")
	@ResponseBody
	public ServerResponse<List<Order>> pageList(Integer page, Integer limit, Order order) {
		return orderService.pageList(page, limit, order);
	}

	@RequestMapping(value = "/deleteByPrimaryKey")
	@ResponseBody
	public ServerResponse<List<Order>> deleteByPrimaryKey(Integer id) {
		return orderService.deleteByPrimaryKey(id);
	}

	@RequestMapping(value = "/deleteAll")
	@ResponseBody
	public ServerResponse<List<Order>> deleteAll(String ids) {
		return orderService.deleteAll(ids);
	}
}