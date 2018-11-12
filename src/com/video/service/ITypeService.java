package com.video.service;

import java.util.List;
import com.video.model.Type;

public interface ITypeService {

	void add(Type type);
	
	void delete(String typeId);
	
	List<Type> list();
}
