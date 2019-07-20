package com.example.slidesoccer.domain.model.field;

import com.example.slidesoccer.domain.model.move.Move;
import com.example.slidesoccer.domain.model.move.Moves;

public class FieldHistory {

	private int fieldHash;
	private Moves canMoves;
	private int count;
	
	FieldHistory(Field field, Moves canMoves,int count) {
		this.fieldHash = field.hashCode();
		this.canMoves = canMoves;
		this.count = count;
	}
	
	boolean isMatch(Field another) {
		return this.fieldHash == another.hashCode();
	}
	
	int getCount() {
		return count;
	}
	
	boolean hasMove() {
		return canMoves.hasMove();
	}
	
	Move retrieveMove() {
		Move move = canMoves.retrieve();
		return move;
	}
}
