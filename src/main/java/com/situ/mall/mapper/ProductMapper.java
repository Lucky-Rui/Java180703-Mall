package com.situ.mall.mapper;

import java.util.List;

import com.situ.mall.entity.Product;

public interface ProductMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product
	 * @mbggenerated
	 */
	int insert(Product record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product
	 * @mbggenerated
	 */
	int insertSelective(Product record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product
	 * @mbggenerated
	 */
	Product selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Product record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Product record);

	/**
	 * 查找�?有商�?
	 * 
	 * @return
	 */
	List<Product> list();

	/**
	 * 多条件搜索和分页
	 * 
	 * @param product
	 * @return
	 */
	List<Product> pageList(Product product);

	/**
	 * 批量删除
	 * 
	 * @param idArray
	 * @return
	 */
	int deleteAll(String[] idArray);
}