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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}
	
}
