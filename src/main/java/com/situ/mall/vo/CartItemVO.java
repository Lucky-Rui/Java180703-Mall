package com.situ.mall.vo;

import com.situ.mall.entity.Product;

/**
 * 购物项
 */
public class CartItemVO {
	// 购物车中的商品
	private Product product;
	// 购买商品的数量
	private Integer amount;
	// 当前这个商品是否被选中：0：未选中 1：选中
	private Integer isChecked;

	public CartItemVO(Product product, Integer amount, Integer isChecked) {
		super();
		this.product = product;
		this.amount = amount;
		this.isChecked = isChecked;
	}

	public CartItemVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(Integer isChecked) {
		this.isChecked = isChecked;
	}

	@Override
	public String toString() {
		return "CartItemVO [product=" + product + ", amount=" + amount + ", isChecked=" + isChecked + "]";
	}
}
