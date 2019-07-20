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
	
//	@Test
//	@DisplayName("手詰まりになったら修了")
//	void test() {
//		assertFalse(testRunning(builder, 20, 6));
//	}

	@Test
	@DisplayName("同じ盤面になったら探索中止する")
	void testLoopField() {
		//   WW
		// WWWW
		// WWWW
		// GGTT
		// GGTT
		builder = Field.builder()
				.wide(X.of(3), Y.of(1))
				.wide(X.of(1), Y.of(2))
				.wide(X.of(3), Y.of(2))
				.wide(X.of(1), Y.of(3))
				.wide(X.of(3), Y.of(3))
				.goal(X.of(1), Y.of(4))
				.tall(X.of(3), Y.of(4))
				.tall(X.of(4), Y.of(4));
		System.out.println("同じ盤面になったら探索中止");
		assertFalse(testRunning(builder, 400, 0));
	}
	
	@Test
	@DisplayName("ゴールまで探索 1手")
	void testSearchGoal2() {
		// SSTT
		// SSTT
		// SSWW
		// GG T
		// GG T
		builder = Field.builder()
				.small(X.of(1), Y.of(1))
				.small(X.of(2), Y.of(1))
				.tall(X.of(3), Y.of(1))
				.tall(X.of(4), Y.of(1))
				.small(X.of(1), Y.of(2))
				.small(X.of(2), Y.of(2))
				.small(X.of(1), Y.of(3))
				.small(X.of(2), Y.of(3))
				.wide(X.of(3), Y.of(3))
				.goal(X.of(1), Y.of(4))
				.tall(X.of(4), Y.of(4));
		
		System.out.println("ゴールまで探索 1手");
		boolean result = testRunning(builder, 1000, 0);
		System.out.println("ゴールまで探索 1手 探索終了");
		if(!result) {
			fail("ゴールできず");
		}
	}

	public static boolean testRunning(FieldBuilder builder, int maxCnt, int expectMoveCnt) {
		FieldHistories fHistories = new FieldHistories();
		Field field = builder.create();
//		System.out.println(field.toString());
		
		// Historyに追加
		fHistories.add(field);
		
		// 動かせるところがあれば動かす、なければundoする
		int cnt = 0;
		while(true) {
			if(field.isGoal()) {
				System.out.println("ゴール！！！");
				field.getMovedHistories().forEach(m->System.out.println(m.toString()));
				return true;
			}
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
//						assertEquals(expectMoveCnt, fHistories.size());
					// 3回探索、3回Undoで終了
//						assertEquals(6, cnt);
					System.out.println("解なし");
					return false;
				}
//				System.out.println("undo");
			}
			cnt++;
			if(cnt>maxCnt) {
				fail("無限ループ");
			}
		}
	}

}
