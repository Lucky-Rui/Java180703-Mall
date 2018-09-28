package com.situ.mall.entity;

import java.util.Date;

public class Category {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column category.id
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column category.parent_id
	 * @mbggenerated
	 */
	private Integer parentId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column category.name
	 * @mbggenerated
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column category.status
	 * @mbggenerated
	 */
	private Boolean status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column category.sort_order
	 * @mbggenerated
	 */
	private Integer sortOrder;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column category.create_time
	 * @mbggenerated
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column category.update_time
	 * @mbggenerated
	 */
	private Date updateTime;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table category
	 * @mbggenerated
	 */
	public Category(Integer id, Integer parentId, String name, Boolean status, Integer sortOrder, Date createTime,
			Date updateTime) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.status = status;
		this.sortOrder = sortOrder;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table category
	 * @mbggenerated
	 */
	public Category() {
		super();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column category.id
	 * @return  the value of category.id
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column category.id
	 * @param id  the value for category.id
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column category.parent_id
	 * @return  the value of category.parent_id
	 * @mbggenerated
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column category.parent_id
	 * @param parentId  the value for category.parent_id
	 * @mbggenerated
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column category.name
	 * @return  the value of category.name
	 * @mbggenerated
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column category.name
	 * @param name  the value for category.name
	 * @mbggenerated
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column category.status
	 * @return  the value of category.status
	 * @mbggenerated
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column category.status
	 * @param status  the value for category.status
	 * @mbggenerated
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column category.sort_order
	 * @return  the value of category.sort_order
	 * @mbggenerated
	 */
	public Integer getSortOrder() {
		return sortOrder;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column category.sort_order
	 * @param sortOrder  the value for category.sort_order
	 * @mbggenerated
	 */
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column category.create_time
	 * @return  the value of category.create_time
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column category.create_time
	 * @param createTime  the value for category.create_time
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column category.update_time
	 * @return  the value of category.update_time
	 * @mbggenerated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column category.update_time
	 * @param updateTime  the value for category.update_time
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table category
	 * @mbggenerated
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", parentId=").append(parentId);
		sb.append(", name=").append(name);
		sb.append(", status=").append(status);
		sb.append(", sortOrder=").append(sortOrder);
		sb.append(", createTime=").append(createTime);
		sb.append(", updateTime=").append(updateTime);
		sb.append("]");
		return sb.toString();
	}
}