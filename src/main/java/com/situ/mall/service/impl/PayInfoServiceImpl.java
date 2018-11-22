package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.PayInfo;
import com.situ.mall.mapper.PayInfoMapper;
import com.situ.mall.service.IPayInfoService;

@Service
public class PayInfoServiceImpl implements IPayInfoService {

	private PayInfoMapper payInfoMapper;

	@Override
	public ServerResponse pageList(Integer page, Integer limit, PayInfo payInfo) {
		PageHelper.startPage(page, limit);
		List<PayInfo> list = payInfoMapper.pageList(payInfo);
		PageInfo pageInfo = new PageInfo(list);
		Integer count = (int) pageInfo.getTotal();

		return ServerResponse.createSuccess("查询成功", count, list);
	}

	@Override
	public ServerResponse deleteById(Integer id) {
		try {
			int count = payInfoMapper.deleteByPrimaryKey(id);
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
			int count = payInfoMapper.deleteAll(idArray);
			if (count == idArray.length) {
				return ServerResponse.createSuccess("删除成功");
			} else {
				return ServerResponse.createError("删除失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除失败");
		}
	}

}
