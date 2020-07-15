package org.leelun.file.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Embedded {

	private String saveUrl;
	
	private String embedUrl;
	
	private String shareUrl;
	
	private String toolbarDocked;

	public String getSaveUrl() {
		return saveUrl;
	}

	public void setSaveUrl(String saveUrl) {
		this.saveUrl = saveUrl;
	}

	public String getEmbedUrl() {
		return embedUrl;
	}

	public void setEmbedUrl(String embedUrl) {
		this.embedUrl = embedUrl;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

	public String getToolbarDocked() {
		return toolbarDocked;
	}

	public void setToolbarDocked(String toolbarDocked) {
		this.toolbarDocked = toolbarDocked;
	}

}
