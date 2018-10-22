package com.situ.mall.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.mall.entity.Category;
import com.situ.mall.service.ICategoryService;

@Controller
public class FrontIndexController {
	@Autowired
	private ICategoryService categoryService;

	@RequestMapping("/indexFront")
	public String indexBack(Model model) {

		// 查出一级分类，放到域对象中
		// // parent_id=0的分类
		List<Category> topCategoryList = categoryService.selectTopCategoryList();
		model.addAttribute("topCategoryList", topCategoryList);
		// parent_id！=0的分类
		List<Category> secondCategoryList = categoryService.selectSecondCategoryList();
		model.addAttribute("secondCategoryList", secondCategoryList);
		return "/index_front";
	}

}
