package com.video.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.video.dao.VideoMapper;
import com.video.exception.AIException;
import com.video.model.Page;
import com.video.model.Video;
import com.video.model.VideoExample;
import com.video.service.IFileService;
import com.video.service.IVideoService;
import com.video.util.StringUtil;

@Transactional
@Service
public class VideoService implements IVideoService {

	@Autowired
	private VideoMapper videoMapper;

	@Autowired
	private IFileService fileService;

	@Override
	public void upload(Video video, String pid) {

		video.setPid(pid);
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
	public void show(HttpServletResponse response, String videoId, String userId) {

		if (!StringUtil.isNotNull(userId))
			throw new AIException("游客无法观看，请登录之后再播放");
		fileService.show(response, videoId);
	}

	@Override
	public List<Video> list(int pageIndex, int pageSize) {

		Page page = new Page(pageSize, pageIndex);
		VideoExample example = new VideoExample();
		example.createCriteria().andStateEqualTo("1");
		example.setOrderByClause(" create_time desc ");
//		return videoMapper.selectByExampleWithRowbounds(example, page);
		return null;
	}
	
	@Override
	public List<Video> love(int pageIndex, int pageSize) {

		Page page = new Page(pageSize, pageIndex);
		VideoExample example = new VideoExample();
		example.createCriteria().andStateEqualTo("1");
		example.setOrderByClause(" create_time desc ");
//		return videoMapper.selectByExampleWithRowbounds(example, page);
		return null;
	}

	@Override
	public List<Video> search(Video video) {
		// TODO Auto-generated method stub
		return null;
	}
}
