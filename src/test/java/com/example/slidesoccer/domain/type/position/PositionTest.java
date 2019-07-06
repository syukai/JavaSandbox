package com.example.slidesoccer.domain.type.position;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionTest {

	@Test
	void testIs() {
		Position source = new Position(X.of(2), Y.of(1));
		Position another = new Position(X.of(1), Y.of(2));
		
		assertFalse(source.is(another));
	}

}
