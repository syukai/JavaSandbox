package com.example.slidesoccer.domain.type.position;

public class X {
	int value;
	
	X(int x) {
		this.value = x;
	}
	public static X of(int x) {
		return new X(x);
	}
	
	boolean equals(X x) {
		return this.value == x.value;
	}
}
