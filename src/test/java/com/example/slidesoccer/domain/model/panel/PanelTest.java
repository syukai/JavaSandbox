package com.example.slidesoccer.domain.model.panel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

class PanelTest {

	@Test
	@DisplayName("ハッシュ値テスト")
	void testHashCode() {
		SmallPanel small1 = new SmallPanel(new Position(X.of(3), Y.of(3)));
		SmallPanel small2 = new SmallPanel(new Position(X.of(3), Y.of(3)));
		
		assertEquals(small1.hashCode(), small2.hashCode());
	}

	@Test
	void testIsMatch() {
		SmallPanel small1 = new SmallPanel(new Position(X.of(2), Y.of(1)));
		SmallPanel small2 = new SmallPanel(new Position(X.of(1), Y.of(2)));
		
		assertFalse(small1.isMatch(small2));
	}
}
