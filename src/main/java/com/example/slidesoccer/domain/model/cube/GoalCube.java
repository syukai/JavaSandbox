package com.example.slidesoccer.domain.model.cube;

public class GoalCube {
	int x;
	int y;
	
	public GoalCube(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean isPosition(int x, int y) {
		return this.x == x && this.y == y;
		
	}

}
