package com.example.slidesoccer.domain.model.panel;

import java.util.List;

import com.example.slidesoccer.domain.type.position.Position;

/**
 * パネル
 * @author hirayamadaisuke
 *
 */
public abstract class Panel {
	Position position;
	public Panel(Position position){
		this.position = position;
	}
	
	public boolean isPosition(Position position) {
		return this.position.is(position);
	}
	
	public abstract List<Position> positions();
}
