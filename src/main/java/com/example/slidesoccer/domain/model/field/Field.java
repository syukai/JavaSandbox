package com.example.slidesoccer.domain.model.field;

import com.example.slidesoccer.domain.model.cube.GoalCube;
import com.example.slidesoccer.domain.type.Hight;
import com.example.slidesoccer.domain.type.Width;

public class Field {
	Hight height;
	Width width;
//	Cubes cubes;
	GoalCube goalCube;
	Field() {
		this.height = Hight.of(5);
		this.width = Width.of(4);
	}
	public void setSmallCube(int x, int y) {
//		cubes.add(new SmallCube(new Coordinate(1, 1)));
	}
	public void setGoalCube(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	public boolean isGoal() {
		this.goalCube = new GoalCube(2, 4);
		return goalCube.isPosition(2, 4);
	}

}
