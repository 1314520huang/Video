package com.video.service;

import java.util.List;

import com.video.model.NoteBoard;

public interface INoteBoardService {

	void add(NoteBoard board);
	
	void delete(String noteId);
	
	List<NoteBoard> list();
}
