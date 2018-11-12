package com.video.service.impl;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.video.dao.FileMapper;
import com.video.exception.AIException;
import com.video.service.IFileService;
import com.video.util.StringUtil;

@Transactional
@Service
public class FileService implements IFileService {

	@Autowired
	private FileMapper fileMapper;

	@Override
	public String upload(HttpServletRequest request, MultipartFile file) {

		if (file == null)
			throw new AIException("文件为空，请重新选择");
		String id = StringUtil.getUUID();
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.indexOf('.'));
		String url = request.getSession().getServletContext().getRealPath("/") + "/upload/" + id + suffix;
		try {
			file.transferTo(new File(url));
			com.video.model.File file2 = new com.video.model.File();
			file2.setId(id);
			file2.setUrl(url);
			fileMapper.insert(file2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public String show(HttpServletResponse response, String fileId) {

		com.video.model.File file = fileMapper.selectByPrimaryKey(fileId);
		return file.getUrl();
	}
}
