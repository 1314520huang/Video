package com.video.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.video.model.AjaxResponse;
import com.video.model.Star;
import com.video.service.IStarService;
import com.video.util.Remarks;

@Controller
@RequestMapping("/stars")
public class StarController extends BaseController {

	@Autowired
	private IStarService starService;

	@PostMapping("")
	@ResponseBody
	@Remarks("添加评分记录")
	public AjaxResponse add(HttpServletRequest request, Star star) {

		AjaxResponse response = new AjaxResponse();
		starService.add(request, star);
		return response;
	}

	@GetMapping("")
	@ResponseBody
	@Remarks("对应影片下的评分记录")
	public AjaxResponse list(String videoId) {

		AjaxResponse response = new AjaxResponse();
		List<Star> stars = starService.list(videoId);
		response.setData(stars);
		return response;
	}
}
