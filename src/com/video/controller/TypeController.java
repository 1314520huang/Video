package com.video.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.video.model.AjaxResponse;
import com.video.model.Type;
import com.video.service.ITypeService;
import com.video.util.Remarks;

@Controller
@RequestMapping("/types")
public class TypeController extends BaseController {

	@Autowired
	private ITypeService typeService;

	@PostMapping("")
	@ResponseBody
	@Remarks("添加新的分类")
	public AjaxResponse add(Type type) {

		AjaxResponse response = new AjaxResponse();
		typeService.add(type);
		return response;
	}

	@PatchMapping("")
	@ResponseBody
	@Remarks("删除指定分类")
	public AjaxResponse delete(String typeId) {

		AjaxResponse response = new AjaxResponse();
		typeService.delete(typeId);
		return response;
	}

	@GetMapping("")
	@ResponseBody
	@Remarks("获取所有类别")
	public AjaxResponse list() {

		AjaxResponse response = new AjaxResponse();
		List<Type> types = typeService.list();
		response.setData(types);
		return response;
	}
}
