package com.situ.mall.vo;

import java.util.ArrayList;
import java.util.List;
/**
 * 购物车：是由很多购物项CartItemVO组成的
 */
public class CartVO {
	// 购物车里面购物项CartItemVO集合
	private List<CartItemVO> cartItemVOList = new ArrayList<>();

	public List<CartItemVO> getCartItemVOList() {
		return cartItemVOList;
	}

	public void setCartItemVOList(List<CartItemVO> cartItemVOList) {
		this.cartItemVOList = cartItemVOList;
	}
}
