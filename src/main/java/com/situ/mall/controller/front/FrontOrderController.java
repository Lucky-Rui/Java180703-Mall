package com.situ.mall.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/order")
@Controller
public class FrontOrderController {
	/*
	 * @Autowired private IShippingService shippingService;
	 * 
	 * @Autowired private IProductService productService;
	 * 
	 * @Autowired private IOrderService orderService;
	 * 
	 * @RequestMapping("/getOrderPage.shtml") public String
	 * getOrderPage(HttpServletRequest request,HttpSession session, Model model)
	 * { // 1、从Session中获得User对象 User user = (User)
	 * session.getAttribute(MallConstant.SESSION_USER); // 2、通过user得到用户的收货地址
	 * List<Shipping> shippings = shippingService.selectByUserId(user.getId());
	 * model.addAttribute("shippings", shippings); //
	 * 3、将Cookie里面购物城信息转换为CartVO对象 CartVO cartVO =
	 * CartUtil.getCartVOFromCookie(request); List<CartItemVO> cartItemVOList =
	 * cartVO.getCartItemVOList(); Iterator<CartItemVO> iterator =
	 * cartItemVOList.iterator(); while (iterator.hasNext()) {//只是判断有没有下一个
	 * CartItemVO item = iterator.next(); // 没有勾选的移除 if (item.getIsChecked() ==
	 * MallConstant.CART_UNCHECKED) { iterator.remove(); continue; } //
	 * 将勾选的product更新为详细信息，因为cookie里面的product只有id Product product =
	 * productService.selectByPrimaryKey(item.getProduct().getId()); //
	 * 覆盖CartItemVO里面的Product item.setProduct(product); }
	 * model.addAttribute("cartVO", cartVO); return "/order/order"; }
	 * 
	 *//**
		 * 生成订单页面
		 * 
		 * @param shippingId
		 * @return
		 */
	/*
	 * @RequestMapping("/addOrder.shtml")
	 * 
	 * @ResponseBody public ServerResponse addOrder(Integer shippingId) { //
	 * 1、创建订单对象 Order Order order = new Order();
	 * order.setOrderNo(201810151101787L);//精确到毫秒
	 * order.setUserId(user.getId());// user从session里面得到
	 * order.setShippingId(shippingId); //... // 将订单插入数据库
	 * orderService.add(order);
	 * 
	 * // 2、订单下面还有订单项OrderItem CartVO cartVO =
	 * CartUtil.getCartVOFromCookie(request); List<CartItemVO> cartItemVOList =
	 * cartVO.getCartItemVOList(); Iterator<CartItemVO> iterator =
	 * cartItemVOList.iterator(); while (iterator.hasNext()) { CartItemVO
	 * cartItemVO = iterator.next(); if (cartItemVO.getIsChecked() ==
	 * MallConstant.CART_CHECKED) { // 将CartItemVO转换成OrderItem OrderItem
	 * orderItem = new OrderItem(); orderItem.setOrderNo(order.getOrderNo());
	 * orderItem.setUserId(user.getId()); Product product =
	 * productService.selectByPrimaryKey(cartItemVO.getProduct().getId());
	 * orderItem.setQuantity(cartItemVO.getAmount());
	 * orderItem.setProductName(product.getName());
	 * 
	 * // 将订单项插入数据库 orderService.addOrderItem(orderItem); //
	 * cookie中的这个购物项已经生成为订单项插入到数据库， // 所以Cookie购物车里面可以移除 iterator.remove(); } }
	 * 
	 * // 将购物车写回到Cookie CartUtil.setCartVOToCookie(cartVO, response);
	 * 
	 * return ServerResponse.createSuccess(); }
	 * 
	 */}
