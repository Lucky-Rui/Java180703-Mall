package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Shipping;
import com.situ.mall.mapper.ShippingMapper;
import com.situ.mall.service.IShippingService;

@Service
public class ShippingServiceImpl implements IShippingService {
	@Autowired
	private ShippingMapper shippingMapper;

	@Override
	public ServerResponse pageList(Integer page, Integer limit, Shipping shipping) {
		PageHelper.startPage(page, limit);
		List<Shipping> list = shippingMapper.pageList(shipping);
		PageInfo pageInfo = new PageInfo(list);
		Integer count = (int) pageInfo.getTotal();

		return ServerResponse.createSuccess("查询成功", count, list);

	}

	@Override
	public ServerResponse deleteById(Integer id) {
		try {
			int count = shippingMapper.deleteByPrimaryKey(id);
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
	public ServerResponse deleteAll(String ids) {
		String[] idArray = ids.split(",");
		try {
			int count = shippingMapper.deleteAll(idArray);
			if (count == idArray.length) {
				return ServerResponse.createSuccess("删除成功");
			} else {
				return ServerResponse.createError("删除失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除失败");
		}
	}

	@Override
	public List<Shipping> selectByUserId(Integer userId) {
		List<Shipping> list = shippingMapper.selectByUserId(userId);
		return list;
	}

}
