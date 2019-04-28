package com.example.slidesoccer.domain.model.panel;

import java.util.List;

import com.example.slidesoccer.domain.type.position.Position;

public class SmallPanel extends Panel {

	public SmallPanel(Position position) {
		super(position);
	}

	@Override
	public List<Position> positions() {
		return List.of(position);
	}

}
