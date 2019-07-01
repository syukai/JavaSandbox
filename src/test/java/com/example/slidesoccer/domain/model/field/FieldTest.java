package com.example.slidesoccer.domain.model.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.slidesoccer.domain.model.move.Move;
import com.example.slidesoccer.domain.model.move.Moves;
import com.example.slidesoccer.domain.model.panel.GoalPanel;
import com.example.slidesoccer.domain.model.panel.SmallPanel;
import com.example.slidesoccer.domain.model.panel.WidePanel;
import com.example.slidesoccer.domain.model.space.Space;
import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

class FieldTest {
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
	@DisplayName("ゴールの位置が2-4ならゴール")
	void isGoal() {
		Field field = builder
				.goal(X.of(2), Y.of(4))
				.create();
		
		assertTrue(field.isGoal());
	}
	
	@Test
	@DisplayName("ゴールの位置が2-4でなければゴールじゃない")
	void isNotGoal() {
		Field field = builder
				.goal(X.of(2), Y.of(3))
				.create();
		
		assertFalse(field.isGoal());
	}
	
	@Test
	@DisplayName("スペースを２つ持つ")
	void hasTwoSpaces() {
		Field field = builder.create();
		
		assertTrue(field.hasSpace(new Position(X.of(1), Y.of(2))));
		assertTrue(field.hasSpace(new Position(X.of(2), Y.of(2))));
		
	}
	
	@Test
	@DisplayName("可能な動作の一覧を取得する")
	void getCanMoves() {
		Field field = builder.create();
		
		Moves moves = field.getCanMoves();
		assertEquals(3, moves.size());
		assertTrue(moves.containsSource(new SmallPanel(new Position(X.of(1), Y.of(1)))));
		assertTrue(moves.containsSource(new SmallPanel(new Position(X.of(2), Y.of(1)))));
		assertTrue(moves.containsSource(new GoalPanel(new Position(X.of(1), Y.of(3)))));
		assertFalse(moves.containsSource(new WidePanel(new Position(X.of(1), Y.of(1)))));
	}
	
	@Test
	@DisplayName("SmallPanelをMove")
	void MoveSmallPanel() {
		Field field = builder.create();

		//  STT
		// S TT
		// GGSS
		// GGWW
		// SSWW
		Move move = new Move(new SmallPanel(new Position(X.of(1), Y.of(1)))
				, new Position(X.of(1), Y.of(2)));
		
		field.move(move);
		
		Moves moves2 = field.getCanMoves();
		
		System.out.println(field.toString());
		System.out.println();
		System.out.println(field.spaces.toString());
		System.out.println(moves2.toString());

		assertEquals(1, moves2.size());
		assertTrue(moves2.containsSource(new SmallPanel(new Position(X.of(2), Y.of(1)))));
		assertTrue(moves2.containsSource(new SmallPanel(new Position(X.of(1), Y.of(2)))));
		
		
	}

}
