package com.example.slidesoccer.domain.model.panel;

import java.util.ArrayList;
import java.util.List;

import com.example.slidesoccer.domain.model.move.Move;
import com.example.slidesoccer.domain.model.space.Spaces;
import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

/**
 * ゴールパネル
 * @author hirayamadaisuke
 *
 */
public class GoalPanel extends Panel {
	public GoalPanel(Position position){
		super(PanelType.GoalPanel, position);
	}

	public boolean isGoal() {
		return isPosition(new Position(X.of(2), Y.of(4)));
	}

	@Override
	public List<Position> positions() {
		return List.of(position
				, position.right()
				, position.down()
				, position.down().right());
	}

	@Override
	public List<Move> getCanMove(Spaces spaces) {
		ArrayList<Move> moves = new ArrayList<>();
		if(spaces.hasWideUp(position)) {
			moves.add(new Move(this, position.up()));
		}
		if(spaces.hasWideDown(position)) 
			moves.add(new Move(this, position.down()));
		if(spaces.hasTallRight(position)) 
			moves.add(new Move(this, position.right()));
		if(spaces.hasTallLeft(position)) 
			moves.add(new Move(this, position.left()));
		
		return moves;
	}

	@Override
	public Panel getMoved(Position position) {
		return new GoalPanel(position);
	}

}
