package com.video.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/delete")
	@ResponseBody
	@Remarks("删除资源")
	public AjaxResponse delete(HttpServletRequest request, String id) {

		AjaxResponse response = new AjaxResponse();
		videoService.delete(id);
		return response;
	}

	@GetMapping("/all")
	@ResponseBody
	@Remarks("列表页")
	public AjaxResponse list(String pageIndex, String pageSize) {

		AjaxResponse response = new AjaxResponse();
		int value[] = StringUtil.getInt(pageIndex, pageSize);
		List<Video> videos = videoService.list(value[0], value[1]);
		response.setData(videos);
		return response;
	}

	@GetMapping("/info/{videoId}")
	@ResponseBody
	@Remarks("列表页")
	public AjaxResponse info(@PathVariable("videoId") String videoId) {

		AjaxResponse response = new AjaxResponse();
		Video video = videoService.info(videoId);
		response.setData(video);
		return response;
	}

	@GetMapping("/search")
	@ResponseBody
	@Remarks("列表页")
	public AjaxResponse search(Video video) {

		AjaxResponse response = new AjaxResponse();
		List<Video> videos = videoService.search(video);
		response.setData(videos);
		return response;
	}
}
