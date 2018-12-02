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
import com.video.model.NoteBoard;
import com.video.service.INoteBoardService;
import com.video.util.Remarks;

@Controller
@RequestMapping("/boards")
public class NoteBoardController extends BaseController {

	@Autowired
	private INoteBoardService noteBoardService;

	@PostMapping("")
	@ResponseBody
	@Remarks("添加新的留言记录")
	public AjaxResponse add(HttpServletRequest request, NoteBoard noteBoard) {

		AjaxResponse response = new AjaxResponse();
		noteBoardService.add(request, noteBoard);
		return response;
	}

	@PatchMapping("")
	@ResponseBody
	@Remarks("删除指定的记录")
	public AjaxResponse delete(String noteId) {

		AjaxResponse response = new AjaxResponse();
		noteBoardService.delete(noteId);
		return response;
	}

	@GetMapping("")
	@ResponseBody
	@Remarks("获取留言列表")
	public AjaxResponse list() {

		AjaxResponse response = new AjaxResponse();
		List<NoteBoard> boards = noteBoardService.list();
		response.setData(boards);
		return response;
	}
}
