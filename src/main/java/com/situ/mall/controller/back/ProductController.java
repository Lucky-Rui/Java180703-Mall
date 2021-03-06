package com.situ.mall.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Product;
import com.situ.mall.service.IProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@RequestMapping("/getProductListPage")
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

	@RequestMapping(value = "/deleteAll")
	@ResponseBody
	public ServerResponse<List<Product>> deleteAll(String ids) {
		return productService.deleteAll(ids);
	}

	@RequestMapping(value = "/getProductInsertPage")
	public String getProductAddPage() {
		return "/product/product_insert";
	}

	@RequestMapping(value = "/insertProduct")
	@ResponseBody
	public ServerResponse<List<Product>> insertProduct(Product product) {
		return productService.insertProduct(product);
	}

	@RequestMapping(value = "/getProductDetailPage")
	public String getProductDetailPage(Model model, Integer id) {
		Product product = productService.selectByPrimaryKey(id);
		model.addAttribute("product", product);
		return "/product/product_detail";
	}

	@RequestMapping(value = "/getProductUpdatePage")
	public String getProductUpdatePage(Model model, Integer id) {
		Product product = productService.selectByPrimaryKey(id);
		model.addAttribute("product", product);
		return "/product/product_update";
	}

	@RequestMapping(value = "/updateByPrimaryKey")
	@ResponseBody
	public ServerResponse<List<Product>> updateByPrimaryKey(Product product) {
		System.out.println(product);
		return productService.updateByPrimaryKey(product);
	}
}