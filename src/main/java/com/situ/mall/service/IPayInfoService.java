package com.situ.mall.service;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.PayInfo;

public interface IPayInfoService {

	ServerResponse pageList(Integer page, Integer limit, PayInfo payInfo);

	ServerResponse deleteById(Integer id);

	ServerResponse deleteAll(String ids);
}
