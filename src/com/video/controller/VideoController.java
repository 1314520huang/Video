package com.video.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.video.util.StringUtil;

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
	public AjaxResponse upload(HttpServletRequest request, Video video) {

		AjaxResponse response = new AjaxResponse();
		videoService.upload(request, video);
		return response;
	}

	@GetMapping("/show")
	@ResponseBody
	@Remarks("显示视频资源")
	public AjaxResponse show(HttpServletRequest request, HttpServletResponse response, String videoId, String userId) {

		AjaxResponse respons = new AjaxResponse();
		String url = videoService.show(request, response, videoId, userId);
		respons.setData(url);
		return respons;
	}

	@GetMapping("/star")
	@ResponseBody
	@Remarks("推荐榜")
	public AjaxResponse star(String pageIndex, String pageSize) {

		AjaxResponse response = new AjaxResponse();
		int value[] = StringUtil.getInt(pageIndex, pageSize);
		List<Video> videos = videoService.love(value[0], value[1]);
		response.setData(videos);
		return response;
	}

	@GetMapping("/")
	@ResponseBody
	@Remarks("列表页")
	public AjaxResponse list(String pageIndex, String pageSize) {

		AjaxResponse response = new AjaxResponse();
		int value[] = StringUtil.getInt(pageIndex, pageSize);
		List<Video> videos = videoService.list(value[0], value[1]);
		response.setData(videos);
		return response;
	}
}
