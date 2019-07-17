package com.example.slidesoccer.domain.model.panel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.slidesoccer.domain.model.move.Move;
import com.example.slidesoccer.domain.model.space.Space;
import com.example.slidesoccer.domain.model.space.Spaces;
import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

class WidePanelTest {

	@Test
	void moveUp() {
		WidePanel wide = new WidePanel(new Position(X.of(2), Y.of(2)));

		Space space1_1 = new Space(new Position(X.of(1), Y.of(2)));
		Space space2_2 = new Space(new Position(X.of(1), Y.of(3)));
		Spaces spaces = new Spaces(space1_1, space2_2);
		
		List<Move> moves = wide.getCanMove(spaces);
		
		assertEquals(1, moves.size());
		assertEquals(new Move(wide, new Position(X.of(1), Y.of(2)))
				, moves.get(0));
	}
	@Test
	void moveRight() {
		WidePanel wide = new WidePanel(new Position(X.of(2), Y.of(2)));

		Space space1_1 = new Space(new Position(X.of(4), Y.of(2)));
		Space space2_2 = new Space(new Position(X.of(4), Y.of(5)));
		Spaces spaces = new Spaces(space1_1, space2_2);
		
		List<Move> moves = wide.getCanMove(spaces);
		
		assertEquals(1, moves.size());
		assertEquals(new Move(wide, new Position(X.of(3), Y.of(2)))
				, moves.get(0));
	}
	@Test
	void moveLeft() {
		WidePanel wide = new WidePanel(new Position(X.of(2), Y.of(2)));

		Space space1_1 = new Space(new Position(X.of(1), Y.of(2)));
		Space space2_2 = new Space(new Position(X.of(4), Y.of(5)));
		Spaces spaces = new Spaces(space1_1, space2_2);
		
		List<Move> moves = wide.getCanMove(spaces);
		
		assertEquals(1, moves.size());
		assertEquals(new Move(wide, new Position(X.of(1), Y.of(2)))
				, moves.get(0));
	}
	@Test
	void moveDown() {
		WidePanel wide = new WidePanel(new Position(X.of(2), Y.of(2)));

		Space space1_1 = new Space(new Position(X.of(2), Y.of(3)));
		Space space2_2 = new Space(new Position(X.of(3), Y.of(3)));
		Spaces spaces = new Spaces(space1_1, space2_2);
		
		List<Move> moves = wide.getCanMove(spaces);
		
		assertEquals(1, moves.size());
		assertEquals(new Move(wide, new Position(X.of(2), Y.of(3)))
				, moves.get(0));
	}
}
