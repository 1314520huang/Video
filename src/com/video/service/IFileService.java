package com.video.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

	String upload(HttpServletRequest request, MultipartFile file);

	String show(HttpServletRequest request, HttpServletResponse response, String fileId);
}
