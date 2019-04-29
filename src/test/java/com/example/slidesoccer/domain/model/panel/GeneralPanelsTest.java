package com.example.slidesoccer.domain.model.panel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

class GeneralPanelsTest {

	@Test
	void equals() {
		List<Panel> list = new ArrayList<>();
		list.add(new SmallPanel(new Position(X.of(1), Y.of(1))));
		list.add(new SmallPanel(new Position(X.of(2), Y.of(1))));
		list.add(new TallPanel(new Position(X.of(3), Y.of(1))));
		list.add(new TallPanel(new Position(X.of(4), Y.of(1))));
		list.add(new WidePanel(new Position(X.of(1), Y.of(2))));
		list.add(new WidePanel(new Position(X.of(1), Y.of(3))));
		
		var panels1 = new GeneralPanels(list);
		var panels2 = new GeneralPanels(list);
		assertTrue(panels1.equals(panels2));
	}

}
