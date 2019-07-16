package com.example.slidesoccer.domain.model.field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.slidesoccer.domain.model.move.Move;

public class FieldHistories {

	private Map<Integer, FieldHistory> histories = new HashMap<Integer, FieldHistory>();
	private List<Move> movedHistories = new ArrayList<Move>();
	
	FieldHistories(){
		
	}

	public void add(Field field) {
		histories.put(Integer.valueOf(field.hashCode()), field.createHistory());
	}
	
	public void refleshHistory(Field field) {
		if(movedHistories.size()>field.getMovedHistories().size()) {
			this.movedHistories = field.getMovedHistories();
		} else {
			field.swapMovedHistoriesIfMoreFew(movedHistories.subList(0, movedHistories.size()));
		}
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

	public int size() {
		return histories.size();
	}
	
	List<Move> getMovedHistories() {
		return movedHistories;
	}
	
	
}
