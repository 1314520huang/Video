package com.video.model;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;

public class Page extends RowBounds implements Serializable {

	private static final long serialVersionUID = 5531121771243653173L;

	protected int pageIndex = 1;
	
	protected int pageSize = 10;
	
	protected int pageCount = 0;
	
	protected int rowCount = 0;
	
	protected String orderBy;
	protected Boolean asc = true;
	
	public Page(){
		super();
	}
	
	public Page(int pageSize, int pageIndex){
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}
	

	public int getPageIndex() {
		if(this.pageIndex < 1){
			return 1;
		}
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		if (this.rowCount % this.pageSize == 0) {
			return this.rowCount / this.pageSize;
		}
		return this.rowCount / this.pageSize + 1;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public int getOffset() {
		return this.pageSize * (getPageIndex() - 1);
	}

	public int getLimit() {
		return this.pageSize * getPageIndex();
	}

	public Boolean getAsc() {
		return asc;
	}

	public void setAsc(Boolean asc) {
		this.asc = asc;
	}
	
	public String getOrderByClause(){
		if(StringUtils.isNotEmpty(orderBy)){
			return orderBy+" "+(asc ? "asc" : "desc");
		}
		return null;
	}
}
