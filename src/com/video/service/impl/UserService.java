package com.video.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.video.dao.UserMapper;
import com.video.exception.AIException;
import com.video.model.AjaxResponse;
import com.video.model.User;
import com.video.model.UserExample;
import com.video.service.IUserService;
import com.video.util.DateUtil;
import com.video.util.ErrorCode;
import com.video.util.PasswordUtil;
import com.video.util.StaticVals;
import com.video.util.StringUtil;

@Transactional
@Service
public class UserService implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void add(User user) {

		if (!isExists(user.getLoginName())) {
			user.setId(StringUtil.getUUID());
			user.setCreateTime(DateUtil.getNowTime());
			String salt = StringUtil.getSalt();
			user.setSalt(salt);
			user.setPassword(PasswordUtil.encode(user.getPassword(), salt));
			user.setState("1");
			user.setLevel("普通用户");
			user.setRealName(StringUtil.isNotNull(user.getRealName()) ? user.getRealName() : "匿名用户");
			userMapper.insert(user);
		} else {
			throw new AIException("当前用户名已存在");
		}
	}

	@Override
	public void delete(String userId) {

		User user = info(userId);
		user.setState("0");
		update(user);
	}

	@Override
	public void update(User user) {

		String password = user.getPassword();
		String salt = userMapper.selectByPrimaryKey(user.getId()).getSalt();
		if (StringUtil.isNotNull(password)) {
			password = PasswordUtil.encode(password, salt);
			user.setPassword(password);
		}
		if(!StringUtil.isNotNull(user.getImageUrl()))
			user.setImageUrl(StaticVals.IMG);
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User info(String userId) {

		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public AjaxResponse login(String loginName, String password, HttpServletRequest request) {

		AjaxResponse response = new AjaxResponse();
		UserExample example = new UserExample();
		example.createCriteria().andLoginNameEqualTo(loginName).andStateEqualTo("1");
		int cnt = userMapper.countByExample(example);
		User user = null;
		if (cnt != 0) {
			user = userMapper.selectByExample(example).get(0);
			if (PasswordUtil.decode(password, user.getSalt(), user.getPassword())) {
				response.setData(user);
				request.getSession().setAttribute("usr", user);
				return response;
			} else {
				response.setCode(ErrorCode.USER_INVALID_PASSWORD);
				throw new AIException("账号或密码不正确");
			}
		} else {
			response.setCode(ErrorCode.USER_INVALID_USER);
			throw new AIException("当前用户尚未注册");
		}
	}

	@Override
	public boolean isExists(String loginName) {

		UserExample example = new UserExample();
		example.createCriteria().andLoginNameEqualTo(loginName);
		int cnt = userMapper.countByExample(example);
		return cnt != 0;
	}

	@Override
	public List<User> list(int pageIndex, int pageSize) {

		UserExample example = new UserExample();
		example.createCriteria().andStateNotEqualTo("2").andLevelNotEqualTo("2");
		example.setOrderByClause(" create_time desc ");
		int start = (pageIndex - 1) * pageSize;
		List<User> list = userMapper.selectByExample(example);
		int end = (pageIndex * pageSize < list.size()) ? (pageIndex * pageSize) : list.size();
		return list.subList(start, end);
	}
}
