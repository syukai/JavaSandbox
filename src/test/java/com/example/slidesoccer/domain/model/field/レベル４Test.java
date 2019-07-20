package com.example.slidesoccer.domain.model.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

class レベル４Test {


	@Test
	@DisplayName("レベル4")
	void test() {
		// TGGT
		// TGGT
		// WWWW
		// SSSS
		// S  S
		FieldBuilder builder = Field.builder()
				.tall(X.of(1), Y.of(1))
				.goal(X.of(2), Y.of(1))
				.tall(X.of(4), Y.of(1))
				.wide(X.of(1), Y.of(3))
				.wide(X.of(3), Y.of(3))
				.small(X.of(1), Y.of(4))
				.small(X.of(2), Y.of(4))
				.small(X.of(3), Y.of(4))
				.small(X.of(4), Y.of(4))
				.small(X.of(1), Y.of(5))
				.small(X.of(4), Y.of(5));
		
		System.out.println("レベル4");
		boolean result = FieldHistoriesTest.testRunning(builder, 100000, 0);
		if(!result) fail("ゴールできず");
	}

}
