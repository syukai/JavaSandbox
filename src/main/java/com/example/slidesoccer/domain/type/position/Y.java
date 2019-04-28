package com.example.slidesoccer.domain.type.position;

public class Y {
	int value;
	Y(int y){
		this.value = y;
	}
	
	public static Y of(int y) {
		return new Y(y);
	}
	
	boolean equals(Y y) {
		return this.value == y.value;
	}
}
