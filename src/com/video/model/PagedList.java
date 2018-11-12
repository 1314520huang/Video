package com.video.model;

import java.io.Serializable;
import java.util.List;

public class PagedList<T> implements Serializable {

	
	private static final long serialVersionUID = -5106492260889304373L;

	public PagedList() {
		super();
	}
	
	public PagedList(List results, Page page) {
		super();
		this.results = results;
		this.page = page;
	}

	protected List<T> results;
	
	protected Page page;	

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
