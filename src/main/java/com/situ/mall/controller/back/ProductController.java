package com.situ.mall.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Product;
import com.situ.mall.service.IProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@RequestMapping("/getProductPage")
	public String getProductPage() {
		return "/product/product_list";
	}

	@RequestMapping("/pageList")
	@ResponseBody
	public ServerResponse<List<Product>> pageList(Integer page, Integer limit, Product product) {
		return productService.pageList(page, limit, product);
	}

	@RequestMapping(value = "/deleteByPrimaryKey")
	@ResponseBody
	public ServerResponse<List<Product>> deleteByPrimaryKey(Integer id) {
		return productService.deleteByPrimaryKey(id);
	}
}