package com.video.service;

import java.util.List;

import com.video.model.AjaxResponse;
import com.video.model.User;

public interface IUserService {

	void add(User user);
	
	void delete(String userId);
	
	void update(User user);
	
	User info(String userId);
	
	User login(String loginName, String password, AjaxResponse response);
	
	boolean isExists(String loginName);
	
	List<User> list(int pageIndex, int pageSize);
}
