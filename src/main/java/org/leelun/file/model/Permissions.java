package org.leelun.file.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Permissions {

	/**
	 * 	是否可以评论
	 */
	private Boolean comment;
	
	/**
	 * 	是否可以下载    显示下载按钮
	 */
	private Boolean download;
    
	/**
	 * 	是否可以编辑  显示编辑按钮
	 */
	private Boolean edit;
	
	/**
	 * 	是否可以打印  显示打印按钮
	 */
	private Boolean print;
    
	/**
	 * 	
	 */
	private Boolean fillForms;
    
	private Boolean modifyFilter;
    
	private Boolean modifyContentControl;
    
	/**
	 * 	是否可以审阅文档    显示审阅按钮
	 */
	private Boolean review;

    public Permissions(String mode, String type, Boolean canEdit){
        comment = !mode.equals("view") && !mode.equals("fillForms") && !mode.equals("embedded") && !mode.equals("blockcontent");
        download = true;
        edit = canEdit && (mode.equals("edit") || mode.equals("filter") || mode.equals("blockcontent"));
        fillForms = !mode.equals("view") && !mode.equals("comment") && !mode.equals("embedded") && !mode.equals("blockcontent");
        modifyFilter = !mode.equals("filter");
        modifyContentControl = !mode.equals("blockcontent");
        review = mode.equals("edit") || mode.equals("review");
    }

	public Boolean getComment() {
		return comment;
	}

	public void setComment(Boolean comment) {
		this.comment = comment;
	}

	public Boolean getDownload() {
		return download;
	}

	public void setDownload(Boolean download) {
		this.download = download;
	}

	public Boolean getEdit() {
		return edit;
	}

	public void setEdit(Boolean edit) {
		this.edit = edit;
	}
	
	public Boolean getPrint() {
		return print;
	}

	public void setPrint(Boolean print) {
		this.print = print;
	}

	public Boolean getFillForms() {
		return fillForms;
	}

	public void setFillForms(Boolean fillForms) {
		this.fillForms = fillForms;
	}

	public Boolean getModifyFilter() {
		return modifyFilter;
	}

	public void setModifyFilter(Boolean modifyFilter) {
		this.modifyFilter = modifyFilter;
	}

	public Boolean getModifyContentControl() {
		return modifyContentControl;
	}

	public void setModifyContentControl(Boolean modifyContentControl) {
		this.modifyContentControl = modifyContentControl;
	}

	public Boolean getReview() {
		return review;
	}

	public void setReview(Boolean review) {
		this.review = review;
	}
    
}
