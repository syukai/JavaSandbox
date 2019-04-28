package com.example.slidesoccer.domain.type.position;

public class Position {
	X x;
	Y y;
	public Position(X x, Y y) {
		this.x = x;
		this.y = y;
	}
	public boolean is(Position position) {
		return this.x.equals(position.x) && this.y.equals(position.y);
	}
	public Position down() {
		return new Position(x, Y.of(y.value+1));
	}
	public Position right() {
		return new Position(X.of(x.value+1), y);
	}
	
	@Override
	public boolean equals(Object object) {
		Position position = (Position)object;
		return this.is(position);
	}
	
	public String toString() {
		return "X: " + x.value + ", Y: " + y.value;
	}
}
