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
	public Position up() {
		return new Position(x, Y.of(y.value-1));
	}
	public Position right() {
		return new Position(X.of(x.value+1), y);
	}
	public Position left() {
		return new Position(X.of(x.value-1), y);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Position position = (Position)obj;
		return this.is(position);
	}
	
	public String toString() {
		return "X: " + x.value + ", Y: " + y.value;
	}
	
}
