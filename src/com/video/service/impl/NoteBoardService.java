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
import com.video.util.StaticVals;
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
			throw new AIException(StaticVals.MSG);
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
		noteBoardMapper.updateByPrimaryKeySelective(board);
	}

	@Override
	public List<NoteBoard> list() {

		NoteBoardExample example = new NoteBoardExample();
		example.createCriteria().andStateEqualTo("1");
		example.setOrderByClause(" create_time desc ");
		List<NoteBoard> list = noteBoardMapper.selectByExample(example);
		int end = list.size() > 10 ? 10 : list.size();
		return list.subList(0, end);
	}
}
