package com.example.slidesoccer.domain.model.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

class FieldHistoriesTest {

	FieldBuilder builder;
	@BeforeEach
	void beforeEach() {
		//  TTT
		//  TTT
		// GGWW
		// GGWW
		// SSWW
		builder = Field.builder()
				.tall(X.of(2), Y.of(1))
				.tall(X.of(3), Y.of(1))
				.tall(X.of(4), Y.of(1))
				.goal(X.of(1), Y.of(3))
				.wide(X.of(3), Y.of(3))
				.wide(X.of(3), Y.of(4))
				.small(X.of(1), Y.of(5))
				.small(X.of(2), Y.of(5))
				.wide(X.of(3), Y.of(5));
	}
	
	@Test
	@DisplayName("AddでHistoryを追加。contanisでFieldを含むか確認")
	void test() {
		FieldHistories fHistories = new FieldHistories();
		Field field = builder.create();
		
		// まだ今のFieldはHistoriesに存在しない
		assertFalse(fHistories.contains(field));
		
		// Historyに追加
		fHistories.add(field);
		
		// 今含めたFieldがHistoriesに存在する
		assertTrue(fHistories.contains(field));
	}

}
