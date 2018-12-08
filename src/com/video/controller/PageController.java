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
	@Remarks("��ת����Ӧ�ĸ��˽���")
	public String info(HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("usr");
		request.setAttribute("user", user);
		// if(user != null) System.out.println(user.toString());
		// �жϵ�ǰ�û��Ƿ��Ѿ���¼�ɹ�
		return user == null ? "login" : "self";
	}

	@RequestMapping("/board")
	@Remarks("��ת����Ӧ�����Խ���")
	public String board(HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("usr");
		request.setAttribute("isLogin", user == null ? false : true);
		return "board";
	}

	@RequestMapping("/star")
	@Remarks("��ת����Ӧ�����ֽ���")
	public String star() {

		return "star";
	}

	@RequestMapping("/admin/{page}")
	@Remarks("��ת����Ӧ�Ĺ������")
	public String admin(HttpServletRequest request, @PathVariable("page") String page) {

		User user = (User) request.getSession().getAttribute("usr");
		if (user == null)
			throw new AIException(StaticVals.MSG);
		// �жϵ�ǰ�û��Ƿ���й���ԱȨ��
		return StaticVals.AdminLevel.equals(user.getLevel()) ? "admin/" + page : "error";
	}
	
	@GetMapping("/show/{videoId}")
	@Remarks("��ʾ��Ƶ��Դ")
	public String show(HttpServletRequest request, @PathVariable("videoId") String videoId) {

		User user = (User) request.getSession().getAttribute("usr");
		if (user == null)
			throw new AIException(StaticVals.MSG);
		request.setAttribute("videoId", videoId);
		return "show";
	}
	
	@GetMapping("/show1/{videoId}")
	@Remarks("��ʾ��Ƶ��Դ")
	public String show1(HttpServletRequest request, @PathVariable("videoId") String videoId) {

		User user = (User) request.getSession().getAttribute("usr");
		if (user == null)
			throw new AIException(StaticVals.MSG);
		request.setAttribute("videoId", videoId);
		return "admin/info";
	}

	@RequestMapping("")
	@Remarks("Ĭ����ҳ")
	public String index() {

		return "index";
	}
}
