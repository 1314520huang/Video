package com.video.service;

import java.util.List;

import com.video.model.Discuss;

public interface IDiscussService {

	List<Discuss> list(String videoId);

	void add(Discuss discuss);

	void delete(String videoId);
}
