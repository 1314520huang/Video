package com.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.video.dao.NoteBoardMapper;
import com.video.model.NoteBoard;
import com.video.model.NoteBoardExample;
import com.video.service.INoteBoardService;
import com.video.util.DateUtil;
import com.video.util.StringUtil;

@Service
@Transactional
public class NoteBoardService implements INoteBoardService {

	@Autowired
	private NoteBoardMapper noteBoardMapper;

	@Override
	public void add(NoteBoard board) {

		board.setId(StringUtil.getUUID());
		board.setCreateTime(DateUtil.getNowTime());
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
		return noteBoardMapper.selectByExample(example);
	}
}
