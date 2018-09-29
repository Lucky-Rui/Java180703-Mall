package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Category;
import com.situ.mall.mapper.CategoryMapper;
import com.situ.mall.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public ServerResponse<List<Category>> selectTopCategory() {
		List<Category> list = categoryMapper.selectTopCategory();
		return ServerResponse.createSuccess("查找成功", list);
	}

	@Override
	public ServerResponse<List<Category>> selectSecondCategory(Integer topCategoryId) {
		List<Category> list = categoryMapper.selectSecondCategory(topCategoryId);
		return ServerResponse.createSuccess("查找成功", list);
	}

}
