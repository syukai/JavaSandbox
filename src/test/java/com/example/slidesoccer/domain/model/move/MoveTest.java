package com.example.slidesoccer.domain.model.move;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.slidesoccer.domain.model.panel.SmallPanel;
import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

class MoveTest {

	@Test
	@DisplayName("Reverseを取得する")
	void testGetReverse() {
		Position initPos = new Position(X.of(1), Y.of(2));
		SmallPanel small = new SmallPanel(initPos);
		Move move = new Move(small, new Position(X.of(2), Y.of(2)));
		
		Move reverse = move.getReverse();
		
		assertTrue(reverse.source.isPosition(new Position(X.of(2), Y.of(2))));
	}

}
