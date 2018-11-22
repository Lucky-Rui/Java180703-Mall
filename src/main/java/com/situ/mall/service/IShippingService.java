package com.situ.mall.service;

import java.util.List;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Shipping;

public interface IShippingService {
	
	ServerResponse pageList(Integer page, Integer limit, Shipping shipping);

	ServerResponse deleteById(Integer id);

	ServerResponse deleteAll(String ids);

	List<Shipping> selectByUserId(Integer id);
}
