package com.video.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.video.model.AjaxResponse;

@Controller
@RequestMapping("/files")
public class FileController extends BaseController {

	@PostMapping("")
	@ResponseBody
	public AjaxResponse upload(MultipartFile file) {

		AjaxResponse response = new AjaxResponse();
		return response;
	}

	@GetMapping("")
	@ResponseBody
	public AjaxResponse download(HttpServletResponse response, String fileId, String userId) {

		AjaxResponse respons = new AjaxResponse();

		return respons;
	}
}
