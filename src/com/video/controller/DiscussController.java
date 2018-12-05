package com.video.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.video.model.AjaxResponse;
import com.video.model.Discuss;
import com.video.service.IDiscussService;
import com.video.util.Remarks;

@Controller
@RequestMapping("/discusses")
public class DiscussController extends BaseController {

	@Autowired
	private IDiscussService discussService;

	@PostMapping("")
	@ResponseBody
	@Remarks("�������")
	public AjaxResponse add(HttpServletRequest request, Discuss discuss) {

		AjaxResponse response = new AjaxResponse();
		discussService.add(request, discuss);
		return response;
	}

	@PatchMapping("")
	@ResponseBody
	@Remarks("ɾ������")
	public AjaxResponse delete(HttpServletRequest request, String discussId) {

		AjaxResponse response = new AjaxResponse();
		discussService.delete(request, discussId);
		return response;
	}

	@GetMapping("")
	@ResponseBody
	@Remarks("��Ӧ��Ӱ�µ������б�")
	public AjaxResponse list(String videoId) {

		AjaxResponse response = new AjaxResponse();
		List<Discuss> discusses = discussService.list(videoId);
		response.setData(discusses);
		return response;
	}
}
