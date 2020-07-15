package org.leelun.file.service;

import java.io.InputStream;

public interface IFileService {

	/**
	 * 	文件预览
	 * @param fileName
	 * @return
	 */
	InputStream view(String fileName);

	/**
	 * 	文件上传  保存
	 * @param fileName
	 * @param inputStream
	 */
	void upload(String fileName, InputStream inputStream);
	
	/**
	 * 	保存
	 * @return
	 */
	String save(String json,String fileName);
	
}
