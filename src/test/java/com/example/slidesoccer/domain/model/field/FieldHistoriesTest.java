package com.example.slidesoccer.domain.model.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.slidesoccer.domain.model.move.Move;
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
	void testCreateHisotry() {
		FieldHistories fHistories = new FieldHistories();
		Field field = builder.create();
		
		// まだ今のFieldはHistoriesに存在しない
		assertFalse(fHistories.contains(field));
		
		// Historyに追加
		fHistories.add(field);
		
		// 今含めたFieldがHistoriesに存在する
		assertTrue(fHistories.contains(field));
	}
	
	@Test
	@DisplayName("手詰まりになったら修了")
	void test() {
		FieldHistories fHistories = new FieldHistories();
		Field field = builder.create();
		
		// まだ今のFieldはHistoriesに存在しない
		assertFalse(fHistories.contains(field));
		
		// Historyに追加
		fHistories.add(field);
		
		// 動かせるところがあれば動かす、なければundoする
		int cnt = 0;
		while(true) {
			if(fHistories.hasMove(field)) {
				Move move = fHistories.retrieveMove(field);
				field.move(move);
				if(fHistories.contains(field)) {
					field.undo();
				} else {
					fHistories.add(field);
				}
				
			} else {
				
				if(!field.undo()) {
//					System.out.println("終了！！！");
					// 3回探索、3回Undoで終了
					assertEquals(6, cnt);
					return;
				}
			}
			cnt++;
			if(cnt>20) {
				fail("無限ループ");
			}
		}
	}

}
