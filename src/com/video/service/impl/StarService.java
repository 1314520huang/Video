package com.video.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.video.dao.StarMapper;
import com.video.dao.VideoMapper;
import com.video.exception.AIException;
import com.video.model.Star;
import com.video.model.StarExample;
import com.video.model.User;
import com.video.model.Video;
import com.video.service.IStarService;
import com.video.util.DateUtil;
import com.video.util.StaticVals;
import com.video.util.StringUtil;

@Service
@Transactional
public class StarService implements IStarService {

	@Autowired
	private StarMapper starMapper;

	@Autowired
	private VideoMapper videoMapper;

	@Override
	public List<Star> list(String videoId) {

		StarExample example = new StarExample();
		example.createCriteria().andVideoIdEqualTo(videoId);
		example.setOrderByClause(" create_time desc ");
		return starMapper.selectByExample(example);
	}

	@Override
	public void add(HttpServletRequest request, Star star) {

		User user = (User)request.getSession().getAttribute("usr");
		if(user == null)	throw new AIException(StaticVals.MSG);
		star.setId(StringUtil.getUUID());
		star.setStarTime(DateUtil.getNowTime());
		star.setUserId(user.getId());
		star.setUserName(user.getRealName());
		String videoId = star.getVideoId();
		Video video = videoMapper.selectByPrimaryKey(videoId);
		video.setStarNum(video.getStarNum() + 1);
		video.setStarSum(video.getStarSum() + star.getStarNum());
		video.setAverage(video.getStarSum() * 1.0 / video.getStarNum());
		starMapper.insert(star);
		videoMapper.updateByPrimaryKey(video);
	}
}
