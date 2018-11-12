package com.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.video.dao.StarMapper;
import com.video.model.Star;
import com.video.model.StarExample;
import com.video.service.IStarService;
import com.video.util.DateUtil;
import com.video.util.StringUtil;

@Service
@Transactional
public class StarService implements IStarService {

	@Autowired
	private StarMapper starMapper;

	@Override
	public List<Star> list(String videoId) {
		
		StarExample example = new StarExample();
		example.createCriteria().andVideoIdEqualTo(videoId);
		example.setOrderByClause(" create_time desc ");
		return starMapper.selectByExample(example);
	}

	@Override
	public void add(Star star) {

		star.setId(StringUtil.getUUID());
		star.setStarTime(DateUtil.getNowTime());
		starMapper.insert(star);
	}
}
