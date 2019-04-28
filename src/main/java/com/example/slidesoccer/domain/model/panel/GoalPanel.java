package com.example.slidesoccer.domain.model.panel;

import java.util.List;

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
		super(position);
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

}
