package com.example.slidesoccer.domain.model.field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.slidesoccer.domain.model.move.Move;

public class FieldHistories {

	private Map<String, FieldHistory> histories = new HashMap<String, FieldHistory>();
	private List<Move> movedHistories = new ArrayList<Move>();
	
	FieldHistories(){
		
	}

	public void add(Field field) {
		histories.put(field.toString(), field.createHistory());
	}
	
	public void refleshHistory(Field field) {
		if(movedHistories.size()>field.getMovedHistories().size()) {
			this.movedHistories = field.getMovedHistories();
		} else {
			field.swapMovedHistoriesIfMoreFew(movedHistories.subList(0, movedHistories.size()));
		}
	}

	public boolean contains(Field field) {
		return histories.keySet().contains(field.toString());
	}

	public boolean hasMove(Field field) {
		FieldHistory history = histories.get(field.toString());
		return history.hasMove();
	}

	public Move retrieveMove(Field field) {
		FieldHistory history = histories.get(field.toString());
		return history.retrieveMove();
	}

	public int size() {
		return histories.size();
	}
	
	List<Move> getMovedHistories() {
		return movedHistories;
	}
	
	
}
