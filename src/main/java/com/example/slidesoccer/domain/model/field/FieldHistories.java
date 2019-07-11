package com.example.slidesoccer.domain.model.field;

import java.util.HashMap;
import java.util.Map;

public class FieldHistories {

	private Map<Integer, FieldHistory> histories = new HashMap<Integer, FieldHistory>();
	
	FieldHistories(){
		
	}

	public void add(Field field) {
		histories.put(Integer.valueOf(field.hashCode()), field.createHistory());
	}

	public boolean contains(Field field) {
		return histories.keySet().contains(field.hashCode());
	}
	
	
}
