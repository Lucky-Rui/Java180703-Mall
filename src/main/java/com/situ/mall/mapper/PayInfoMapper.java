package com.situ.mall.mapper;

import com.situ.mall.entity.PayInfo;

public interface PayInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_info
     *
     * @mbggenerated
     */
    int insert(PayInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_info
     *
     * @mbggenerated
     */
    int insertSelective(PayInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_info
     *
     * @mbggenerated
     */
    PayInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PayInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PayInfo record);
}