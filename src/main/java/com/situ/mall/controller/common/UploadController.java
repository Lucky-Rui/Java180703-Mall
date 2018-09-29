package com.situ.mall.controller.common;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.situ.mall.common.ServerResponse;

@Controller
@RequestMapping(value = "/upload")
public class UploadController {

	@RequestMapping("/uploadImg")
	@ResponseBody
	public ServerResponse uploadImg(MultipartFile file) {
		// 为了防止文件重名（重名文件会覆盖丢失），所以生成一个不重复的随机的名字
		// cbbd8d0a-4930-4b0e-8d08-249ba2917b8a
		// 601b632f4d244071b5f4c581203605d8
		String name = UUID.randomUUID().toString().replace("-", "");
		// jpg、png
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		// 601b632f4d244071b5f4c581203605d8.png
		String fileName = name + "." + extension;
		// 把文件保存到D:\MallProject\productImg
		String filePath = "D:\\MallProject\\productImg\\" + fileName;
		try {
			file.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ServerResponse.createSuccess("上传成功", fileName);
	}
}
