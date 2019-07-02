package com.example.slidesoccer.domain.model.field;

import com.example.slidesoccer.domain.model.move.Move;
import com.example.slidesoccer.domain.model.move.Moves;
import com.example.slidesoccer.domain.model.panel.GeneralPanels;
import com.example.slidesoccer.domain.model.space.Spaces;
import com.example.slidesoccer.domain.type.Height;
import com.example.slidesoccer.domain.type.Width;
import com.example.slidesoccer.domain.type.position.Position;

public class Field {
	Height height;
	Width width;

	GeneralPanels panels;
	Spaces spaces;

	public Field(FieldBuilder builder) {
		this.height = builder.height;
		this.width = builder.width;
		
		panels = new GeneralPanels(
				builder.smallPanels
				, builder.tallPanels
				, builder.widePanels
				, builder.goalPanel);
		
		spaces = panels.findSpaces(height, width);
	}
	public boolean isGoal() {
		return panels.isGoal();
	}
	public static FieldBuilder builder() {
		return new FieldBuilder(Height.of(5), Width.of(4));
	}
	public boolean hasSpace(Position position) {
		return this.spaces.contains(position);
	}
	public Moves getCanMoves() {
		return new Moves(panels.getCanMoves(spaces));
		
	}
	
	public void move(Move move) {
		panels.move(move, spaces);
		// TODO:findSpacesはコストが高いのでmoveのときにspacesを再生成したい
		spaces = panels.findSpaces(height, width);
	}
	
	@Override
	public String toString() {
		return panels.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((panels == null) ? 0 : panels.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
		return result;
	}

}
