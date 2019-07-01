package com.example.slidesoccer.domain.model.field;

import java.util.List;

import com.example.slidesoccer.domain.model.move.Move;
import com.example.slidesoccer.domain.model.move.Moves;
import com.example.slidesoccer.domain.model.panel.GeneralPanels;
import com.example.slidesoccer.domain.model.panel.GoalPanel;
import com.example.slidesoccer.domain.model.panel.SmallPanel;
import com.example.slidesoccer.domain.model.panel.TallPanel;
import com.example.slidesoccer.domain.model.panel.WidePanel;
import com.example.slidesoccer.domain.model.space.Spaces;
import com.example.slidesoccer.domain.type.Height;
import com.example.slidesoccer.domain.type.Width;
import com.example.slidesoccer.domain.type.position.Position;

public class Field {
	Height height;
	Width width;

	GeneralPanels panels;
//	List<SmallPanel> smallPanels;
//	List<TallPanel> tallPanels;
//	List<WidePanel> widePanels;
//	GoalPanel goalPanel;
	Spaces spaces;

	public Field(FieldBuilder builder) {
		this.height = builder.height;
		this.width = builder.width;
		
		panels = new GeneralPanels(
				builder.smallPanels
				, builder.tallPanels
				, builder.widePanels
				, builder.goalPanel);
		
//		this.smallPanels = builder.smallPanels;
//		this.tallPanels = builder.tallPanels;
//		this.widePanels = builder.widePanels;
//		this.goalPanel = builder.goalPanel;
//		
//		this.panels.addAll(this.smallPanels);
//		this.panels.addAll(this.tallPanels);
//		this.panels.addAll(this.widePanels);
//		this.panels.add(this.goalPanel);
		
		spaces = panels.findSpaces(height, width);
//		System.out.println(spaces.toString());
	}
//	public void setSmallPanel(int x, int y) {
////		cubes.add(new SmallCube(new Coordinate(1, 1)));
//	}
//	public void setGoalPanel(Position position) {
//		this.goalPanel = new GoalPanel(position);
//	}
	public boolean isGoal() {
		return panels.isGoal();
//		return goalPanel.isGoal();
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
		//remove:smallpanel
		//remove:space
		//add:smallpanel
		//add:space
		panels.move(move, spaces);
		spaces = panels.findSpaces(height, width);
	}
	
	@Override
	public String toString() {
		return panels.toString();
	}
	

}
