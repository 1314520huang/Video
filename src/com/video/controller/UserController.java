package com.video.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.video.model.AjaxResponse;
import com.video.model.User;
import com.video.service.IUserService;
import com.video.util.Remarks;
import com.video.util.StringUtil;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;

	@PostMapping("/login")
	@ResponseBody
	@Remarks("登录操作")
	public AjaxResponse login(HttpServletRequest request, String loginName, String password) {

		AjaxResponse response = userService.login(loginName, password, request);
		return response;
	}

	@RequestMapping("/logout")
	@ResponseBody
	@Remarks("登出操作")
	public AjaxResponse logout(HttpServletRequest request) {

		AjaxResponse response = new AjaxResponse();
		request.getSession().removeAttribute("usr");
		response.setMessage("登出成功");
		return response;
	}

	@PostMapping("")
	@ResponseBody
	@Remarks("注册操作")
	public AjaxResponse register(User user) {

		userService.add(user);
		return new AjaxResponse();
	}

	@GetMapping("/{userId}")
	@ResponseBody
	@Remarks("个人信息")
	public AjaxResponse info(@PathVariable("userId") String userId) {

		AjaxResponse response = new AjaxResponse();
		User user = userService.info(userId);
		response.setData(user);
		return response;
	}

	@PatchMapping("")
	@ResponseBody
	@Remarks("更新用户信息")
	public AjaxResponse update(User user) {

		userService.update(user);
		return new AjaxResponse();
	}

	@GetMapping("")
	@ResponseBody
	@Remarks("用户列表")
	public AjaxResponse list(String pageNum, String pageIndex) {

		AjaxResponse response = new AjaxResponse();
		int index = 1, num = 12;
		if (StringUtil.isNotNull(pageIndex))
			index = Integer.parseInt(pageIndex);
		if (StringUtil.isNotNull(pageNum))
			num = Integer.parseInt(pageNum);
		List<User> users = userService.list(index, num);
		response.setData(users);
		return response;
	}
}
