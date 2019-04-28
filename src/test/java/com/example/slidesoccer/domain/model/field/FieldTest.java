package com.example.slidesoccer.domain.model.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.slidesoccer.domain.model.space.Space;
import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

class FieldTest {

	@Test
	@DisplayName("ゴールの位置が2-4ならゴール")
	void isGoal() {
		Field field = new Field();
		field.setSmallPanel(1, 1);
		field.setSmallPanel(2, 1);
		field.setGoalPanel(new Position(X.of(2), Y.of(4)));
		
		assertTrue(field.isGoal());
	}
	
	@Test
	@DisplayName("ゴールの位置が2-4でなければゴールじゃない")
	void isNotGoal() {
		Field field = new Field();
		
		field.setGoalPanel(new Position(X.of(2), Y.of(3)));
		assertFalse(field.isGoal());
	}
	
	@Test
	@DisplayName("スペースを２つ持つ")
	void hasTwoSpaces() {
		Field field = Field.builder()
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
			.wide(X.of(3), Y.of(5))
			.create();
		
		assertTrue(field.hasSpace(new Position(X.of(1), Y.of(2))));
		assertTrue(field.hasSpace(new Position(X.of(2), Y.of(2))));
		
	}
	
//	@Test
//	@DisplayName("可能な動作の一覧を取得する")
//	void getCanMoves() {
//		Field field = new Field();
//		
//		Moves moves = field.getCanMoves();
//	}

}
