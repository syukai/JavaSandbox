package com.example.slidesoccer.domain.model.space;

import com.example.slidesoccer.domain.type.position.Position;

public class Space {
	Position position;
	public Space(Position position) {
		this.position = position;
	}
	
	@Override
	public boolean equals(Object object) {
		Space space = (Space)object;
		return this.position.equals(space.position);
	}
	
	public String toString() {
		return position.toString();
	}
}
