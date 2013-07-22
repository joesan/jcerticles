package org.q31.jcerticles.common.domain.content;

public class ContentSearchResultsVO {
	
	private String filePath;
	
	private String fileSummary;
	
	private String fileTitle;
	
	private int totalHits;	

	public int getTotalHits() {
		return totalHits;
	}

	public void setTotalHits(int totalHits) {
		this.totalHits = totalHits;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileSummary() {
		return fileSummary;
	}

	public void setFileSummary(String fileSummary) {
		this.fileSummary = fileSummary;
	}

	public String getFileTitle() {
		return fileTitle;
	}

	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}
		
}
