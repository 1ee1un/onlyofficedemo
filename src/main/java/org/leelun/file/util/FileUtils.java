package org.leelun.file.util;

import java.util.Objects;

import org.leelun.file.model.FileType;

public class FileUtils {

	private static final String EMPTY_STRING = "";
	
	/**
	 * 	获取文件扩展名
	 * @param fileName
	 * @return
	 */
	public static String getExtension(String fileName) {
		if (Objects.isNull(fileName)) {
			return EMPTY_STRING;
		}
		int indexOf = fileName.lastIndexOf(".");
		if (indexOf < 0) {
			return EMPTY_STRING;
		}
		return fileName.substring(indexOf).trim();
	}

	/**
	 * 	获取文件类型
	 * @param filename
	 * @return
	 */
	public static String getFileType(String fileName) {
		String extension = getExtension(fileName);
		FileType[] values = FileType.values();
		for (FileType fileType : values) {
			if (fileType.support(extension)) {
				return fileType.name().toLowerCase();
			}
		}
		return null;
	}
	
}
