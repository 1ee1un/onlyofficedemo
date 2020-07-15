package org.leelun.file.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

import org.leelun.file.service.IFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 	文件管理
 * @author leelun
 * @date 2020年5月11日
 *
 */
@Service
public class FileServiceImpl implements IFileService{
	
	private static final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);
	
	@Value("${fileServer.root-path}")
	private String rootPath;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public InputStream view(String fileName) {
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(rootPath, fileName));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("文件不存在");
		}
		return inputStream;
	}

	@Override
	public String save(String json,String fileName) {
		JsonNode root;
		try {
			root = objectMapper.readTree(json);
		} catch (IOException e) {
			log.error("解析json失败",e);
			return "{\"error\":-1}";
		}
		int status = root.get("status").asInt();
		switch (status) {
		case 2:
		case 3:
			log.info("开始保存文件：" + fileName);
			String url = root.get("url").asText();
			ResponseEntity<Resource> entity = restTemplate.getForEntity(url, Resource.class);
			if (Objects.equals(HttpStatus.OK, entity.getStatusCode())) {
				try {
					InputStream in = entity.getBody().getInputStream();
					Path savePath = Paths.get(rootPath, fileName);
					Files.copy(in, savePath,StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					log.error("写入文件失败",e);
					return "{\"error\":-1}";
				}
			}
			return "{\"error\":0}";
		default:
			return "{\"error\":0}";
		}
	}

	@Override
	public void upload(String fileName, InputStream inputStream) {
		Path path = Paths.get(rootPath, fileName);
		try {
			Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException("上传文件失败，失败原因：" + e.getMessage());
		}
	}

}
