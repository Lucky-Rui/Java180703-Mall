package com.situ.mall.vo;

public class PageBeanVO {
	private Integer page;

	private Integer limit;

	private Integer totalCount;

	private Integer pageNum;

	public PageBeanVO() {
		super();
	}

	public PageBeanVO(Integer page, Integer limit, Integer totalCount, Integer pageNum) {
		super();
		this.page = page;
		this.limit = limit;
		this.totalCount = totalCount;
		this.pageNum = pageNum;
	}

	public PageBeanVO(Integer page, Integer limit, Integer totalCount) {
		super();
		this.page = page;
		this.limit = limit;
		this.totalCount = totalCount;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageNum() {
		pageNum = (int) Math.ceil((double) totalCount / limit);
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "PageBeanVO [page=" + page + ", limit=" + limit + ", totalCount=" + totalCount + ", pageNum=" + pageNum
				+ "]";
	}
}
