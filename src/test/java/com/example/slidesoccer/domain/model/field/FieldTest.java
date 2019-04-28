package com.example.slidesoccer.domain.model.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FieldTest {

	@Test
	@DisplayName("ゴールの位置が2-4ならゴール")
	void isGoal() {
		Field field = new Field();
//		field.setSmallCube(1, 1);
//		field.setSmallCube(2, 1);
		field.setGoalCube(2, 4);
		
		assertTrue(field.isGoal());
	}

}
