package com.example.slidesoccer.domain.type;

/**
 * 高さ
 * @author hirayamadaisuke
 *
 */
public class Hight {
	int value;
	Hight(int value){
		this.value = value;
	}
	
	public static Hight of(int value) {
		return new Hight(value);
	}
}
