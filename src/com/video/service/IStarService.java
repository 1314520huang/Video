package com.video.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.video.model.Star;

public interface IStarService {

	List<Star> list(String videoId);
	
	void add(HttpServletRequest request, Star star);
}
