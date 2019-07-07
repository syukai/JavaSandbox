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
	
	/**
	 * 最後の1件を取り出して削除する
	 * @return
	 */
	public Move retrieve() {
		Move result = list.get(list.size()-1);
		list.remove(list.size()-1);
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Move m : list) {
			sb.append(m.toString());
		}
		return sb.toString();
	}

	public boolean hasMove() {
		return list.size() > 0;
	}

}
