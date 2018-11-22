package com.situ.mall.service;

import java.util.List;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Category;

public interface ICategoryService {

	ServerResponse<List<Category>> selectTopCategory();

	ServerResponse<List<Category>> selectSecondCategory(Integer topCategoryId);

	/**
	 * 返回所有的一级分类
	 * 
	 * @return
	 */
	List<Category> selectTopCategoryList();

	List<Category> selectSecondCategoryList();

	ServerResponse getCategoryCount();

	Category selectByCategoryId(Integer categoryId);
}
