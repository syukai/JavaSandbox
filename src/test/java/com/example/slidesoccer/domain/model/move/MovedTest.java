package com.example.slidesoccer.domain.model.move;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.slidesoccer.domain.model.panel.SmallPanel;
import com.example.slidesoccer.domain.model.space.Space;
import com.example.slidesoccer.domain.model.space.Spaces;
import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

class MovedTest {

	@Test
	void test() {
		Position base = new Position(X.of(1), Y.of(2));
		
		Move move = new Move(new SmallPanel(base)
				,base.down());
		
		Spaces spaces = new Spaces(
				new Space(base.down())
				,new Space(base.right()));
		
		Moved moved = move.move(spaces);
		
		assertTrue(moved.getMovedPanel().isPosition(base.down()));
		assertTrue(moved.getSpaces().contains(base));
	}

}
