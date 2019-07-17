package com.example.slidesoccer.domain.model.panel;

import java.util.ArrayList;
import java.util.List;

import com.example.slidesoccer.domain.model.move.Move;
import com.example.slidesoccer.domain.model.space.Spaces;
import com.example.slidesoccer.domain.type.position.Position;

public class TallPanel extends Panel {

	public TallPanel(Position position) {
		super(PanelType.TallPanel, position);
	}

	@Override
	public List<Position> positions() {
		return List.of(position, position.down());
	}

	@Override
	public List<Move> getCanMove(Spaces spaces) {
		ArrayList<Move> moves = new ArrayList<>();
		if(spaces.hasUp(position)) {
			moves.add(new Move(this, position.up()));
		}
		if(spaces.hasDown(position.down())) {
			moves.add(new Move(this, position.down()));
		}
		if(spaces.hasTallRight(position)) {
			moves.add(new Move(this, position.right()));
		}
		if(spaces.hasTallLeft(position)) {
			moves.add(new Move(this, position.left()));
		}
		
		return moves;
	}

	@Override
	public Panel getMoved(Position position) {
		return new TallPanel(position);
	}

}
