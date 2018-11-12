package com.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.video.dao.UserMapper;
import com.video.exception.AIException;
import com.video.model.AjaxResponse;
import com.video.model.Page;
import com.video.model.User;
import com.video.model.UserExample;
import com.video.service.IUserService;
import com.video.util.DateUtil;
import com.video.util.ErrorCode;
import com.video.util.PasswordUtil;
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
			user.setLeval("1");
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

		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public User info(String userId) {

		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public User login(String loginName, String password, AjaxResponse response) {

		UserExample example = new UserExample();
		example.createCriteria().andLoginNameEqualTo(loginName).andStateEqualTo("1");
		int cnt = userMapper.countByExample(example);
		User user = null;
		if (cnt != 0) {
			user = userMapper.selectByExample(example).get(0);
			if (PasswordUtil.decode(password, user.getSalt(), user.getPassword())) {
				return user;
			} else {
				response.setCode(ErrorCode.USER_INVALID_PASSWORD);
				response.setMessage("账号或密码不正确");
				return null;
			}
		} else {
			response.setCode(ErrorCode.USER_INVALID_USER);
			response.setMessage("当前用户尚未注册");
			return null;
		}
	}

	@Override
	public boolean isExists(String loginName) {

		UserExample example = new UserExample();
		example.createCriteria().andLoginNameEqualTo(loginName).andStateEqualTo("1");
		int cnt = userMapper.countByExample(example);
		return cnt != 0;
	}

	@Override
	public List<User> list(int pageIndex, int pageSize) {

		UserExample example = new UserExample();
		example.createCriteria().andStateEqualTo("1");
		example.setOrderByClause(" value asc ");
		Page page = new Page(pageSize, pageIndex);
//		return userMapper.selectByExampleWithRowbounds(example, page);
		return null;
	}
}
