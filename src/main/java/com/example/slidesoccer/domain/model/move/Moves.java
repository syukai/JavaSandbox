package com.example.slidesoccer.domain.model.move;

import java.util.List;

import com.example.slidesoccer.domain.model.panel.Panel;

public class Moves {
	
	List<Move> list;
	
	public Moves(List<Move> moves) {
		list = moves;
	}

	public int size() {
		return list.size();
	}
	
	public boolean contains(Move move) {
		for(Move m:list) {
			if(m.equals(move)) return true;
		}
		return false;
	}

	public boolean containsSource(Panel source) {
		for(Move m:list) {
			if(m.source.isMatch(source)) return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Move m : list) {
			sb.append(m.toString());
		}
		return sb.toString();
	}

}
