package com.video.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.video.model.AjaxResponse;
import com.video.model.Video;
import com.video.service.IVideoService;
import com.video.util.Remarks;

@Controller
@RequestMapping("/videos")
public class VideoController extends BaseController {

	@Autowired
	private IVideoService videoService;

	@GetMapping("/download")
	@ResponseBody
	@Remarks("下载文件")
	public AjaxResponse download(HttpServletResponse response, String videoId, String userId) {

		AjaxResponse respons = new AjaxResponse();
		videoService.download(response, videoId, userId);
		return respons;
	}

	@PostMapping("")
	@ResponseBody
	@Remarks("上传文件")
	public AjaxResponse upload(Video video, String pid) {

		AjaxResponse response = new AjaxResponse();
		return response;
	}

	@GetMapping("/show")
	@ResponseBody
	@Remarks("显示视频资源")
	public AjaxResponse show(HttpServletResponse response, String videoId, String userId) {

		AjaxResponse respons = new AjaxResponse();
		videoService.show(response, videoId, userId);
		return respons;
	}
}
