package com.example.slidesoccer.domain.type;

/**
 * 高さ
 * @author hirayamadaisuke
 *
 */
public class Height {
	int value;
	Height(int value){
		this.value = value;
	}
	
	public int getNum() {
		return value;
	}
	
	public static Height of(int value) {
		return new Height(value);
	}
}
