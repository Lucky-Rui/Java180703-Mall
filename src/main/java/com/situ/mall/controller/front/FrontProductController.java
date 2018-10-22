package com.situ.mall.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.mall.entity.Product;
import com.situ.mall.service.ICategoryService;
import com.situ.mall.service.IProductService;

@RequestMapping(value = "/product")
@Controller
public class FrontProductController {
	@Autowired
	private IProductService productService;

	// 商品列表界面
	@RequestMapping(value = "/getProductListPage.shtml")
	public String getProductListPage(Integer categoryId, Model model) {
		// 查出这个分类下面所有的商品
		List<Product> productList = (List<Product>) productService.selectByCategoryId(categoryId);
		model.addAttribute("productList", productList);
		// 商品分类
		return "/category/product_category";
	}

	// 商品详情界面
	@RequestMapping(value = "/getProductDetailPage.shtml")
	public String getProductDetailPage(Integer productId, Model model) {
		// 要展示详情的商品
		Product product = productService.selectByPrimaryKey(productId);
		model.addAttribute("product", product);
		return "/product/product_detail";
	}
}
