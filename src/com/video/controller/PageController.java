package com.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.video.util.Remarks;

@Controller
@RequestMapping("/")
public class PageController extends BaseController {

	@RequestMapping("/{page}")
	@Remarks("��ת����Ӧ�Ľ���")
	public String turn(@PathVariable String page) {

		return page;
	}
	
	@RequestMapping("")
	@Remarks("Ĭ����ҳ")
	public String index() {
		
		return "index";
	}
}
