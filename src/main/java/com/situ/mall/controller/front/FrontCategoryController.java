package com.situ.mall.controller.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.constant.MallConstant;
import com.situ.mall.entity.Category;
import com.situ.mall.entity.Product;
import com.situ.mall.entity.User;
import com.situ.mall.service.ICartService;
import com.situ.mall.service.ICategoryService;
import com.situ.mall.service.IProductService;
import com.situ.mall.util.CartUtil;
import com.situ.mall.vo.CartVO;
import com.situ.mall.vo.PageBeanVO;

@Controller
@RequestMapping("/category")
public class FrontCategoryController {
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IProductService productService;
	@Autowired
	private ICartService cartService;

	@RequestMapping("/getCategoryPage.shtml")
	public String getCategoryPage(Integer categoryId, Integer page, Integer limit, Model model,
			HttpServletRequest request) {
		// 查出一级分类，放到域对象中
		// parent_id=0的分类
		ServerResponse topCategory = categoryService.selectTopCategory();
		List<Category> topCategoryList = (List<Category>) topCategory.getData();
		model.addAttribute("topCategoryList", topCategoryList);

		Category category = categoryService.selectByCategoryId(categoryId);
		model.addAttribute("category", category);

		ServerResponse serverResponse = productService.selectProductListByCategoryId(categoryId, page, limit);

		Integer count = serverResponse.getCount();
		PageBeanVO pageBeanVO = new PageBeanVO(page, limit, count);
		// 将封装好的pageBeanVO放到域对象中用于分页
		model.addAttribute("pageBeanVO", pageBeanVO);

		// 将查到的商品集合放到域对象中
		List<Product> productList = (List<Product>) serverResponse.getData();
		model.addAttribute("ProductList", productList);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(MallConstant.SESSION_USER);
		if (user != null) {
			CartVO cartVO = CartUtil.getCartVOByUserFromDB(user, cartService, productService);
			model.addAttribute("cartVO", cartVO);
		} else {
			// 将Cookie里面购物车转换成CartVO这个对象
			CartVO cartVO = CartUtil.getCartVOFromCookie(request);
			model.addAttribute("cartVO", cartVO);
		}

		return "/category/category";
	}
}
