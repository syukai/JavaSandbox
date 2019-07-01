package com.example.slidesoccer.domain.model.panel;

import java.util.List;

import com.example.slidesoccer.domain.model.move.Move;
import com.example.slidesoccer.domain.model.space.Space;
import com.example.slidesoccer.domain.model.space.Spaces;
import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

/**
 * パネル
 * @author hirayamadaisuke
 *
 */
public abstract class Panel {
	Position position;
	public Panel(Position position){
		this.position = position;
	}
	
	public boolean isPosition(Position position) {
		return this.position.is(position);
	}
	
	public abstract List<Position> positions();

	public boolean isMatch(Panel source) {
		if(!this.getClass().getName().equals(source.getClass().getName())) return false;
		
		if(!isPosition(source.position)) return false;
		
		return true;
	}
	
	public abstract List<Move> getCanMove(Spaces spaces);
	
	public abstract Panel getMoved(Position position);

	public Spaces getMovedSpaces(Spaces spaces, Position target) {
		Spaces movedSpaces = new Spaces(
				new Space(new Position(X.of(1), Y.of(2)))
				, new Space(new Position(X.of(2), Y.of(3)))
				);
		return movedSpaces;
	}
}
