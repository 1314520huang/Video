package com.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.video.dao.DiscussMapper;
import com.video.model.Discuss;
import com.video.model.DiscussExample;
import com.video.service.IDiscussService;
import com.video.util.DateUtil;
import com.video.util.StringUtil;

@Service
@Transactional
public class DiscussService implements IDiscussService {

	@Autowired
	private DiscussMapper discussMapper;

	@Override
	public List<Discuss> list(String videoId) {

		DiscussExample example = new DiscussExample();
		example.createCriteria().andVideoIdEqualTo(videoId).andStateEqualTo("0");
		example.setOrderByClause(" discuss_time desc ");
		return discussMapper.selectByExample(example);
	}

	@Override
	public void add(Discuss discuss) {

		discuss.setId(StringUtil.getUUID());
		discuss.setDiscussTime(DateUtil.getNowTime());
		discussMapper.insert(discuss);
	}

	@Override
	public void delete(String videoId) {

		Discuss discuss = info(videoId);
		discuss.setState("0");
		discussMapper.updateByPrimaryKey(discuss);
	}

	private Discuss info(String videoId) {

		return discussMapper.selectByPrimaryKey(videoId);
	}
}
