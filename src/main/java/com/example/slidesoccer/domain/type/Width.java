package com.example.slidesoccer.domain.type;

/**
 * 幅
 * @author hirayamadaisuke
 *
 */
public class Width {
	int value;
	Width(int value) {
		this.value = value;
	}
	public static Width of(int value) {
		return new Width(value);
	}
}
