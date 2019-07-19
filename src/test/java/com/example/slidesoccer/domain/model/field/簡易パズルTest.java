package com.example.slidesoccer.domain.model.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

class 簡易パズルTest {

	@Test
	@DisplayName("ゴールまで探索 3")
	void testSearchGoal3() {
		// SSST
		// T SS
		// T WW
		// GGSS
		// GGSS
		FieldBuilder builder = Field.builder()
				.small(X.of(1), Y.of(1))
				.small(X.of(2), Y.of(1))
				.small(X.of(3), Y.of(1))
				.tall(X.of(4), Y.of(1))
				.tall(X.of(1), Y.of(2))
				.small(X.of(2), Y.of(3))
				.small(X.of(2), Y.of(4))
				.wide(X.of(3), Y.of(3))
				.goal(X.of(1), Y.of(4))
				.small(X.of(3), Y.of(4))
				.small(X.of(4), Y.of(4))
				.small(X.of(3), Y.of(5))
				.small(X.of(4), Y.of(5));
		
		System.out.println("ゴールまで探索 3");
		boolean result = FieldHistoriesTest.testRunning(builder, 1500, 0);
		System.out.println("ゴールまで探索 3 探索終了");
		if(!result) {
			fail("ゴールできず");
		}
	}


}
