package com.video.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.video.model.AjaxResponse;
import com.video.service.IFileService;

@Controller
@RequestMapping("/files")
public class FileController extends BaseController {

	@Autowired
	private IFileService fileService;

	@PostMapping("")
	@ResponseBody
	public AjaxResponse upload(HttpServletRequest request, MultipartFile file) {

		AjaxResponse response = new AjaxResponse();
		String fileId = fileService.upload(request, file);
		response.setData(fileId);
		return response;
	}

	@GetMapping("")
	@ResponseBody
	public AjaxResponse download(HttpServletRequest request, HttpServletResponse response, String fileId) {

		AjaxResponse respons = new AjaxResponse();
		String url = fileService.show(request, response, fileId);
		respons.setData(url);
		return respons;
	}
}
