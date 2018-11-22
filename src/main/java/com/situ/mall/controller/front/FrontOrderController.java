package com.situ.mall.controller.front;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.constant.MallConstant;
import com.situ.mall.entity.Order;
import com.situ.mall.entity.OrderItem;
import com.situ.mall.entity.Shipping;
import com.situ.mall.entity.User;
import com.situ.mall.service.ICartService;
import com.situ.mall.service.IOrderItemService;
import com.situ.mall.service.IOrderService;
import com.situ.mall.service.IProductService;
import com.situ.mall.service.IShippingService;
import com.situ.mall.util.CartUtil;
import com.situ.mall.vo.CartItemVO;
import com.situ.mall.vo.CartVO;
import com.situ.mall.vo.PageBeanVO;

@RequestMapping(value = "/order")
@Controller
public class FrontOrderController {
	@Autowired
	private IShippingService shippingServie;
	@Autowired
	private IProductService productService;
	@Autowired
	private ICartService cartService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IOrderItemService orderItemService;

	@RequestMapping("/getOrderPage.shtml")
	public String getOrderPage(HttpServletRequest request, HttpSession session, Model model) {
		// 1、从Session中获得User对象
		User user = (User) session.getAttribute(MallConstant.SESSION_USER);
		// 2、通过user得到用户的收货地址
		List<Shipping> shippingList = shippingServie.selectByUserId(user.getId());
		model.addAttribute("shippingList", shippingList);

		// 改成从数据库里拿
		CartVO cartVO = CartUtil.getCartVOByUserFromDB(user, cartService, productService);
		List<CartItemVO> cartItemVOList = cartVO.getCartItemVOList();
		Iterator<CartItemVO> iterator = cartItemVOList.iterator();
		while (iterator.hasNext()) {// 只是判断有没有下一个
			CartItemVO item = iterator.next();
			// 没有勾选的移除
			if (item.getIsChecked() == MallConstant.CART_UNCHECKED) {
				iterator.remove();
				continue;
			}
		}
		model.addAttribute("cartVO", cartVO);

		return "/order/order";
	}

	@RequestMapping("/addOrder.shtml")
	@ResponseBody
	public ServerResponse addOrder(Order order) {
		Integer checked = MallConstant.CART_CHECKED;
		// 生成订单号：
		// 1.创建订单对象(和订单项数据)
		Date time = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS"); // 以现在的时间作为OrderNo
		String orderNoStr = sdf.format(time);
		long orderNo = Long.parseLong(orderNoStr);
		order.setOrderNo(orderNo); // 设置订单号

		ServerResponse serverResponse = orderService.addOrder(order, checked, cartService, productService);

		return serverResponse;
	}

	@RequestMapping("/deleteOrder.shtml")
	@ResponseBody
	public ServerResponse deleteOrder(String orderNo) {
		Long newOrderNo = Long.parseLong(orderNo);
		ServerResponse serverResponse = orderService.deleteByOrderNo(newOrderNo);

		return serverResponse;
	}

	@RequestMapping("/getOrderListPage.shtml")
	public String getOrderListPage(Integer page, Integer limit, HttpServletRequest request, HttpSession session,
			Model model) {
		// 1、从Session中获得User对象
		User user = (User) session.getAttribute(MallConstant.SESSION_USER);
		// 通过userId把这个用户的所有订单都查出来放到域对象中
		Integer userId = user.getId();
		ServerResponse serverResponse = orderService.selectOrderByUserId(page, limit, userId);

		Integer count = serverResponse.getCount();
		PageBeanVO pageBeanVO = new PageBeanVO(page, limit, count);
		// 将封装好的pageBeanVO放到域对象中用于分页
		model.addAttribute("pageBeanVO", pageBeanVO);

		// 将查找出来的所有订单放到域对象中
		List<Order> orderList = (List<Order>) serverResponse.getData();
		model.addAttribute("orderList", orderList);

		// 将查找出来的所有订单的商品项放到域对象中
		List<OrderItem> orderItemList = orderItemService.selectOrderItemByUserId(userId);
		model.addAttribute("orderItemList", orderItemList);

		return "/order/order_list";
	}

}
