package com.example.slidesoccer.domain.model.panel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.slidesoccer.domain.model.move.Move;
import com.example.slidesoccer.domain.model.space.Space;
import com.example.slidesoccer.domain.model.space.Spaces;
import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

class GeneralPanelsTest {

	@Test
	void equals() {
		List<Panel> list = new ArrayList<>();
		
		List<SmallPanel> smallList = List.of(
				new SmallPanel(new Position(X.of(1), Y.of(1))),
				new SmallPanel(new Position(X.of(2), Y.of(1)))
				);
		List<TallPanel> tallList = List.of(
				new TallPanel(new Position(X.of(3), Y.of(1))),
				new TallPanel(new Position(X.of(4), Y.of(1)))
				);
		List<WidePanel> wideList = List.of(
				new WidePanel(new Position(X.of(1), Y.of(2))),
				new WidePanel(new Position(X.of(1), Y.of(3)))
				);
		GoalPanel goal = new GoalPanel(new Position(X.of(1), Y.of(4)));
		
		var panels1 = new GeneralPanels(smallList, tallList, wideList, goal);
		var panels2 = new GeneralPanels(smallList, tallList, wideList, goal);
		assertTrue(panels1.equals(panels2));
	}
	
	@Test
	void isGoal() {
		List<Panel> list = new ArrayList<>();
		
		List<SmallPanel> smallList = List.of(
				new SmallPanel(new Position(X.of(1), Y.of(1))),
				new SmallPanel(new Position(X.of(2), Y.of(1))),
				new SmallPanel(new Position(X.of(1), Y.of(2))),
				new SmallPanel(new Position(X.of(2), Y.of(2))),
				new SmallPanel(new Position(X.of(1), Y.of(3))),
				new SmallPanel(new Position(X.of(2), Y.of(3))),
				new SmallPanel(new Position(X.of(3), Y.of(3))),
				new SmallPanel(new Position(X.of(4), Y.of(3)))
				);
		List<TallPanel> tallList = List.of(
				new TallPanel(new Position(X.of(3), Y.of(1))),
				new TallPanel(new Position(X.of(4), Y.of(1))),
				new TallPanel(new Position(X.of(4), Y.of(4)))
				);
		List<WidePanel> wideList = List.of(
				new WidePanel(new Position(X.of(3), Y.of(3)))
				);
		GoalPanel goal = new GoalPanel(new Position(X.of(1), Y.of(4)));
		
		var panels1 = new GeneralPanels(smallList, tallList, wideList, goal);
//		var panels2 = new GeneralPanels(smallList, tallList, wideList, goal);
		assertFalse(panels1.isGoal());
		
		Move move = new Move(goal, new Position(X.of(2), Y.of(4)));
		Space space1_1 = new Space(new Position(X.of(3), Y.of(4)));
		Space space2_2 = new Space(new Position(X.of(3), Y.of(5)));
		Spaces spaces = new Spaces(space1_1, space2_2);
		
		panels1.move(move, spaces);
		assertTrue(panels1.isGoal());
	}

}
