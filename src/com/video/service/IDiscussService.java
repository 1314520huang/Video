package com.video.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.video.model.Discuss;

public interface IDiscussService {

	List<Discuss> list(String videoId);

	List<Discuss> list();

	void add(HttpServletRequest request, Discuss discuss);

	void delete(HttpServletRequest request, String videoId);
}
