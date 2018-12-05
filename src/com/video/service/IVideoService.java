package com.video.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.video.model.Video;

public interface IVideoService {

	void upload(HttpServletRequest request, Video video);
	
	void download(HttpServletResponse response, String videoId, String userId);
	
	void delete(String videoId);
	
	void update(Video video);
	
	String show(HttpServletRequest request, HttpServletResponse response, String videoId, String userId);
	
	List<Video> list(int pageIndex, int pageSize);
	
	List<Video> love(int pageIndex, int pageSize);
	
	List<Video> search(Video video);
}
