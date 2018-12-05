package com.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.video.dao.TypeMapper;
import com.video.model.Type;
import com.video.model.TypeExample;
import com.video.service.ITypeService;
import com.video.util.StringUtil;

@Service
@Transactional
public class TypeService implements ITypeService {

	@Autowired
	private TypeMapper typeMapper;

	@Override
	public void add(Type type) {

		type.setId(StringUtil.getUUID());
		typeMapper.insert(type);

	}

	@Override
	public void delete(String typeId) {

		Type type = info(typeId);
		type.setState("0");
		update(type);
	}

	private Type info(String typeId) {

		return typeMapper.selectByPrimaryKey(typeId);
	}

	private void update(Type type) {

		typeMapper.updateByPrimaryKeySelective(type);
	}

	@Override
	public List<Type> list() {

		TypeExample example = new TypeExample();
		example.createCriteria().andStateEqualTo("1");
		example.setOrderByClause(" value asc ");
		return typeMapper.selectByExample(example);
	}
}
