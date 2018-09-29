package com.situ.mall.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Category;
import com.situ.mall.service.ICategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;

	@RequestMapping("/selectTopCategory")
	@ResponseBody
	public ServerResponse<List<Category>> selectTopCategory() {
		return categoryService.selectTopCategory();
	}

	@RequestMapping("/selectSecondCategory")
	@ResponseBody
	public ServerResponse<List<Category>> selectSecondCategory(Integer topCategoryId) {
		return categoryService.selectSecondCategory(topCategoryId);
	}
}