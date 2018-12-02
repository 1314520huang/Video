package com.video.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.video.dao.NoteBoardMapper;
import com.video.exception.AIException;
import com.video.model.NoteBoard;
import com.video.model.NoteBoardExample;
import com.video.model.User;
import com.video.service.INoteBoardService;
import com.video.util.DateUtil;
import com.video.util.StringUtil;

@Service
@Transactional
public class NoteBoardService implements INoteBoardService {

	@Autowired
	private NoteBoardMapper noteBoardMapper;

	@Override
	public void add(HttpServletRequest request, NoteBoard board) {

		User user = (User) request.getSession().getAttribute("usr");
		if (user == null)
			throw new AIException("用户尚未登录，无法进行留言");
		board.setUserId(user.getId());
		board.setUserName(user.getRealName());
		board.setId(StringUtil.getUUID());
		board.setCreateTime(DateUtil.getNowTime());
		board.setState("1");
		noteBoardMapper.insert(board);
	}

	@Override
	public void delete(String noteId) {

		NoteBoard board = noteBoardMapper.selectByPrimaryKey(noteId);
		board.setState("0");
		noteBoardMapper.updateByPrimaryKey(board);
	}

	@Override
	public List<NoteBoard> list() {

		NoteBoardExample example = new NoteBoardExample();
		example.createCriteria().andStateEqualTo("1");
		example.setOrderByClause(" create_time desc ");
		List<NoteBoard> list = noteBoardMapper.selectByExample(example).subList(0, 10);
		return list;
	}
}
