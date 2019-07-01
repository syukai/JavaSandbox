package com.example.slidesoccer.domain.model.panel;

import java.util.ArrayList;
import java.util.List;

import com.example.slidesoccer.domain.model.move.Move;
import com.example.slidesoccer.domain.model.space.Spaces;
import com.example.slidesoccer.domain.type.position.Position;

public class WidePanel extends Panel {

	public WidePanel(Position position) {
		super(position);
	}

	@Override
	public List<Position> positions() {
		return List.of(position, position.right());
	}

	@Override
	public List<Move> getCanMove(Spaces spaces) {
		ArrayList<Move> moves = new ArrayList<>();
		if(spaces.hasWideUp(position)) {
			moves.add(new Move(this, position.up()));
		}
		if(spaces.hasWideDown(position)) {
			moves.add(new Move(this, position.down()));
		}
		if(spaces.hasRight(position)) {
			moves.add(new Move(this, position.right()));
		}
		if(spaces.hasLeft(position)) {
			moves.add(new Move(this, position.left()));
		}
		return moves;
	}

	@Override
	public Panel getMoved(Position position) {
		return new WidePanel(position);
	}

}
