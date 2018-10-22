package com.situ.mall.controller.front;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.constant.MallConstant;
import com.situ.mall.entity.Product;
import com.situ.mall.service.IProductService;
import com.situ.mall.util.CartUtil;
import com.situ.mall.vo.CartItemVO;
import com.situ.mall.vo.CartVO;

@Controller
@RequestMapping(value = "/cart")
public class FrontCartController {

	@Autowired
	private IProductService productService;

	// "${ctx}/cart/getCartPage.shtml?productId=${product.id}&amount="+$("#amount").val()+"&isChecked=1";
	@RequestMapping(value = "/getCartPage.shtml")
	public String getCartPage(HttpServletRequest request, Model model) {
		// 将Cookie里面购物车转换成CartVO这个对象
		CartVO cartVO = CartUtil.getCartVOFromCookie(request);
		if (null != cartVO) {// 购物车存在
			List<CartItemVO> cartItemVOList = cartVO.getCartItemVOList();
			// CartItemVO里面的Product只有id，我们要在购物车页面展示商品的详细信息，
			// 所以要根据这个id查找出产品的详细信息，直接把原来的Product替换
			for (CartItemVO cartItemVO : cartItemVOList) {
				Product product = productService.selectByPrimaryKey(cartItemVO.getProduct().getId());
				cartItemVO.setProduct(product);
			}
			model.addAttribute("cartVO", cartVO);
		}
		return "/cart/cart";
	}

	@RequestMapping(value = "/addOrUpdateCart.shtml")
	@ResponseBody
	public ServerResponse addOrUpdateCart(Integer productId, Integer amount, Integer isChecked,
			HttpServletRequest request, HttpServletResponse response) {
		// 1、将Cookie里面的购物车转换为CartVO对象(类似于从数据库里面取出所有)
		CartVO cartVO = CartUtil.getCartVOFromCookie(request);
		if (null == cartVO) {
			cartVO = new CartVO();
		}

		// 2、往CartVO里面添加这个购物项
		// （购物车中所有数据转换为CartVO对象）
		boolean isExist = false;
		List<CartItemVO> cartItemVOList = cartVO.getCartItemVOList();
		Product product = productService.selectByPrimaryKey(productId);
		for (CartItemVO cartItemVO : cartItemVOList) {
			// 2.1、productId对应的商品已经在CartVO里面的话，只是将数量更新
			if (cartItemVO.getProduct().getId().intValue() == productId.intValue()) {
				isExist = true;
				// 只是更新isChecked，没有传递amount，这个amount就是null
				if (null != amount) {
					int newAmount = cartItemVO.getAmount() + amount;
					// 判断商品有没有查过库存
					if (newAmount > product.getStock()) {
						// 超出库存，返回false，添加购物车失败
						return ServerResponse.createError("超出库存");
					}
					cartItemVO.setAmount(newAmount);
				}
				if (null != isChecked) {
					// 将是否选中的状态修改为选中状态isChecked=1
					cartItemVO.setIsChecked(isChecked);
				}
				CartUtil.setCartVOToCookie(cartVO, response);
				return ServerResponse.createSuccess("更新成功");
			}
		}

		// 2.2、productId对应的商品不在CartVO里面的话，添加这个CartItemVO到CartVO
		// 在原来CartVO购物车里面没有找到这个商品，直接添加这个商品
		if (isExist == false) {
			CartItemVO cartItemVO = new CartItemVO();
			Product prod = new Product();
			prod.setId(productId);
			cartItemVO.setProduct(prod);
			cartItemVO.setAmount(amount);
			cartItemVO.setIsChecked(MallConstant.CART_CHECKED);

			cartItemVOList.add(cartItemVO);
		}

		// 3、将CartVO对象设置到Cookie（类似于将所有数据写到数据库中）
		CartUtil.setCartVOToCookie(cartVO, response);
		return ServerResponse.createSuccess("添加购物车成功");
	}

	@RequestMapping(value = "/deleteCartItemById.shtml")
	@ResponseBody
	public ServerResponse deleteCartItemById(Integer productId, HttpServletRequest request,
			HttpServletResponse response) {
		// 1、将Cookie里面的购物车转换为CartVO对象(类似于从数据库里面取出所有)
		CartVO cartVO = CartUtil.getCartVOFromCookie(request);
		if (null == cartVO) {
			return ServerResponse.createError("获取购物车失败");
		}

		List<CartItemVO> cartItemVOList = cartVO.getCartItemVOList();
		Iterator<CartItemVO> iterator = cartItemVOList.iterator();
		while (iterator.hasNext()) {
			CartItemVO cartItemVO = iterator.next();
			if (cartItemVO.getProduct().getId().intValue() == productId.intValue()) {
				iterator.remove();
			}
		}

		// 将CartVO对象写入到Cookie里面
		CartUtil.setCartVOToCookie(cartVO, response);
		return ServerResponse.createSuccess("删除购物车成功");
	}

	/**
	 * TODO: 可以加上异常情况的判断，例如：1、商品已经下架 2、库存不够 这些情况都应该返回添加购物车失败
	 * 
	 * @param cartVO
	 * @param productId
	 * @param amount
	 * @param isChecked
	 */
	private boolean addOrUpdateCart(CartVO cartVO, Integer productId, Integer amount, Integer isChecked) {
		boolean isExist = false;
		List<CartItemVO> cartItemVOList = cartVO.getCartItemVOList();
		Product product = productService.selectByPrimaryKey(productId);
		for (CartItemVO cartItemVO : cartItemVOList) {
			// 1、productId对应的商品已经在CartVO里面的话，只是将数量更新
			if (cartItemVO.getProduct().getId().intValue() == productId.intValue()) {
				isExist = true;
				// 只是更新isChecked，没有传递amount，这个amount就是null
				if (null != amount) {
					int newAmount = cartItemVO.getAmount() + amount;
					// 判断商品有没有查过库存
					if (newAmount > product.getStock()) {
						// 超出库存，返回false，添加购物车失败
						return false;
					}
					cartItemVO.setAmount(newAmount);
				}
				if (null != isChecked) {
					// 将是否选中的状态修改为选中状态isChecked=1
					cartItemVO.setIsChecked(isChecked);
				}
			}
		}

		// 2、productId对应的商品不在CartVO里面的话，添加这个CartItemVO到CartVO
		// 在原来CartVO购物车里面没有找到这个商品，直接添加这个商品
		if (isExist == false) {
			CartItemVO cartItemVO = new CartItemVO();
			Product prod = new Product();
			prod.setId(productId);
			cartItemVO.setProduct(prod);
			cartItemVO.setAmount(amount);
			cartItemVO.setIsChecked(MallConstant.CART_CHECKED);

			cartItemVOList.add(cartItemVO);
		}
		return true;
	}

	public static void main(String[] args) {
		// -128 ~ +127 放在缓存中
		Integer i1 = 128;
		Integer i2 = 128;
		if (i1 == i2) {
			System.out.println("==");
		}
		if (i1.intValue() == i2.intValue()) {
			System.out.println("****");
		}
	}
}