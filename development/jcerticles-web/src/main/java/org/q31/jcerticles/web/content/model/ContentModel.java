package org.q31.jcerticles.web.content.model;

import java.util.List;

import org.q31.jcerticles.domain.content.ContentSearchResultsVO;

public class ContentModel {
	
	private String searchQuery;
	
	private int skipRecords;
	
	private int takeRecords;
	
	private int searchResultFlag = 1;
	
	private int totalSearchHits;
		
	public int getTotalSearchHits() {
		return totalSearchHits;
	}

	public void setTotalSearchHits(int totalSearchHits) {
		this.totalSearchHits = totalSearchHits;
	}

	private List<ContentSearchResultsVO> fileList;	

	public int getSkipRecords() {
		return skipRecords;
	}

	public void setSkipRecords(int skipRecords) {
		this.skipRecords = skipRecords;
	}

	public int getTakeRecords() {
		return takeRecords;
	}

	public void setTakeRecords(int takeRecords) {
		this.takeRecords = takeRecords;
	}

	public int getSearchResultFlag() {
		return searchResultFlag;
	}

	public void setSearchResultFlag(int searchResultFlag) {
		this.searchResultFlag = searchResultFlag;
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	public List < ContentSearchResultsVO > getFileList() {
		return fileList;
	}

	public void setFileList(List < ContentSearchResultsVO > fileList) {
		this.fileList = fileList;
	}	
}
