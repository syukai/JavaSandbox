package com.example.slidesoccer.domain.model.field;

import java.util.HashMap;
import java.util.Map;

import com.example.slidesoccer.domain.model.move.Move;

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

	public boolean hasMove(Field field) {
		FieldHistory history = histories.get(field.hashCode());
		return history.hasMove();
	}

	public Move retrieveMove(Field field) {
		FieldHistory history = histories.get(field.hashCode());
		return history.retrieveMove();
	}
	
	
}
