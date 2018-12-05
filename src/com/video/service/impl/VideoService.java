package com.video.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.video.dao.VideoMapper;
import com.video.exception.AIException;
import com.video.model.User;
import com.video.model.Video;
import com.video.model.VideoExample;
import com.video.service.IFileService;
import com.video.service.IVideoService;
import com.video.util.DateUtil;
import com.video.util.StaticVals;
import com.video.util.StringUtil;

@Transactional
@Service
public class VideoService implements IVideoService {

	@Autowired
	private VideoMapper videoMapper;

	@Autowired
	private IFileService fileService;

	@Override
	public void upload(HttpServletRequest request, Video video) {

		User user = (User) request.getSession().getAttribute("usr");
		video.setId(StringUtil.getUUID());
		video.setUploadTime(DateUtil.getNowDate());
		video.setUploadId(user.getId());
		video.setUploadName(user.getRealName());
		video.setState("1");
		videoMapper.insert(video);
	}

	@Override
	public void download(HttpServletResponse response, String videoId, String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String videoId) {

		Video video = info(videoId);
		video.setState("0");
		update(video);
	}

	private Video info(String videoId) {

		return videoMapper.selectByPrimaryKey(videoId);
	}

	@Override
	public void update(Video video) {

		videoMapper.updateByPrimaryKey(video);
	}

	@Override
	public String show(HttpServletRequest request, HttpServletResponse response, String videoId, String userId) {

		if (!StringUtil.isNotNull(userId))
			throw new AIException(StaticVals.MSG);
		return fileService.show(request, response, videoId);
	}

	@Override
	public List<Video> list(int pageIndex, int pageSize) {

		VideoExample example = new VideoExample();
		example.createCriteria().andStateEqualTo("1");
		example.setOrderByClause(" create_time desc ");
		int start = (pageIndex - 1) * pageSize;
		List<Video> list = videoMapper.selectByExample(example);
		int end = (pageIndex * pageSize < list.size()) ? (pageIndex * pageSize) : list.size();
		return list.subList(start, end);
	}

	@Override
	public List<Video> love(int pageIndex, int pageSize) {

		VideoExample example = new VideoExample();
		example.createCriteria().andStateEqualTo("1");
		example.setOrderByClause(" create_time desc ");
		int start = (pageIndex - 1) * pageSize;
		List<Video> list = videoMapper.selectByExample(example);
		int end = (pageIndex * pageSize < list.size()) ? (pageIndex * pageSize) : list.size();
		return list.subList(start, end);
	}

	@Override
	public List<Video> search(Video video) {

		return null;
	}
}
