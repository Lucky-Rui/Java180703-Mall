package com.situ.mall.vo;

public class CategoryCountVO {
	/**
	 * 分类名称
	 */
	private String name;
	/**
	 * 分类下面对应的商品数量
	 */
	private Integer count;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CategoryCountVO [name=" + name + ", count=" + count + "]";
	}
}
