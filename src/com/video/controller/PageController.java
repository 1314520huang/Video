package com.video.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.video.model.User;
import com.video.util.Remarks;
import com.video.util.StaticVals;

@Controller
@RequestMapping("/")
public class PageController extends BaseController {

	@RequestMapping("/info")
	@Remarks("��ת����Ӧ�ĸ��˽���")
	public String info(HttpServletRequest request) {

		User user = (User)request.getSession().getAttribute("usr");
		// �жϵ�ǰ�û��Ƿ��Ѿ���¼�ɹ�
		return user == null ? "login" : "self";
	}

	@RequestMapping("/board")
	@Remarks("��ת����Ӧ�����Խ���")
	public String board() {
		
		return "board";
	}

	@RequestMapping("/star")
	@Remarks("��ת����Ӧ�����ֽ���")
	public String star() {
		
		return "star";
	}

	@RequestMapping("/{page}")
	@Remarks("��ת����Ӧ�Ĺ������")
	public String admin(HttpServletRequest request, @PathVariable("page") String page) {
		
		User user = (User)request.getSession().getAttribute("usr");
		// �жϵ�ǰ�û��Ƿ���й���ԱȨ��
		return StaticVals.AdminLevel.equals(user.getLevel()) ? page : "error";
	}
	
	@RequestMapping("")
	@Remarks("Ĭ����ҳ")
	public String index() {
		
		return "index";
	}
}
