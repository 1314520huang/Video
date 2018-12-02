package com.video.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.video.model.NoteBoard;

public interface INoteBoardService {

	void add(HttpServletRequest request, NoteBoard board);
	
	void delete(String noteId);
	
	List<NoteBoard> list();
}
