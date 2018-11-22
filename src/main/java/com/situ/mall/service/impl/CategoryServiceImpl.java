package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Category;
import com.situ.mall.mapper.CategoryMapper;
import com.situ.mall.service.ICategoryService;
import com.situ.mall.vo.CategoryCountVO;

@Service
public class CategoryServiceImpl implements ICategoryService {
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

	@Override
	public List<Category> selectTopCategoryList() {
		return categoryMapper.selectTopCategory();
	}

	@Override
	public List<Category> selectSecondCategoryList() {
		return categoryMapper.selectSecondCategoryList();
	}

	@Override
	public ServerResponse getCategoryCount() {
		List<CategoryCountVO> list = categoryMapper.getCategoryCount();
		return ServerResponse.createSuccess("成功", list);
	}

	@Override
	public Category selectByCategoryId(Integer categoryId) {
		Category category = categoryMapper.selectByPrimaryKey(categoryId);
		return category;
	}
}
