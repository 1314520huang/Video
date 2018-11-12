package com.video.service;

import java.util.List;

import com.video.model.Star;

public interface IStarService {

	List<Star> list(String videoId);
	
	void add(Star star);
}
