package com.example.slidesoccer.domain.model.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

class レベル２Test {

	@Test
	@DisplayName("レベル２")
	void test() {
		// GGST
		// GGST
		// STSS
		// ST  
		// WWWW
		FieldBuilder builder = Field.builder()
				.goal(X.of(1), Y.of(1))
				.small(X.of(3), Y.of(1))
				.tall(X.of(4), Y.of(1))
				.small(X.of(3), Y.of(2))
				.small(X.of(1), Y.of(3))
				.tall(X.of(2), Y.of(3))
				.small(X.of(3), Y.of(3))
				.small(X.of(4), Y.of(3))
				.small(X.of(1), Y.of(4))
				.wide(X.of(1), Y.of(5))
				.wide(X.of(3), Y.of(5));
		
		System.out.println("レベル2");
		boolean result = FieldHistoriesTest.testRunning(builder, 100000, 0);
		if(!result) fail("ゴールできず");
	}

}
