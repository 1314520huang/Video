package com.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.video.util.Remarks;

@Controller
@RequestMapping("/")
public class PageController extends BaseController {

	@RequestMapping("/{page}")
	@Remarks("跳转到对应的界面")
	public String turn(@PathVariable String page) {

		return page;
	}
	
	@RequestMapping("")
	@Remarks("默认主页")
	public String index() {
		
		return "index";
	}
}
