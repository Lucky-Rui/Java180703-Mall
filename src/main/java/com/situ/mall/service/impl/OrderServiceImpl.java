package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Order;
import com.situ.mall.mapper.OrderMapper;
import com.situ.mall.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public List<Order> list() {
		return orderMapper.list();
	}

	@Override
	public ServerResponse<List<Order>> pageList(Integer page, Integer limit, Order order) {
		// 1、设置分页
		PageHelper.startPage(page, limit);
		// 2、执行查询 （分页之后的数据）
		List<Order> list = orderMapper.pageList(order);
		// 3、count
		// 第一种：分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>
		// Integer count = (int) ((Page) list).getTotal();
		// 第二种：用PageInfo对结果进行包装
		PageInfo<Order> pageInfo = new PageInfo<Order>(list);
		Integer count = (int) pageInfo.getTotal();
		return ServerResponse.createSuccess("查询成功", count, list);
	}

	@Override
	public ServerResponse<List<Order>> deleteByPrimaryKey(Integer id) {
		try {
			int count = orderMapper.deleteByPrimaryKey(id);
			if (count == 1) {
				return ServerResponse.createSuccess("删除成功");
			} else {
				return ServerResponse.createError("删除失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除失败");
		}
	}

	@Override
	public ServerResponse<List<Order>> deleteAll(String ids) {
		String[] idArray = ids.split(",");
		int count = orderMapper.deleteAll(idArray);
		if (count == idArray.length) {
			return ServerResponse.createSuccess("删除成功");
		} else {
			return ServerResponse.createError("删除失败");
		}
	}

}
