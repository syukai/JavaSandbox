package com.example.slidesoccer.domain.model.field;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.slidesoccer.domain.model.move.Move;
import com.example.slidesoccer.domain.model.panel.SmallPanel;
import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

class FieldHistoryTest {
	FieldBuilder builder;
	@BeforeEach
	void beforeEach() {
		// SSTT
		//   TT
		// GGSS
		// GGWW
		// SSWW
		builder = Field.builder()
				.small(X.of(1), Y.of(1))
				.small(X.of(2), Y.of(1))
				.tall(X.of(3), Y.of(1))
				.tall(X.of(4), Y.of(1))
				.goal(X.of(1), Y.of(3))
				.small(X.of(3), Y.of(3))
				.small(X.of(4), Y.of(3))
				.wide(X.of(3), Y.of(4))
				.small(X.of(1), Y.of(5))
				.small(X.of(2), Y.of(5))
				.wide(X.of(3), Y.of(5));
	}

	@Test
	@DisplayName("UndoしてHistoryからcanMoveを取り出し")
	void test() {
		Field field = new Field(builder);
		FieldHistory fh = field.createHistory();
		ArrayList<FieldHistory> fhList = new ArrayList<>();
		fhList.add(fh);
		
		//  STT
		// S TT
		// GGSS
		// GGWW
		// SSWW
		Move move = new Move(new SmallPanel(new Position(X.of(1), Y.of(1)))
				, new Position(X.of(1), Y.of(2)));
		field.move(move);
		assertFalse(fh.isMatch(field));
		
		// UndoしたらHistoryと一致する
		field.undo();
		assertTrue(fh.isMatch(field));
	}
}
