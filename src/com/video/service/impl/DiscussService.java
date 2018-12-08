package com.video.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.video.dao.DiscussMapper;
import com.video.exception.AIException;
import com.video.model.Discuss;
import com.video.model.DiscussExample;
import com.video.model.User;
import com.video.service.IDiscussService;
import com.video.util.DateUtil;
import com.video.util.StaticVals;
import com.video.util.StringUtil;

@Service
@Transactional
public class DiscussService implements IDiscussService {

	@Autowired
	private DiscussMapper discussMapper;

	@Override
	public List<Discuss> list(String videoId) {

		DiscussExample example = new DiscussExample();
		example.createCriteria().andVideoIdEqualTo(videoId).andStateEqualTo("1");
		example.setOrderByClause(" discuss_time desc ");
		return discussMapper.selectByExample(example);
	}

	@Override
	public List<Discuss> list() {
		
		DiscussExample example = new DiscussExample();
		example.createCriteria().andStateEqualTo("1");
		example.setOrderByClause(" discuss_time desc ");
		return discussMapper.selectByExample(example);
	}
	
	@Override
	public void add(HttpServletRequest request, Discuss discuss) {

		User user = (User) request.getSession().getAttribute("usr");
		if (user == null)
			throw new AIException(StaticVals.MSG);
		discuss.setUserId(user.getId());
		discuss.setUserName(user.getRealName());
		discuss.setState("1");
		discuss.setId(StringUtil.getUUID());
		discuss.setDiscussTime(DateUtil.getNowTime());
		discussMapper.insert(discuss);
	}

	@Override
	public void delete(HttpServletRequest request, String videoId) {

		User user = (User) request.getSession().getAttribute("usr");
		if (user == null)
			throw new AIException(StaticVals.MSG);
		Discuss discuss = info(videoId);
		discuss.setState("0");
		discussMapper.updateByPrimaryKeySelective(discuss);
	}

	private Discuss info(String videoId) {

		return discussMapper.selectByPrimaryKey(videoId);
	}
}
