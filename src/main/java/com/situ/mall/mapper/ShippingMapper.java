package com.situ.mall.mapper;

import com.situ.mall.entity.Shipping;

public interface ShippingMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shipping
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shipping
	 * @mbggenerated
	 */
	int insert(Shipping record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shipping
	 * @mbggenerated
	 */
	int insertSelective(Shipping record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shipping
	 * @mbggenerated
	 */
	Shipping selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shipping
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Shipping record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shipping
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Shipping record);
}