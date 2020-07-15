package org.leelun.file.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.leelun.file.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 	文件管理
 *
 */
@Controller
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private IFileService fileService;

	/**
	 * 	文件预览
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/view/{fileName}")
	public void view(@PathVariable("fileName") String fileName,HttpServletResponse response) throws IOException {
		// 根据文件名获取文件流
		String mimeType = URLConnection.guessContentTypeFromName(fileName);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
		response.setHeader("content-Type", mimeType);
		response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", URLEncoder.encode(fileName, "UTF-8")));
		try (InputStream inputStream = fileService.view(fileName)){
			IOUtils.copy(inputStream, response.getOutputStream());
		} catch (IOException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "写入数据失败,失败原因：" + e.getMessage());
		}
	}
	
	/**
	 * 	文件上传
	 * @return
	 * @throws ServletException 
	 * @throws IOException 
	 */
	@ResponseBody
	@PostMapping("/save/{fileName}")
	public String upload(@PathVariable("fileName") String fileName,HttpServletRequest request){
        try (Scanner scanner = new Scanner(request.getInputStream())){
        	scanner.useDelimiter("\\A");
            String body = scanner.hasNext() ? scanner.next() : "";
            return fileService.save(body, fileName);
        }catch (Exception e) {
			throw new RuntimeException("保存文件失败！！！");
		}
	}
	
}
