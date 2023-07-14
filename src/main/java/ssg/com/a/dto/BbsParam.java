package ssg.com.a.dto;

import java.io.Serializable;

public class BbsParam implements Serializable{
	private String choice; // 카테고리 
	private String search; // 검색어
	private int pageNumber; 
	
	public BbsParam() {
		// TODO Auto-generated constructor stub
	}

	public BbsParam(String choice, String search, int i) {
		super();
		this.choice = choice;
		this.search = search;
		this.pageNumber = i;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString() {
		return "BbsParam [choice=" + choice + ", search=" + search + ", pageNumber=" + pageNumber + "]";
	}
	
	
}
