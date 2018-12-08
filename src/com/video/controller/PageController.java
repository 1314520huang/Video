package com.video.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.video.exception.AIException;
import com.video.model.User;
import com.video.util.Remarks;
import com.video.util.StaticVals;

@Controller
@RequestMapping("/")
public class PageController extends BaseController {

	@RequestMapping("/info")
	@Remarks("跳转到对应的个人界面")
	public String info(HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("usr");
		request.setAttribute("user", user);
		// if(user != null) System.out.println(user.toString());
		// 判断当前用户是否已经登录成功
		return user == null ? "login" : "self";
	}

	@RequestMapping("/board")
	@Remarks("跳转到对应的留言界面")
	public String board(HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("usr");
		request.setAttribute("isLogin", user == null ? false : true);
		return "board";
	}

	@RequestMapping("/star")
	@Remarks("跳转到对应的评分界面")
	public String star() {

		return "star";
	}

	@RequestMapping("/admin/{page}")
	@Remarks("跳转到对应的管理界面")
	public String admin(HttpServletRequest request, @PathVariable("page") String page) {

		User user = (User) request.getSession().getAttribute("usr");
		if (user == null)
			throw new AIException(StaticVals.MSG);
		// 判断当前用户是否具有管理员权限
		return StaticVals.AdminLevel.equals(user.getLevel()) ? "admin/" + page : "error";
	}
	
	@GetMapping("/show/{videoId}")
	@Remarks("显示视频资源")
	public String show(HttpServletRequest request, @PathVariable("videoId") String videoId) {

		User user = (User) request.getSession().getAttribute("usr");
		if (user == null)
			throw new AIException(StaticVals.MSG);
		request.setAttribute("videoId", videoId);
		return "show";
	}
	
	@GetMapping("/show1/{videoId}")
	@Remarks("显示视频资源")
	public String show1(HttpServletRequest request, @PathVariable("videoId") String videoId) {

		User user = (User) request.getSession().getAttribute("usr");
		if (user == null)
			throw new AIException(StaticVals.MSG);
		request.setAttribute("videoId", videoId);
		return "admin/info";
	}

	@RequestMapping("")
	@Remarks("默认主页")
	public String index() {

		return "index";
	}
}
