package org.leelun.file.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 	
 * @author leelun
 * @date 2020年5月11日
 *
 */
@JsonInclude(Include.NON_NULL)
public class EditorConfig {

	/**
	 * 	打开模型   view   edit
	 */
	private String mode = "edit";
	
	/**
	 * 	编辑保存url
	 */
	private String callbackUrl;
	
	/**
	 * 	界面语言
	 */
	private String lang = "zh-CN";
	
	/**
	 * 	编辑用户信息
	 */
	private User user;
	
	/**
	 * 	自定义设置
	 */
	private Customization customization;
	
	/**
	 * 	
	 */
	private Embedded embedded;

	public EditorConfig() {
		user = new User();
		customization = new Customization();
	}

	public void InitDesktop(String url) {
		embedded = new Embedded();
		embedded.setSaveUrl(url);
		embedded.setEmbedUrl(url);
		embedded.setShareUrl(url);
		embedded.setToolbarDocked("top");
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Customization getCustomization() {
		return customization;
	}

	public void setCustomization(Customization customization) {
		this.customization = customization;
	}

	public Embedded getEmbedded() {
		return embedded;
	}

	public void setEmbedded(Embedded embedded) {
		this.embedded = embedded;
	}

}
