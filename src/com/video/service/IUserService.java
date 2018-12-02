package com.video.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.video.model.AjaxResponse;
import com.video.model.User;

public interface IUserService {

	void add(User user);
	
	void delete(String userId);
	
	void update(User user);
	
	User info(String userId);
	
	AjaxResponse login(String loginName, String password, HttpServletRequest request);
	
	boolean isExists(String loginName);
	
	List<User> list(int pageIndex, int pageSize);
}
