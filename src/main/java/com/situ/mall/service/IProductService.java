package com.situ.mall.service;

import java.util.List;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Product;

public interface IProductService {

	/**
	 * 所有商品集合
	 * 
	 * @return
	 */
	List<Product> list();

	/**
	 * 多条件搜索和分页
	 * 
	 * @param page
	 * @param limit
	 * @param product
	 * @return
	 */
	ServerResponse<List<Product>> pageList(Integer page, Integer limit, Product product);

	/**
	 * 根据id删除商品
	 * 
	 * @param id
	 * @return
	 */
	ServerResponse<List<Product>> deleteByPrimaryKey(Integer id);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	ServerResponse<List<Product>> deleteAll(String ids);

	/**
	 * 添加商品
	 * 
	 * @param product
	 * @return
	 */
	ServerResponse<List<Product>> insertProduct(Product product);

	/**
	 * 编辑商品
	 * 
	 * @param product
	 * @return
	 */
	ServerResponse<List<Product>> updateByPrimaryKey(Product product);

	/**
	 * 获得指定id的商品信息
	 * 
	 * @param id
	 * @return
	 */
	Product selectByPrimaryKey(Integer id);

}
