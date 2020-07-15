package org.leelun.file.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 	onlyoffice 文档对象
 * @author leelun
 * @date 2020年5月11日
 *
 */
@JsonInclude(Include.NON_NULL)
public class Document {

	/**
	 * 	查看或编辑文档请求的路径
	 */
	private String url;

	/**
	 * 	文档文件名
	 */
	private String title;

	/**
	 * 	文件类型  即文件后缀名   "docx"
	 */
	private String fileType;

	/**
	 * 	<p>文档识别的唯一文档标识符</p>
	 *  <p>如果发送已知密钥，则文档将从缓存中获取</p>
	 *  <p>每次编辑和保存文档时，都必须重新生成密钥</p>
	 *  <p>文档url可以用作密钥，但没有特殊字符，长度限制为20个符号</p>
	 */
	private String key;

	private Permissions permissions;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Permissions getPermissions() {
		return permissions;
	}

	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}

}
